package com.example.lookworld.Base.Role.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lookworld.Base.Role.Entry.RoleEntry;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper extends BaseMapper<RoleEntry> {
}
