package com.application.models.persistent;

import com.application.models.Movie;
import com.application.models.Screen;
import com.application.models.Screening;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @Author: WangYuyang
 * @Date: 2021/12/9-17:02
 * @Project: comp3013j_assignment
 * @Package: com.application.models
 * @Description:
 **/
public class ScreeningPersistent extends Screening {
    //A persistent screening is a screening that is stored in the database
    private Integer id;

    public ScreeningPersistent(LocalTime startTime, LocalDate date, Integer ticketSold, Movie movie, Screen screen, Integer id) {
        super(startTime, date, ticketSold, movie, screen);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
