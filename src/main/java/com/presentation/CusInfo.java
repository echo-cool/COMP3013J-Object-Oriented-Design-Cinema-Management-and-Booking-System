package com.presentation;

import java.time.LocalTime;

class CusInfo {
  String    name;
  LocalTime time;
  int screen;

  CusInfo(String movie_name, LocalTime t, int screen) {
    name = movie_name;
    time = t;
    this.screen = screen;
  }

}
