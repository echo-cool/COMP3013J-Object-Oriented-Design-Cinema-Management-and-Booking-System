package com.application.db.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ScreeningDAO {
    //This is a database access object for the Movie table
    //This object is a direct mapping for the row in the database and only used in mappers for query.
    //The reason we have this class is that DAO is required for the using of mybatis.
    //The real model and persistent models are in the model package
    private Integer id;

    private Integer movieId;

    private Integer screenId;

    private String date;

    private String startTime;

    private Integer ticketSold;

//    private MovieDAO movieDAO;
//
//    private ScreenDAO screenDAO;

    public ScreeningDAO() {
    }

    public ScreeningDAO(LocalDate date, LocalTime start_time, int i, MovieDAO movieDAO, ScreenDAO screenDAO) {
        this.date = date.format(DateTimeFormatter.ISO_DATE);
        this.startTime = start_time.format(DateTimeFormatter.ISO_TIME);
        this.ticketSold = i;
        this.movieId = movieDAO.getId();
        this.screenId = screenDAO.getId();
//        this.movieDAO = movieDAO;
//        this.screenDAO = screenDAO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
//        this.movieDAO =new MovieMapperImpl().getMovieForOid(movieId);
    }

    public Integer getScreenId() {
        return screenId;
    }

    public void setScreenId(Integer screenId) {
        this.screenId = screenId;
//        this.screenDAO =new ScreenMapperImpl().getScreenForOid(screenId);
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Integer getTicketSold() {
        return ticketSold;
    }

    public void setTicketSold(Integer ticketSold) {
        this.ticketSold = ticketSold;
    }

    /**
     * toString
     *
     * @return String String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", movieId=").append(movieId);
        sb.append(", screenId=").append(screenId);
        sb.append(", date=").append(date);
        sb.append(", startTime=").append(startTime);
        sb.append(", ticketSold=").append(ticketSold);
        sb.append("]");
        return sb.toString();
    }

    /**
     * equals
     *
     * @param that that
     * @return boolean boolean
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ScreeningDAO other = (ScreeningDAO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getMovieId() == null ? other.getMovieId() == null : this.getMovieId().equals(other.getMovieId()))
                && (this.getScreenId() == null ? other.getScreenId() == null : this.getScreenId().equals(other.getScreenId()))
                && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
                && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
                && (this.getTicketSold() == null ? other.getTicketSold() == null : this.getTicketSold().equals(other.getTicketSold()));
    }

    /**
     * hashCode
     *
     * @return int int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMovieId() == null) ? 0 : getMovieId().hashCode());
        result = prime * result + ((getScreenId() == null) ? 0 : getScreenId().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getTicketSold() == null) ? 0 : getTicketSold().hashCode());
        return result;
    }
}