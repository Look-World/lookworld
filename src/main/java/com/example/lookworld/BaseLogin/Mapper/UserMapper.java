package com.example.lookworld.BaseLogin.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lookworld.BaseLogin.Entry.UserEntry;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntry> {
}
