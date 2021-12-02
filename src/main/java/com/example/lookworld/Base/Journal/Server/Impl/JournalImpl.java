package com.example.lookworld.Base.Journal.Server.Impl;

import com.example.lookworld.Base.Journal.Entry.JournalEntry;
import com.example.lookworld.Base.Journal.Mapper.JournalMapper;
import com.example.lookworld.Base.Journal.Server.JournalServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JournalImpl implements JournalServer {

    @Resource
    JournalMapper journalMapper;
    @Override
    public void insertJournal(JournalEntry journalEntry) {
        journalMapper.insert(journalEntry);
    }
}
