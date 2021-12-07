package com.presentation;

import javafx.collections.FXCollections;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.time.LocalTime;

@SuppressWarnings("restriction")
public class ReservationDialog extends Dialog<CusInfo> {

  private TextField          nameField    = new TextField();
  private String[]           times        = { "00:00","01:00","02:00","03:00","04:00","05:00","06:00","07:00","08:00","09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00"};
  private ChoiceBox<String>  timeBox      = new ChoiceBox<String>(FXCollections.observableArrayList(times));
  private Integer[]          st           = { 0,1,2,3,4,5 };
  private ChoiceBox<Integer> coversBox    = new ChoiceBox<Integer>(FXCollections.observableArrayList(st));
  private ButtonType         buttonTypeOk = new ButtonType("Ok", ButtonData.OK_DONE);

  public ReservationDialog(CusInfo c) {
    this();
    nameField.setText(c.name);
    timeBox.getSelectionModel().select(c.time.toString());
    coversBox.getSelectionModel().select(Integer.valueOf(c.screen));
  }

  public ReservationDialog() {
    super();
    Label label1 = new Label("Movie name: ");
    Label label3 = new Label("Time: ");
    Label label4 = new Label("Screen: ");
    getDialogPane().getButtonTypes().add(buttonTypeOk);

    setResultConverter(new Callback<ButtonType, CusInfo>() {
      @Override public CusInfo call(ButtonType b) {

        if (b == buttonTypeOk) {
          return new CusInfo(nameField.getText(), LocalTime.parse(timeBox.getValue()), coversBox.getValue());
        }

        return null;
      }
    });
    setTitle("New Reservation");
    setHeaderText("Please enter the details for the new Reservation");
    nameField.textProperty().addListener((observable, oldValue, newValue) -> {
      validateInput();
    });
    timeBox.getSelectionModel().selectedIndexProperty().addListener((e) -> {
      validateInput();
    });
    coversBox.getSelectionModel().selectedIndexProperty().addListener((e) -> {
      validateInput();
    });

    GridPane grid = new GridPane();
    grid.add(label1, 1, 1);
    grid.add(nameField, 2, 1);
    grid.add(label3, 1, 3);
    grid.add(timeBox, 2, 3);
    grid.add(label4, 1, 4);
    grid.add(coversBox, 2, 4);
    getDialogPane().setContent(grid);

    getDialogPane().lookupButton(buttonTypeOk).setDisable(true);

  }

  private void validateInput() {
    boolean disable = nameField.getText().length() > 0 && !timeBox.getSelectionModel().isEmpty()
        && !coversBox.getSelectionModel().isEmpty() ;
    getDialogPane().lookupButton(buttonTypeOk).setDisable(!disable);
  }

}
