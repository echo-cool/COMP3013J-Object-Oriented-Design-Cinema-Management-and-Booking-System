package com.application.domain;


import com.application.domain.mappers.MovieMapper;
import com.application.domain.mappers.ScreenMapper;
import com.application.domain.mappers.ScreeningMapper;
import com.application.models.Movie;
import com.application.models.Screen;
import com.application.models.Screening;

import java.time.LocalDate;
import java.time.LocalTime;

/**
* @generated
*/
public class Cinema {
    
    MovieMapper movieMapper;
    ScreenMapper screenMapper;
    ScreeningMapper screeningMapper;

    public void scheduleScreening(LocalDate date, LocalTime start_time,int screen_no,String movie_name){
        Screen screen=screenMapper.getScreenForOid(screen_no);
        Movie movie=movieMapper.getMovie(movie_name);
        screeningMapper.scheduleScreening(date,start_time,screen,movie);
    }

    public void updateScreening(Screening selected){
        screeningMapper.updateScreening(selected);
    }

    public void deleteScreening(Screening screening){
        screeningMapper.deleteScreening(screening);
    }

    public Movie getMovie(int mno){
        return movieMapper.getMovieForOid(mno);
    }

    public Screen getScreen(int sno){
        return screenMapper.getScreenForOid(sno);
    }

    public Screening getScreenings
    
}
