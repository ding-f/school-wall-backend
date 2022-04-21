package com.schoolwall.shiro;

import cn.hutool.json.JSONUtil;
import com.schoolwall.common.lang.Result;
import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;
import com.schoolwall.util.JwtUtil;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 安康学院校园墙后端
 * </p>
 *
 * @author fuding 铸鼎_ Blog: https://ding-f.gitee.io/
 * @since 2022 2022/4/14 11:25
 */

@Component
//JwtFilter明显继承的是org.apache.shiro.web.filter.authc.AuthenticatingFilter，这个过滤器原本是Session的，重写了内部方法，让Jwt方式进行处理。
public class JwtFilter extends AuthenticatingFilter {

    @Autowired
    JwtUtil jwtUtil;



    @Override
    //拦截用户请求，获取JWT
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest userRequest= (HttpServletRequest) request;
        //获取jwt，放在Http协议的头部的"Authorization"
        String jwt=userRequest.getHeader("Authorization");

        if (StringUtils.isEmpty(jwt)) return null;

        return new JwtToken(jwt);
    }

    @Override
    //获取到JWT（null or String）
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest userRequest= (HttpServletRequest) request;
        String jwt=userRequest.getHeader("Authorization");

        //如果登录时候还没有JWT，直接放行访问API
        if (StringUtils.isEmpty(jwt)) {
            return true;
        } else {    //有jwt

            //解析jwt
            Claims claim = jwtUtil.getClaimByToken(jwt);
            //jwt解析失败或者已经过了保质期
            if(claim==null || jwtUtil.isTokenExpired(claim.getExpiration())){
                throw new ExpiredCredentialsException("token失效，请重新登录");
            }

        }

        //jwt没有失效且合法,直接调用Shiro进行登录
        return executeLogin(request,response);
    }

    //登录失败时处理失败时候的异常，返回异常的原因打印输出
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletResponse httpServletResponse=(HttpServletResponse) response;

        Throwable throwable=e.getCause()==null ? e:e.getCause();
        Result result=Result.fail(throwable.getMessage());
        String jsonfailmess= JSONUtil.toJsonStr(result);

        try{
            httpServletResponse.getWriter().print(jsonfailmess);
        }catch (IOException ioException){

        }
        return false;
    }

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {

        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个OPTIONS请求，这里我们给OPTIONS请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(org.springframework.http.HttpStatus.OK.value());
            return false;
        }

        return super.preHandle(request, response);
    }
}
