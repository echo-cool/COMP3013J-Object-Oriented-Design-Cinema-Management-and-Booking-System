package com.application.models;

/**
 * @Author: WangYuyang
 * @Date: 2021/12/9-17:00
 * @Project: comp3013j_assignment
 * @Package: com.application.models
 * @Description:
 **/
public class Movie {
    private String name;
    private Integer duration;

    public Movie(String name, Integer duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public Integer getDuration() {
        return duration;
    }
}
