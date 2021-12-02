package com.example.lookworld.Base.Journal.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lookworld.Base.Journal.Entry.JournalEntry;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JournalMapper extends BaseMapper<JournalEntry> {
}
