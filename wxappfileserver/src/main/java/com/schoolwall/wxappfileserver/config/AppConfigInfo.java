package com.schoolwall.wxappfileserver.config;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 安康学院校园墙后端
 * </p>
 *
 * @author fuding 铸鼎_ Blog: https://ding-f.gitee.io/
 * @since 2022 2022/5/12 13:58
 */


@Data
@Component
@ConfigurationProperties(prefix = "schoolwall-fs.hostinfo")
public class AppConfigInfo {

    private String protocol;

    private String hostname;



}
