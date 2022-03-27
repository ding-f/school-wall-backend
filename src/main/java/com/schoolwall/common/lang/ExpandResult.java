package com.schoolwall.common.lang;

import com.schoolwall.entity.Expand;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 安康学院校园墙后端
 * </p>
 *
 * @author fuding 铸鼎_ Blog: https://ding-f.gitee.io/
 * @since 2022 2022/2/23 3:30 PM
 */

@Data
public class ExpandResult implements Serializable {

    String  zanImageurl;
    List<Expand> swipe_nav;
    List<Expand> selected_nav;


}
