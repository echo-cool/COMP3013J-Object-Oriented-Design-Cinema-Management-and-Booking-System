package com.application.domain;


import com.application.domain.mappers.MovieMapper;
import com.application.domain.mappers.ScreenMapper;
import com.application.domain.mappers.ScreeningMapper;

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

    }
    
}
