package com.cybertek.services;

import com.cybertek.interfaces.ExtraSession;
import org.springframework.stereotype.Component;

public class OfficeHours implements ExtraSession {
    @Override
    public int getHours() {
        return 10;
    }
}
