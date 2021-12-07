package com.presentation;


import cn.hutool.core.io.resource.ResourceUtil;
import com.application.domain.ManagementSystem;
import com.application.domain.ScreeningObserver;
import com.application.models.Screening;
import com.view.fxaddarrangement.AddArrangementView;
import com.view.fxaddmovie.AddMovieView;
import com.view.fxneworder.NewOrderView;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;


public class StaffUI extends Application implements ScreeningObserver {
    ManagementSystem managementSystem;
    private static Stage primaryStage;

    public StaffUI(){
        managementSystem=new ManagementSystem();
        managementSystem.addObserver(this);


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
        currentScreenings=managementSystem.getScreenings();

        draw();
    }

    @Override
    public boolean message(String message, boolean isConfirmation) {
        if(isConfirmation) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(message);
//        alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                update();
                return true;
            } else {
                update();
                return false;
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(message);
//            alert.setContentText("I have a great message for you!");

            alert.showAndWait();
            update();
            return true;
        }

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

    public void showScheduleScreeningDialog(){

    }

    public void showAlert(String message, Alert.AlertType warning){}

    public void showMessage(String message){}

    public void showAddMovieDialog(){
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
        managementSystem.setDate(LocalDate.now());
        datePicker.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {
                managementSystem.setDate(newValue);
            }
        });
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
        gc.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
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
            gc.fillRect(
                    timeToX(LocalTime.parse(screening.getStartTime())),
                    screenToY(screening.getScreen().getId()),
                    COL_WIDTH*SLOTS*((screening.getMovie().getDuration())/(3600f*24f)),
                    ROW_HEIGHT);
            gc.setFill(Color.BLACK);
            gc.fillText(screening.getMovie().getName(),timeToX(LocalTime.parse(screening.getStartTime()))+5,
                    screenToY(screening.getScreen().getId())+ROW_HEIGHT*0.7);
            gc.strokeRect(timeToX(LocalTime.parse(screening.getStartTime())),
                    screenToY(screening.getScreen().getId()),
                    COL_WIDTH*SLOTS*((screening.getMovie().getDuration())/(3600f*24f)),
                    ROW_HEIGHT);
            if(screening==managementSystem.getSelectedScreening()){
                gc.strokeRect(timeToX(LocalTime.parse(screening.getStartTime()))+2,
                        screenToY(screening.getScreen().getId())+2,
                        COL_WIDTH*SLOTS*((screening.getMovie().getDuration())/(3600f*24f))-4,
                        ROW_HEIGHT-4);
            }
        }

        if(managementSystem.getSelectedScreening()!=null&&is_dragging){
            gc.setFill(Color.rgb(255,0,0,0.5));
//            gc.fillRect(
//                    timeToX(LocalTime.parse(managementSystem.getSelectedScreening().getStartTime()))-start_x+dragged_x,
//                    screenToY(managementSystem.getSelectedScreening().getScreen().getId())-start_y+dragged_y,
//                    COL_WIDTH*SLOTS*((managementSystem.getSelectedScreening().getMovie().getDuration())/(3600f*24f)),
//                    ROW_HEIGHT);
            gc.fillRect(
                    timeToX(LocalTime.parse(managementSystem.getSelectedScreening().getStartTime()))-start_x+dragged_x,
                    screenToY(yToScreen((int) dragged_y)),
                    COL_WIDTH*SLOTS*((managementSystem.getSelectedScreening().getMovie().getDuration())/(3600f*24f)),
                    ROW_HEIGHT);
        }



    }


    public void showDate(ActionEvent actionEvent) {

    }

    public void nextDay() {
        currentDate = datePicker.getValue();
        currentDate = currentDate.plusDays(1);
        datePicker.setValue(currentDate);
        managementSystem.setDate(currentDate);
    }

    public void prevDay() {
        currentDate = datePicker.getValue();
        currentDate = currentDate.minusDays(1);
        datePicker.setValue(currentDate);
        managementSystem.setDate(currentDate);
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

    public void test(ActionEvent actionEvent){
        managementSystem.setDate(currentDate);
    }

    public void onMouseClicked(MouseEvent mouseEvent){

    }

    public void onMouseDragEntered(MouseEvent mouseEvent){

    }

    public void onMouseDragExited(MouseEvent mouseEvent){

    }

    private double start_x=0;
    private double start_y=0;
    private boolean is_dragging=false;
    private double dragged_x=0;
    private double dragged_y=0;
    public void onMouseDragged(MouseEvent mouseEvent){
        is_dragging=true;
        dragged_x=mouseEvent.getX();
        dragged_y=mouseEvent.getY();
        update();
    }

    public void onMouseReleased(MouseEvent mouseEvent){
        is_dragging=false;
        if(managementSystem.getSelectedScreening()!=null){
            System.out.println(managementSystem.updateSelected(xToTime((int) (timeToX(LocalTime.parse(managementSystem.getSelectedScreening().getStartTime()))-start_x+dragged_x)),yToScreen((int) dragged_y)));
        }
    }

    public void onMousePressed(MouseEvent mouseEvent){
        System.out.printf("%s,%s\n",mouseEvent.getX(),mouseEvent.getY());
        start_x=mouseEvent.getX();
        start_y=mouseEvent.getY();
        LocalTime time=xToTime((int) mouseEvent.getX());
        int screen=yToScreen((int) mouseEvent.getY());
        managementSystem.changeSelected(time,screen);
    }




}
