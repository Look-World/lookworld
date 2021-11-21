package com.example.lookworld.Basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicEntry {

    //创建人
    private String createMan;

    //创建时间
    private Date createTime;

    //更新人
    private String updateMan;

    //更新时间
    private Date updateTime;

    //删除人
    private String deleteMan;

    //删除时间
    private Date deleteTime;


}
