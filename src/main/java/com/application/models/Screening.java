package com.application.models;

/**
 * @Author: WangYuyang
 * @Date: 2021/12/9-17:00
 * @Project: comp3013j_assignment
 * @Package: com.application.models
 * @Description:
 **/
public class Screening {
    private String startTime;
    private String date;
    private Integer ticketSold;
    private Movie movie;
    private Screen screen;

    public Screening(String startTime, String date, Integer ticketSold, Movie movie, Screen screen) {
        this.startTime = startTime;
        this.date = date;
        this.ticketSold = ticketSold;
        this.movie = movie;
        this.screen = screen;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getDate() {
        return date;
    }

    public Integer getTicketSold() {
        return ticketSold;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTicketSold(Integer ticketSold) {
        this.ticketSold = ticketSold;
    }
}
