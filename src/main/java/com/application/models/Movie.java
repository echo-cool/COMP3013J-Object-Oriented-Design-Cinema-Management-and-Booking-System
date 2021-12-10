package com.application.models;

/**
 * @Author: WangYuyang
 * @Date: 2021/12/9-17:00
 * @Project: comp3013j_assignment
 * @Package: com.application.models
 * @Description:
 **/
public class Movie {
    private String name; // name of the movie
    private Integer duration; // duration of the movie

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

    @Override
    public boolean equals(Object o) {
        //Check if two movie object contains the same information
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (name != null ? !name.equals(movie.name) : movie.name != null) return false;
        return duration != null ? duration.equals(movie.duration) : movie.duration == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        return result;
    }
}
