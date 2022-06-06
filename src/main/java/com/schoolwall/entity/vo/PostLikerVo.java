package com.schoolwall.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 安康学院校园墙后端
 * </p>
 *
 * @author fuding 铸鼎_ Blog: https://ding-f.gitee.io/
 * @since 2022 2022/5/29 10:51
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PostLikerVo {
    private Long likerUid;
    private String  likerWxName;
    private String likerAvatUrl;
    private String likerEnable;
    private String likerRole;
}
