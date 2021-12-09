package com.application.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * @Author: WangYuyang
 * @Date: 2021/12/9-17:00
 * @Project: comp3013j_assignment
 * @Package: com.application.models
 * @Description:
 **/
public class Screening {
    private LocalTime startTime;
    private LocalDate date;
    private Integer ticketSold;
    private Movie movie;
    private Screen screen;

    public Screening(LocalTime startTime, LocalDate date, Integer ticketSold, Movie movie, Screen screen) {
        this.startTime = startTime;
        this.date = date;
        this.ticketSold = ticketSold;
        this.movie = movie;
        this.screen = screen;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getTicketSold() {
        return ticketSold;
    }

    public void setTicketSold(Integer ticketSold) {
        this.ticketSold = ticketSold;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Screening screening = (Screening) o;
        return startTime.equals(screening.startTime) && date.equals(screening.date) && ticketSold.equals(screening.ticketSold) && movie.equals(screening.movie) && screen.equals(screening.screen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, date, ticketSold, movie, screen);
    }
}
