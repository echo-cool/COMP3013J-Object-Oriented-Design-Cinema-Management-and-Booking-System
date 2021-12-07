package com.util;

import cn.hutool.core.io.resource.ResourceUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * @Author: WangYuyang
 * @Date: 2021/10/4-14:40
 * @Project: comp3013j_assignment
 * @Package: com.util
 * @Description:
 **/
public class fxMain extends Application{
    private static Stage primaryStage;
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(ResourceUtil.getResource("fx/blank-view.fxml"));
        Scene scene = null;
        scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Cinema Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
//
//        FxLoginView view = new FxLoginView();
//        view.show();

    }

    public static Stage getPrimaryStage()





























































































































































































































































































































    {
        return primaryStage;
    }
}
