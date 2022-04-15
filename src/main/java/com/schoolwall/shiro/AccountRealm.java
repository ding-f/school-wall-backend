package com.schoolwall.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.schoolwall.entity.User;
import com.schoolwall.service.UserService;
import com.schoolwall.util.JwtUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountRealm extends AuthorizingRealm {

    /**
     *
     */
    @Autowired
    JwtUtil jwtUtil;        //自定义

    @Autowired
    UserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }       //JwtToken自定义

    //授权管理
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    //身份验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //token本来就是JwtToken子类的，才可向下转型，访问子类的独有方法
        JwtToken jwtToken = (JwtToken) token;

        //(String) jwtToken.getPrincipal()得到JWT的字符串再将字符串JWT放入jwtUtils.getClaimByToken(String token),解析出Subject即UserID
        String userId = jwtUtil.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();

        User user = userService.getById(Long.valueOf(userId));
        if (user == null) {
            throw new UnknownAccountException("账户不存在");
        }

        if (user.getEnable().equals("0")) {
            throw new LockedAccountException("账户已被锁定");
        }

        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user, profile);

        return new SimpleAuthenticationInfo(profile, jwtToken.getCredentials(), getName());
    }
}

