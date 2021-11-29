package com.example.lookworld.Base.Login.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lookworld.Base.Login.Entry.UserEntry;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntry> {
}
