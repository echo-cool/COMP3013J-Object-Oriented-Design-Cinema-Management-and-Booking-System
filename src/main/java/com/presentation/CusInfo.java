package com.presentation;

import java.time.LocalTime;

class CusInfo {
    private String name;
    private LocalTime time;
    private int screen;

    CusInfo(String movie_name, LocalTime t, int screen) {
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
