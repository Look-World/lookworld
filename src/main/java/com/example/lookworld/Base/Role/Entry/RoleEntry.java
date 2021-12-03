package com.example.lookworld.Base.Role.Entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("role")
public class RoleEntry {
    //主键id
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    //权限名中文
    @NotNull(message = "权限名中文 不可为空")
    private String roleName;
    //权限名（英文）
    @NotNull(message = "权限名（英文）不可为空")
    private String roleAlias;
    //排序
    @NotNull(message = "排序 不可为空")
    private String sort;
    //是否删除
    private int isDelete;
}
