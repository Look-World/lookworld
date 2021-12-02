package com.example.lookworld.Base.Journal.Server;

import com.example.lookworld.Base.Journal.Entry.JournalEntry;
import com.example.lookworld.My.MyRuturn.R;

public interface JournalServer {


    /**
     * 日志
     * @param journalEntry
     */
    void insertJournal(JournalEntry journalEntry);
}
