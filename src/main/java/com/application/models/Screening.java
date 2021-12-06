package com.application.models;


import java.time.LocalDate;
import java.time.LocalTime;

/**
* @generated
*/
public class Screening {

    int id;
    LocalDate date;
    LocalTime start_time;
    int ticket_sold;
    Movie movie;
    Screen screen;

    public Screening(LocalDate date, LocalTime start_time, int ticket_sold, Movie m, Screen s){
        this.date=date;
        this.start_time=start_time;
        this.ticket_sold=ticket_sold;
        this.movie=m;
        this.screen=s;
    }


    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public LocalTime getStartTime() {
        return start_time;
    }

    public int getTicketSold() {
        return ticket_sold;
    }

    public void setStartTime(LocalTime start_time) {
        this.start_time = start_time;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void changeTicketSold(int newTicketSold){
        this.ticket_sold=newTicketSold;
    }
}
