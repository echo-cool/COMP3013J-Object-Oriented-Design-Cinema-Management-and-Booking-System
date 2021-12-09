package com.application.db;

import com.application.db.mappers.MovieMapperImpl;
import com.application.db.mappers.ScreenMapperImpl;
import com.application.db.mappers.ScreeningMapperImpl;
import com.application.db.dao.MovieDAO;

/**
 * @Author: WangYuyang
 * @Date: 2021/12/7-13:08
 * @Project: comp3013j_assignment
 * @Package: com.application.db
 * @Description:
 **/
public class DB_TEST {
    public static void main(String[] args) {
        MovieMapperImpl movieMapper = new MovieMapperImpl();
        ScreeningMapperImpl screeningMapper = new ScreeningMapperImpl();
        ScreenMapperImpl screenMapper = new ScreenMapperImpl();

        MovieDAO movieDAO = new MovieDAO();
        movieDAO.setName("haha");
        movieDAO.setDuration(90);
        movieMapper.addMovie(movieDAO);
    }
}
