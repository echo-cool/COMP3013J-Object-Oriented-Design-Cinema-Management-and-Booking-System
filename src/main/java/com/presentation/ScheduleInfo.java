package com.presentation;

import java.time.LocalTime;

class ScheduleInfo {
    private final String name;
    private final LocalTime time;
    private final String screen;

    ScheduleInfo(String movie_name, LocalTime t, String screen) {
        this.name = movie_name;
        this.time = t;
        this.screen = screen;
    }

    public String getName() {
        return name;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getScreen() {
        return screen;
    }
}
