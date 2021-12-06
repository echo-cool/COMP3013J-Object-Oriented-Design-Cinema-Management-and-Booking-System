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
        Movie movie=cinema.getMovie(movie_name);
        if(checkOverlapScreening(date,start_time,screen_no,movie.getDuration())){
            observerMessage("overlap",false);
            return false;
        }else{
            cinema.scheduleScreening(date,start_time,screen_no,movie_name);
            return true;
        }
    }

    public boolean updateSelected(LocalTime time,int screen_no){
        if(checkOverlapScreening(selectedScreening.getDate(),time,screen_no,selectedScreening.getMovie().getDuration())){
            observerMessage("overlap",false);
            return false;
        }else{
            selectedScreening.setStartTime(time);
            cinema.updateScreening(selectedScreening);
            notifyObservers();
            return true;
        }
    }

    public boolean removeScreening(Screening screening){
        cinema.deleteScreening(screening);
    }

    public boolean cancelSelected(){
        if(observerMessage("cancel?",true)){
            if (selectedScreening.getTicketSold()>0){
                notifyObservers();
                return false;
            }else{
                boolean temp=removeScreening(selectedScreening);
                notifyObservers();
                return temp;
            }
        }return false;
    }

    private boolean checkInsufficientTicket(Screening screening,int num){
        return screening.getScreen().getCapacity() - screening.getTicketSold() -num < 0;
    }

    private boolean checkOverlapScreening(LocalDate date,LocalTime start_time,int screen_no,int duration){
        Screening[] screenings=cinema.getScreenings(date);
        for(Screening screening:screenings){
            if(screening.getScreen().getId()==screen_no){
                LocalTime over_time=start_time.plusSeconds(duration);
                if(over_time.isBefore(screening.getStartTime())||start_time.isAfter(screening.getStartTime().plusSeconds(screening.getMovie().getDuration()))){

                }else{
                    return false;
                }
            }
        }
        return true;
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
