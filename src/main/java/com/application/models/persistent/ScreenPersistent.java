package com.application.models.persistent;

import com.application.models.Screen;

/**
 * @Author: WangYuyang
 * @Date: 2021/12/9-17:35
 * @Project: comp3013j_assignment
 * @Package: com.application.models.persistent
 * @Description:
 **/
public class ScreenPersistent extends Screen {
    // A persistent screen is a screen that is stored in the database
    private Integer id; // The id of the screen in the database

    public ScreenPersistent(String name, Integer capacity, Integer id) {
        super(name, capacity);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
