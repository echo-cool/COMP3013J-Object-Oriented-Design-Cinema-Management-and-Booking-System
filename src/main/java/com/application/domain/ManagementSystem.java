package com.application.domain;

import com.application.models.Movie;
import com.application.models.Screening;

import java.time.LocalDate;
import java.util.LinkedList;

/**
* @generated
*/
public class ManagementSystem {
    LocalDate currentDate;
    LinkedList<ScreeningObserver> observers=new LinkedList<>();
    LinkedList<Screening> displayScreenings;
    Screening selectedScreening;
    Cinema cinema;

    public void addObserver(ScreeningObserver observer){
        observers.add(observer);
    }

    public void notifyObservers(){
        for (ScreeningObserver observer:observers){
            observer.update();
        }
    }

    public boolean observerMessage(String message,boolean isConfirmation){
        return observers.get(0).message(message,isConfirmation);
    }

    public boolean addMovie(Movie movie){
        return false;
    }

    public boolean sellTicket(int num){
        return false;
    }


}
