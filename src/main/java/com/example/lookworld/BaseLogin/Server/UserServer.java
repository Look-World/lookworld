package com.example.lookworld.BaseLogin.Server;

import com.example.lookworld.BaseLogin.Entry.UserEntry;
import com.example.lookworld.My.MyRuturn.R;

public interface UserServer {

    R login(UserEntry userEntry,String ip);
}
