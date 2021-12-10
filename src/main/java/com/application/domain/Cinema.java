package com.application.domain;

import com.application.db.mappers.MovieMapperImpl;
import com.application.db.mappers.ScreenMapperImpl;
import com.application.db.mappers.ScreeningMapperImpl;
import com.application.models.Movie;
import com.application.models.Screen;
import com.application.models.Screening;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @generated
 */
public class Cinema {
    MovieMapperImpl movieMapper = new MovieMapperImpl();
    ScreenMapperImpl screenMapper = new ScreenMapperImpl();
    ScreeningMapperImpl screeningMapper = new ScreeningMapperImpl();

    Screen[] screens=null;

    public void scheduleScreening(LocalDate date, LocalTime start_time, String screen_name, String movie_name) {
        Screen screen = screenMapper.getScreenForName(screen_name);
        Movie movie = movieMapper.getMovie(movie_name);
        screeningMapper.scheduleScreening(date, start_time, screen, movie);
    }

    public void updateScreening(Screening selected) {
        screeningMapper.updateScreening(selected);
    }

    public void deleteScreening(Screening screeningDAO) {
        screeningMapper.deleteScreening(screeningDAO);
    }

    public Movie getMovie(String name) {
        return movieMapper.getMovie(name);
    }

    public Screen getScreen(int sno) {
        return screenMapper.getScreenForOid(sno);
    }

    public Screening[] getScreenings(LocalDate date) {
        return screeningMapper.getScreenings(date);
    }

    public Screen[] getScreens() {
        if (screens==null){
            screens=screenMapper.getScreens();
        }
        return screens;
    }

    public boolean addMovie(Movie movie) {
        return movieMapper.addMovie(movie);
    }

    public Movie[] getMovies() {
        return movieMapper.getMovies();
    }


}
