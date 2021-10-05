package com.view.fxindex;

import com.view.fxaddarrangement.AddArrangementView;
import com.view.fxaddmovie.AddMovieView;
import com.view.fxneworder.NewOrderView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.DatePicker;
import javafx.scene.paint.Color;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @Author: WangYuyang
 * @Date: 2021/10/4-15:41
 * @Project: comp3013j_assignment
 * @Package: com.view.fxindex
 * @Description:
 **/
public class IndexController {
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
