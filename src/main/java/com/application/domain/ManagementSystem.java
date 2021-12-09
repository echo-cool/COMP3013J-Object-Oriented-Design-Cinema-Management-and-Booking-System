package com.application.domain;

import com.application.db.dao.MovieDAO;
import com.application.db.dao.ScreenDAO;
import com.application.db.dao.ScreeningDAO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

/**
 * @generated
 */
public class ManagementSystem {
    private static ManagementSystem uniqueInstance = null;
    private LocalDate currentDate;
    private final LinkedList<ScreeningObserver> observers = new LinkedList<>();
    private ScreeningDAO[] displayScreeningDAOS;
    private ScreeningDAO selectedScreeningDAO;
    private final Cinema cinema = new Cinema();

    public ManagementSystem() {
    }

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
        for (ScreeningObserver observer : observers) {
            observer.update();
        }
    }

    public boolean observerMessage(String message, boolean isConfirmation) {
        return observers.get(0).message(message, isConfirmation);
    }

    public boolean addMovie(MovieDAO movieDAO) {
        return cinema.addMovie(movieDAO);
    }

    public boolean sellTicket(int num) {
        if (selectedScreeningDAO == null) {
            observerMessage("Sorry you have not chosen a screening yet!", true);
            return false;
        } else {
            int ticket_sold = selectedScreeningDAO.getTicketSold();
            if (!checkInsufficientTicket(selectedScreeningDAO, num)) {
                selectedScreeningDAO.setTicketSold(ticket_sold + num);
                cinema.updateScreening(selectedScreeningDAO);
                notifyObservers();
                return true;
            } else {
                observerMessage("Sorry no sufficient tickets!", true);
                return false;
            }
        }
    }

    public boolean scheduleScreening(LocalDate date, LocalTime start_time, int screen_no, String movie_name) {
        MovieDAO movieDAO = cinema.getMovie(movie_name);
        selectedScreeningDAO =null;
        if (movieDAO != null) {
            // in this system, we do not allow screening to be scheduled spanning different days
            int durationHour = movieDAO.getDuration() / 3600;
            int durationSec = movieDAO.getDuration() % 3600;
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
            if (checkOverlapScreening(date, start_time, screen_no, movieDAO.getDuration())) {
                observerMessage("Sorry the intended screening overlaps with the current one!", false);
                return false;
            }
            else {
                cinema.scheduleScreening(date, start_time, screen_no, movie_name);
                setDate(date);
                notifyObservers();
                return true;
            }
        }
        return false;
    }

    public boolean updateSelected(LocalTime time, int screen_no) {
        if (checkOverlapScreening(LocalDate.parse(selectedScreeningDAO.getDate()), time, screen_no, selectedScreeningDAO.getMovie().getDuration())) {
            observerMessage("Sorry the intended screening overlaps with the current one!", false);
        } else if (selectedScreeningDAO.getTicketSold() > 0) {
            observerMessage("Sorry you cannot reschedule a screening with tickets sold!", false);
        } else {
            if (observerMessage("Are you sure to reschedule this screening?", true)) {
                selectedScreeningDAO.setStartTime(time.toString());
                selectedScreeningDAO.setScreenId(screen_no);
                cinema.updateScreening(selectedScreeningDAO);
                notifyObservers();
                return true;
            }
        }
        return false;
    }

    public boolean removeScreening(ScreeningDAO screeningDAO) {
        cinema.deleteScreening(screeningDAO);
        return true;
    }

    public boolean cancelSelected() {
        if (selectedScreeningDAO == null) {
            observerMessage("Sorry you have not chosen a screening yet!", false);
            notifyObservers();
            return false;
        } else {
            if (selectedScreeningDAO.getTicketSold() > 0) {
                observerMessage("Sorry you cannot cancel this screening with tickets sold!", false);
                notifyObservers();
                return false;
            } else {
                if (observerMessage("Are you sure to cancel this screening?", true)) {
                    boolean temp = removeScreening(selectedScreeningDAO);
                    setDate(currentDate);
                    notifyObservers();
                    return temp;
                }
            }
        }
        return false;
    }

    private boolean checkInsufficientTicket(ScreeningDAO screeningDAO, int num) {
        return screeningDAO.getScreen().getCapacity() - screeningDAO.getTicketSold() - num < 0;
    }

    private boolean checkOverlapScreening(LocalDate date, LocalTime start_time, int screen_no, int duration) {
        ScreeningDAO[] screeningDAOS = cinema.getScreenings(date);
        for (ScreeningDAO screeningDAO : screeningDAOS) {
            if (screeningDAO.getScreen().getId() == screen_no) {
                LocalTime over_time = start_time.plusSeconds(duration);
                if (over_time.isBefore(LocalTime.parse(screeningDAO.getStartTime())) || start_time.isAfter(LocalTime.parse(screeningDAO.getStartTime()).plusSeconds(screeningDAO.getMovie().getDuration()))) {

                } else {
                    if (selectedScreeningDAO != null) {
                        if (screeningDAO.getId().equals(selectedScreeningDAO.getId())) {
                            continue;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void setDate(LocalDate date) {
        this.currentDate = date;
        displayScreeningDAOS = cinema.getScreenings(date);
        System.out.println(displayScreeningDAOS.length);
        notifyObservers();
    }

    public ScreeningDAO getSelectedScreening() {
        return selectedScreeningDAO;
    }

    public void changeSelected(LocalTime time, int screen) {
        label:
        {
            for (ScreeningDAO screeningDAO : displayScreeningDAOS) {
                if (screen == (screeningDAO.getScreen().getId())) {
                    if (LocalTime.parse(screeningDAO.getStartTime()).isBefore(time) && LocalTime.parse(screeningDAO.getStartTime()).plusSeconds(screeningDAO.getMovie().getDuration()).isAfter(time)) {
                        selectedScreeningDAO = screeningDAO;
                        break label;
                    }
                }
            }
            selectedScreeningDAO = null;
        }
        notifyObservers();
    }

    public ScreeningDAO[] getScreenings() {
        return displayScreeningDAOS;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public MovieDAO[] getAllMovies() {
        return cinema.getMovies();
    }

    public ScreenDAO[] getScreens() {
        return cinema.getScreens();
    }


}
