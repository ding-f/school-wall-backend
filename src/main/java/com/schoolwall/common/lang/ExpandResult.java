package com.schoolwall.common.lang;

import com.schoolwall.entity.Expand;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ExpandResult implements Serializable {

    String  zanImageurl;
    List<Expand> swipe_nav;
    List<Expand> selected_nav;


}
