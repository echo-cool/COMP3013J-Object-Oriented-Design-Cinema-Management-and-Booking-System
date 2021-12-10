package com.presentation;

import com.application.models.Movie;
import com.sun.javafx.collections.ObservableListWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.time.LocalTime;
import java.util.ArrayList;

@SuppressWarnings("restriction")
public class ScheduleDialog extends Dialog<ScheduleInfo> {

    //    private TextField nameField = new TextField();
    private final ObservableList<String> MovieNames = new ObservableListWrapper<>(new ArrayList<>());
    private final ChoiceBox<String> nameField = new ChoiceBox<String>(MovieNames);
    private final String[] times = {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"};
    private final ChoiceBox<String> timeBox = new ChoiceBox<String>(FXCollections.observableArrayList(times));
    private final String[] st = {"Screen 1", "Screen 2", "Screen 3", "Screen 4", "Screen 5", "Screen 6"};
    private final ChoiceBox<String> coversBox = new ChoiceBox<String>(FXCollections.observableArrayList(st));
    private final ButtonType buttonTypeOk = new ButtonType("Ok", ButtonData.OK_DONE);

    public ScheduleDialog(Movie[] movieDAOS) {
        this();
        MovieNames.clear();
        for (Movie movieDAO : movieDAOS) {
            MovieNames.add(movieDAO.getName());
        }
    }

    public ScheduleDialog() {
        super();
        Label moveName = new Label("Movie Name: ");
        Label time = new Label("Time: ");
        Label screen = new Label("Screen: ");
        getDialogPane().getButtonTypes().add(buttonTypeOk);

        setResultConverter(new Callback<ButtonType, ScheduleInfo>() {
            @Override
            public ScheduleInfo call(ButtonType b) {
                if (b == buttonTypeOk) {
                    return new ScheduleInfo(nameField.getValue(), LocalTime.parse(timeBox.getValue()), coversBox.getValue());
                }
                return null;
            }
        });
        setTitle("New Scheduled Screening");
        setHeaderText("Please enter the details for the newly scheduled screening");
        nameField.getSelectionModel().selectedIndexProperty().addListener((e) -> {
            validateInput();
        });
        timeBox.getSelectionModel().selectedIndexProperty().addListener((e) -> {
            validateInput();
        });
        coversBox.getSelectionModel().selectedIndexProperty().addListener((e) -> {
            validateInput();
        });

        GridPane grid = new GridPane();
        grid.add(moveName, 1, 1);
        grid.add(nameField, 2, 1);
        grid.add(time, 1, 3);
        grid.add(timeBox, 2, 3);
        grid.add(screen, 1, 4);
        grid.add(coversBox, 2, 4);
        getDialogPane().setContent(grid);

        getDialogPane().lookupButton(buttonTypeOk).setDisable(true);

    }

    private void validateInput() {
        boolean disable = !nameField.getSelectionModel().isEmpty() && !timeBox.getSelectionModel().isEmpty()
                && !coversBox.getSelectionModel().isEmpty();
        getDialogPane().lookupButton(buttonTypeOk).setDisable(!disable);
    }

}
