package com.util;

import com.application.db.mappers.MovieMapperImpl;
import com.application.db.mappers.ScreenMapperImpl;
import com.application.db.mappers.ScreeningMapperImpl;
import com.application.models.Screen;

import java.time.LocalDate;
import java.time.LocalTime;

public class Test {
    public static void main(String[] args) {
        ScreeningMapperImpl screeningMapper=new ScreeningMapperImpl();
        ScreenMapperImpl screenMapper=new ScreenMapperImpl();
        MovieMapperImpl movieMapper=new MovieMapperImpl();
        screeningMapper.scheduleScreening(LocalDate.now(), LocalTime.now(),screenMapper.getScreenForOid(2),movieMapper.getMovie("haha0"));
    }
}
