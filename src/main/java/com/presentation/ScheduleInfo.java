package com.presentation;

import java.time.LocalTime;

class ScheduleInfo {
    private final String name;
    private final LocalTime time;
    private final int screen;

    ScheduleInfo(String movie_name, LocalTime t, int screen) {
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

    public int getScreen() {
        return screen;
    }
}
