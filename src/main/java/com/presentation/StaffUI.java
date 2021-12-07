package com.presentation;


import cn.hutool.core.io.resource.ResourceUtil;
import com.application.domain.ManagementSystem;
import com.application.domain.ScreeningObserver;
import com.application.models.Screen;
import com.application.models.Screening;
import com.view.fxaddarrangement.AddArrangementView;
import com.view.fxaddmovie.AddMovieView;
import com.view.fxneworder.NewOrderView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class StaffUI extends Application implements ScreeningObserver {
    ManagementSystem managementSystem;
    private static Stage primaryStage;

    public StaffUI(){
        managementSystem=new ManagementSystem();
        managementSystem.setDate(currentDate);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(ResourceUtil.getResource("fx/index-view.fxml"));
        Scene scene = null;
        scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Cinema Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void show(){
        try {
            start(primaryStage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        managementSystem.getCurrentDate();
        currentScreenings=managementSystem.getScreenings();
        draw();
    }

    @Override
    public boolean message(String message, boolean isConfirmation) {
        return false;
    }


    private int timeToX(LocalTime time){
        return (int) ((time.getHour()*60+time.getMinute())/(60*24f)*(SLOTS * COL_WIDTH)+LEFT_MARGIN);
    }

    private LocalTime xToTime(int x){
        return LocalTime.ofSecondOfDay((long) (60*((24*60f*(x-LEFT_MARGIN)/(SLOTS * COL_WIDTH)))));
    }

    private int screenToY(int screen){
        return TOP_MARGIN+screen*ROW_HEIGHT;
    }

    private int yToScreen(int y){
        return (y-TOP_MARGIN)/ROW_HEIGHT;
    }

    public void mousePressed(int x,int y){}

    public void mouseMoved(int x,int y){}

    public void mouseReleased(int x,int y){}

    public void submit(LocalDate date){
        managementSystem.setDate(date);
    }

    public void sellTicket(){}

    public void showSellTicketDialog(){}

    public void cancelScreening(){}

    public void showScheduleScreeningDialog(){}

    public void showAlert(String message, Alert.AlertType warning){}

    public void showMessage(String message){}

    public void showAddMovieDialog(){
    }

    public void showDate(){

    }


    public LocalDate currentDate=LocalDate.now();
    public Screening[] currentScreenings=new Screening[0];


    final static int         LEFT_MARGIN   = 60;
    final static int         TOP_MARGIN    = 50;
    final static int         BOTTOM_MARGIN = 50;
    final static int         ROW_HEIGHT    = 30;
    final static int         COL_WIDTH     = 60;
    final static int         SLOTS         = 12;                    // Number of booking slots shown

    @FXML
    private DatePicker datePicker;
    @FXML
    private Canvas canvas;

    public void initialize() {
        datePicker.setValue(LocalDate.now());
        this.draw();
    }

    public void draw(){
        ArrayList<String> data = new ArrayList();
        data.add("Screen 1");
        data.add("Screen 2");
        data.add("Screen 3");
        data.add("Screen 4");
        data.add("Screen 5");
        data.add("Screen 6");
        data.add("Screen 7");
        GraphicsContext gc = canvas.getGraphicsContext2D();
        canvas.setHeight(TOP_MARGIN + data.size() * ROW_HEIGHT);
        canvas.setWidth(LEFT_MARGIN + (SLOTS * COL_WIDTH));
//        gc.setFill(Color.WHITE);
//        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setLineWidth(2.0);
        gc.setFill(Color.BLACK);
        //
        // // Draw screen outlines
        //
        gc.strokeLine(LEFT_MARGIN, 0, LEFT_MARGIN, canvas.getHeight());
        gc.strokeLine(0, TOP_MARGIN, canvas.getWidth(), TOP_MARGIN);
        //
        for (int i = 0; i < data.size(); i++) {
            int y = TOP_MARGIN + (i + 1) * ROW_HEIGHT;
            gc.fillText(data.get(i), 0, y - ROW_HEIGHT / 3);
            gc.strokeLine(LEFT_MARGIN, y, canvas.getWidth(), y);
        }


        for(Screening screening:currentScreenings){
            gc.setFill(Color.RED);
            gc.fillRect(timeToX(LocalTime.parse(screening.getStartTime())),screenToY(screening.getScreen().getId()),COL_WIDTH*SLOTS*((screening.getMovie().getDuration())/3600f*24f),ROW_HEIGHT);
        }



    }

    public void prevDay(ActionEvent actionEvent) {

    }

    public void showDate(ActionEvent actionEvent) {

    }

    public void nextDay(ActionEvent actionEvent) {

    }

    public void showNewOrderView(ActionEvent actionEvent) {
        NewOrderView orderView = new NewOrderView();
        orderView.show();
    }

    public void showAddMovieView(ActionEvent actionEvent) {
        AddMovieView movieView = new AddMovieView();
        movieView.show();
    }

    public void showAddArraignmentView(ActionEvent actionEvent) {
        AddArrangementView addArrangementView = new AddArrangementView();
        addArrangementView.show();
    }

    public void CancelOrder(ActionEvent actionEvent) {

    }


}
