package com.presentation;

import java.time.LocalTime;

class ScheduleInfo {
    private final String name;
    private final LocalTime time;
    private final String screenName;

    ScheduleInfo(String name, LocalTime time, String screenName) {
        this.name = name;
        this.time = time;
        this.screenName = screenName;
    }

    public String getName() {
        return name;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getScreenName() {
        return screenName;
    }
}
