package com.application.models;

/**
 * @Author: WangYuyang
 * @Date: 2021/12/9-17:02
 * @Project: comp3013j_assignment
 * @Package: com.application.models
 * @Description:
 **/
public class ScreeningPersistent extends Screening{
    private Integer id;

    public ScreeningPersistent(String startTime, String date, Integer ticketSold, Movie movie, Screen screen) {
        super(startTime, date, ticketSold, movie, screen);
    }

    public Integer getId() {
        return id;
    }
}
