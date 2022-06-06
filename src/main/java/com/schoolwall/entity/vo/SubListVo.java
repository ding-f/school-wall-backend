package com.schoolwall.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 安康学院校园墙后端
 * </p>
 *
 * @author fuding 铸鼎_ Blog: https://ding-f.gitee.io/
 * @since 2022 2022/5/28 12:18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SubListVo {
  private Long id;
  private String title;
  private Long userId;
  private String wxName;
  private LocalDateTime date;
}
