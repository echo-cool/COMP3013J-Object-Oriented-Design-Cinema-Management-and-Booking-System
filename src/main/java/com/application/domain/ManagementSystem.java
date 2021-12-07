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
    Screening[] displayScreenings;
    Screening selectedScreening;
    Cinema cinema=new Cinema();

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
            selectedScreening.setTicketSold(ticket_sold+num);
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
        if(checkOverlapScreening(LocalDate.parse(selectedScreening.getDate()),time,screen_no,selectedScreening.getMovie().getDuration())){
            observerMessage("overlap",false);
            return false;
        }else{

            if(observerMessage("ReSchedule?",true)) {
                selectedScreening.setStartTime(time.toString());
                selectedScreening.setScreenId(screen_no);
                cinema.updateScreening(selectedScreening);
                notifyObservers();
                return true;
            }
            return false;
        }
    }

    public boolean removeScreening(Screening screening){
        cinema.deleteScreening(screening);
        return true;
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
                if(screen_no==selectedScreening.getScreenId()||over_time.isBefore(LocalTime.parse(screening.getStartTime()))||start_time.isAfter(LocalTime.parse(screening.getStartTime()).plusSeconds(screening.getMovie().getDuration()))){

                }else{
                    return true;
                }
            }
        }
        return false;
    }

    public void setDate(LocalDate date){
        this.currentDate=date;
        displayScreenings=cinema.getScreenings(date);
        System.out.println(displayScreenings.length);
        notifyObservers();
    }

    public Screening getSelectedScreening(){
        return selectedScreening;
    }

    public void changeSelected(LocalTime time, int screen){
        label:
        {
            for (Screening screening : displayScreenings) {
                if (screen==(screening.getScreen().getId())) {
                    if (LocalTime.parse(screening.getStartTime()).isBefore(time) && LocalTime.parse(screening.getStartTime()).plusSeconds(screening.getMovie().getDuration()).isAfter(time)) {
                        selectedScreening = screening;
                        break label;
                    }
                }
            }
            selectedScreening=null;
        }
        notifyObservers();
    }

    public Screening[] getScreenings(){
        return displayScreenings;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }


}
