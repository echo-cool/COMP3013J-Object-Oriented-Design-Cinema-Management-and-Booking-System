package com.application.domain;

import com.application.models.Movie;
import com.application.models.Screen;
import com.application.models.Screening;

import java.time.LocalDate;
import java.time.LocalTime;
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
        return cinema.addMovie(movie);
    }


    public boolean sellTicket(int num){
        int capacity=selectedScreening.getScreen().getCapacity();
        int ticket_sold=selectedScreening.getTicketSold();
        if(!checkInsufficientTicket(selectedScreening,num)){
            selectedScreening.changeTicketSold(ticket_sold+num);
            cinema.updateScreening(selectedScreening);
            notifyObservers();
            return true;
        }else{
            observerMessage("no sufficient tickets!",true);
            return false;
        }

    }


    public boolean scheduleScreening(LocalDate date,LocalTime start_time,int screen_no,String movie_name){
        Screening screening=new Screening(date,start_time,0,)
        if(checkOverlapScreening(date,start_time,screen_no,))
    }

    public boolean updateSelected(LocalTime time,int screen_no){

    }

    public boolean removeScreening(int screen_no,LocalTime start_time){

    }

    public void cancelSelected(){

    }

    private boolean checkInsufficientTicket(Screening screening,int num){

    }

    private boolean checkOverlapScreening(LocalDate date,LocalTime start_time,int screen_no,int duration){

    }

    private boolean checkOverlapScreening(LocalDate date,LocalTime start_time,int sno,Screening screening){

    }

    public void setDate(LocalDate date){

    }

    public Screening getSelectedScreening(){
        return selectedScreening;
    }

    public void changeSelected(LocalTime startTime, Screen screen){

    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }


}
