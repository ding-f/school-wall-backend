package com.schoolwall.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 安康学院校园墙后端
 * </p>
 *
 * @author fuding 铸鼎_ Blog: https://ding-f.gitee.io/
 * @since 2022 2022/6/25 20:30
 */

@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Value("${swagger.enabled}")
    Boolean swaggerEnabled;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .enable(swaggerEnabled)

                //定义界面显示配置JWT
                .securitySchemes(Collections.singletonList(apiKey()))
                //定义请求Header中的Authorization从哪获取JWT
                .securityContexts(Collections.singletonList(securityContext()))

                .select()
                //为当前包下controller生成API文档
//                .apis(RequestHandlerSelectors.basePackage("cn.dearth.controller"))
                //为有@Api注解的Controller生成API文档
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                // 过滤条件，扫描指定路径下的文件
//                .apis(RequestHandlerSelectors.basePackage("com.cunyu.springbootswagger3demo.controller"))
                //为有@ApiOperation注解的方法生成API文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 指定路径处理，PathSelectors.any()代表不过滤任何路径
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("铸鼎_", "https://ding-f.github.io/", "f_ding@126.com");
        return new ApiInfoBuilder()
                .title("AKU校园墙项目接口文档")
                .description("安康学院校园墙（前后端）")
                .contact(contact)
                .version("1.0")
                .build();
    }

    //界面显示内容定义
    private ApiKey apiKey() {

        return new ApiKey("Authorization", "JWT", "header");
    }

    //定义Header，定义一个名为Authorization的Key，其内容从ApiKey()获取
    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        //需要认证接口范围
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(new SecurityReference("Authorization", authorizationScopes));
    }


}
