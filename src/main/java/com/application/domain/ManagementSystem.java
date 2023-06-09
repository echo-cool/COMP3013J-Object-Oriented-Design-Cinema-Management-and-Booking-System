package com.application.domain;

import com.application.models.Movie;
import com.application.models.Screen;
import com.application.models.Screening;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class ManagementSystem {
    private static ManagementSystem uniqueInstance = null; //ManagementSystem is a unique Instance
    private final LinkedList<ScreeningObserver> observers = new LinkedList<>();
    private final Cinema cinema = new Cinema();
    private LocalDate currentDate;
    private Screening[] displayScreenings;
    private Screening selectedScreening;

    public ManagementSystem() {
    }

    //Init signal instance.
    public static ManagementSystem getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ManagementSystem();
        }
        return uniqueInstance;
    }

    public void addObserver(ScreeningObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        //Notify all observers to update UI
        for (ScreeningObserver observer : observers) {
            observer.update();
        }
    }

    public boolean observerMessage(String message, boolean isConfirmation) {
        return observers.get(0).message(message, isConfirmation);
    }

    public boolean addMovie(Movie movie) {
        return cinema.addMovie(movie);
    }

    public boolean sellTicket(int num) {
        //sell a specific number of Ticket
        if (selectedScreening == null) {
            observerMessage("Sorry you have not chosen a screening yet!", true);
            return false;
        } else {
            int ticket_sold = selectedScreening.getTicketSold();
            if (!checkInsufficientTicket(selectedScreening, num)) {
                Screening old = new Screening(
                        LocalTime.parse(selectedScreening.getStartTime().format(DateTimeFormatter.ISO_TIME)),
                        LocalDate.parse(selectedScreening.getDate().format(DateTimeFormatter.ISO_DATE)),
                        selectedScreening.getTicketSold(),
                        new Movie(selectedScreening.getMovie().getName(), selectedScreening.getMovie().getDuration()),
                        new Screen(selectedScreening.getScreen().getName(), selectedScreening.getScreen().getCapacity())
                );
                selectedScreening.setTicketSold(ticket_sold + num);
                cinema.updateScreening(old, selectedScreening);
                notifyObservers();
                return true;
            } else {
                observerMessage("Sorry no sufficient tickets!", true);
                return false;
            }
        }
    }

    public boolean scheduleScreening(LocalDate date, LocalTime start_time, String screen_name, String movie_name) {
        Movie movie = cinema.getMovie(movie_name);
        selectedScreening = null;
        if (movie != null) {
            // in this system, we do not allow screening to be scheduled spanning different days
            int durationHour = movie.getDuration() / 3600;
            int durationSec = movie.getDuration() % 3600;
            String end_time = start_time.toString().split(":")[0];
            if (end_time.charAt(0) == '0') {
                if (Integer.parseInt(String.valueOf(end_time.charAt(0))) + durationHour > 24) {
                    observerMessage("Sorry you cannot schedule screening spanning different days!", false);
                    return false;
                }
            } else {
                if (Integer.parseInt(end_time) + durationHour > 24 || (Integer.parseInt(end_time) + durationHour == 24 && durationSec > 0)) {
                    observerMessage("Sorry you cannot schedule screening spanning different days!", false);
                    return false;
                }
            }
            if (checkOverlapScreening(date, start_time, screen_name, movie.getDuration())) {
                observerMessage("Sorry the intended screening overlaps with the current one!", false);
                return false;
            } else {
                cinema.scheduleScreening(date, start_time, screen_name, movie_name);
                setDate(date);
                notifyObservers();
                return true;
            }
        }
        return false;
    }

    public boolean updateSelected(LocalTime time, String screen_name) {
        if (checkOverlapScreening(selectedScreening.getDate(), time, screen_name, selectedScreening.getMovie().getDuration())) {
            observerMessage("Sorry the intended screening overlaps with the current one!", false);
        } else if (selectedScreening.getTicketSold() > 0) {
            observerMessage("Sorry you cannot reschedule a screening with tickets sold!", false);
        } else {
            if (observerMessage("Are you sure to reschedule this screening?", true)) {
                Screening old = new Screening(
                        LocalTime.parse(selectedScreening.getStartTime().format(DateTimeFormatter.ISO_TIME)),
                        LocalDate.parse(selectedScreening.getDate().format(DateTimeFormatter.ISO_DATE)),
                        selectedScreening.getTicketSold(),
                        new Movie(selectedScreening.getMovie().getName(), selectedScreening.getMovie().getDuration()),
                        new Screen(selectedScreening.getScreen().getName(), selectedScreening.getScreen().getCapacity())
                );
                selectedScreening.setStartTime(time);
                for (Screen screen : getScreens()) {
                    if (screen.getName().equals(screen_name)) {
                        selectedScreening.setScreen(screen);
                        break;
                    }
                }

                cinema.updateScreening(old, selectedScreening);
                notifyObservers();
                return true;
            }
        }
        return false;
    }

    public boolean removeScreening(Screening screening) {
        cinema.deleteScreening(screening);
        return true;
    }

    public boolean cancelSelected() {
        if (selectedScreening == null) {
            observerMessage("Sorry you have not chosen a screening yet!", false);
            notifyObservers();
            return false;
        } else {
            //Can only cancel a screening that has not been sold
            if (selectedScreening.getTicketSold() > 0) {
                observerMessage("Sorry you cannot cancel this screening with tickets sold!", false);
                notifyObservers();
                return false;
            } else {
                if (observerMessage("Are you sure to cancel this screening?", true)) {
                    boolean temp = removeScreening(selectedScreening);
                    setDate(currentDate);
                    notifyObservers();
                    return temp;
                }
            }
        }
        return false;
    }

    private boolean checkInsufficientTicket(Screening screening, int num) {
        //Check if there are enough tickets
        return screening.getScreen().getCapacity() - screening.getTicketSold() - num < 0;
    }

    private boolean checkOverlapScreening(LocalDate date, LocalTime start_time, String screen_name, int duration) {
//        Screening[] screenings = cinema.getScreenings(date);
        //Check if two screenings overlap
        Screening[] screenings = displayScreenings;
        for (Screening screening : screenings) {
            if (screening.getScreen().getName().equals(screen_name)) {
                LocalTime over_time = start_time.plusSeconds(duration - 1);
                if ((!over_time.isBefore(screening.getStartTime())) && (!start_time.isAfter(screening.getStartTime().plusSeconds(screening.getMovie().getDuration() - 1)))) {
                    if (selectedScreening != null) {
                        if (screening.equals(selectedScreening)) {
                            continue;
                        }
                    }
                    return true;
                } else {

                }
            }
        }
        return false;
    }


    public void setDate(LocalDate date) {
        this.currentDate = date;
        displayScreenings = cinema.getScreenings(date);
        System.out.println(displayScreenings.length);
        notifyObservers();
    }

    public Screening getSelectedScreening() {
        return selectedScreening;
    }

    public void changeSelected(LocalTime time, String screen) {
        label:
        {
            for (Screening screening : displayScreenings) {
                if (screen.equals(screening.getScreen().getName())) {
                    if (screening.getStartTime().isBefore(time) && screening.getStartTime().plusSeconds(screening.getMovie().getDuration()).isAfter(time)) {
                        selectedScreening = screening;
                        break label;
                    }
                }
            }
            selectedScreening = null;
        }
        notifyObservers();
    }

    public Screening[] getScreenings() {
        return displayScreenings;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public Movie[] getAllMovies() {
        return cinema.getMovies();
    }

    public Screen[] getScreens() {
        return cinema.getScreens();
    }

    public int findScreenIndex(String name) {
        for (int i = 0; i < getScreens().length; i++) {
            if (getScreens()[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }


}
