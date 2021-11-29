package com.example.lookworld.My.MyBase;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntry implements Serializable {


    //主键id
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    //创建人
    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    //更新人
    @TableField(fill = FieldFill.UPDATE)
    private Long updateUser;

    //更新时间
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    //是否删除
    @TableField(fill = FieldFill.INSERT)
    private Integer isDelete;


}
