package com.view;

import javafx.scene.control.Alert;

/**
 * @Author: WangYuyang
 * @Date: 2021/10/4-15:36
 * @Project: comp3013j_assignment
 * @Package: com.view
 * @Description:
 **/
public class Dialog {
    public static void showInfoDialog(String info){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText(info);
        alert.showAndWait();
    }
}
