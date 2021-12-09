package com.application.models;

/**
 * @Author: WangYuyang
 * @Date: 2021/12/9-17:01
 * @Project: comp3013j_assignment
 * @Package: com.application.models
 * @Description:
 **/
public class MoviePersistent extends Movie{
    private Integer id;
    public MoviePersistent(String name, Integer duration) {
        super(name, duration);
    }

    public Integer getId() {
        return id;
    }
}
