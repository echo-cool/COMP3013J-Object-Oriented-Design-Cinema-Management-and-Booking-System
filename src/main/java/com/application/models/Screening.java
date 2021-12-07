package com.application.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Screening {
    int id;
    LocalDate date;
    LocalTime start_time;
    int ticket_sold;
    Movie movie;
    Screen screen;

    public Screening(LocalDate date,LocalTime start_time,int ticket_sold,Movie movie,Screen screen){
        this.date=date;
        this.start_time=start_time;
        this.ticket_sold=ticket_sold;
        this.movie=movie;
        this.screen=screen;
    }

    public void PersistentScreening(int oid,LocalDate date,LocalTime start_time,int ticket_sold,Movie movie,Screen screen){

    }

    public int getId() {
        return id;
    }

    public LocalTime getStart_time() {
        return start_time;
    }

    public int getTicket_sold() {
        return ticket_sold;
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

    public LocalDate getDate() {
        return date;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void changeTicketSold(int newTicketSold){
        this.ticket_sold=newTicketSold;
    }

    //    /**
//    * toString
//    * @return String String
//    */
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(getClass().getSimpleName());
//        sb.append(" [");
//        sb.append("Hash = ").append(hashCode());
//        sb.append(", id=").append(id);
//        sb.append(", movieId=").append(movieId);
//        sb.append(", screenId=").append(screenId);
//        sb.append(", date=").append(date);
//        sb.append(", startTime=").append(startTime);
//        sb.append(", ticketSold=").append(ticketSold);
//        sb.append("]");
//        return sb.toString();
//    }
//
//    /**
//    * equals
//    * @param that that
//    * @return boolean boolean
//    */
//    @Override
//    public boolean equals(Object that) {
//        if (this == that) {
//            return true;
//        }
//        if (that == null) {
//            return false;
//        }
//        if (getClass() != that.getClass()) {
//            return false;
//        }
//        Screening other = (Screening) that;
//        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
//            && (this.getMovieId() == null ? other.getMovieId() == null : this.getMovieId().equals(other.getMovieId()))
//            && (this.getScreenId() == null ? other.getScreenId() == null : this.getScreenId().equals(other.getScreenId()))
//            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
//            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
//            && (this.getTicketSold() == null ? other.getTicketSold() == null : this.getTicketSold().equals(other.getTicketSold()));
//    }
//
//    /**
//    * hashCode
//    * @return int int
//    */
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
//        result = prime * result + ((getMovieId() == null) ? 0 : getMovieId().hashCode());
//        result = prime * result + ((getScreenId() == null) ? 0 : getScreenId().hashCode());
//        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
//        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
//        result = prime * result + ((getTicketSold() == null) ? 0 : getTicketSold().hashCode());
//        return result;
//    }
}