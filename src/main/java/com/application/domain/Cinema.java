package com.application.domain;

import com.application.db.mappers.MovieMapperImpl;
import com.application.db.mappers.ScreenMapperImpl;
import com.application.db.mappers.ScreeningMapperImpl;
import com.application.db.dao.MovieDAO;
import com.application.db.dao.ScreenDAO;
import com.application.db.dao.ScreeningDAO;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @generated
 */
public class Cinema {
    MovieMapperImpl movieMapper = new MovieMapperImpl();
    ScreenMapperImpl screenMapper = new ScreenMapperImpl();
    ScreeningMapperImpl screeningMapper = new ScreeningMapperImpl();

    public void scheduleScreening(LocalDate date, LocalTime start_time, int screen_no, String movie_name) {
        ScreenDAO screenDAO = screenMapper.getScreenForOid(screen_no);
        MovieDAO movieDAO = movieMapper.getMovie(movie_name);
        screeningMapper.scheduleScreening(date, start_time, screenDAO, movieDAO);
    }

    public void updateScreening(ScreeningDAO selected) {
        screeningMapper.updateScreening(selected);
    }

    public void deleteScreening(ScreeningDAO screeningDAO) {
        screeningMapper.deleteScreening(screeningDAO);
    }

    public MovieDAO getMovie(int mno) {
        return movieMapper.getMovieForOid(mno);
    }

    public MovieDAO getMovie(String name) {
        return movieMapper.getMovie(name);
    }

    public ScreenDAO getScreen(int sno) {
        return screenMapper.getScreenForOid(sno);
    }

    public ScreeningDAO[] getScreenings(LocalDate date) {
        return screeningMapper.getScreenings(date);
    }

    public ScreenDAO[] getScreens() {
        return screenMapper.getScreens();
    }

    public boolean addMovie(MovieDAO movieDAO) {
        return movieMapper.addMovie(movieDAO);
    }

    public MovieDAO[] getMovies() {
        return movieMapper.getMovies();
    }


}
