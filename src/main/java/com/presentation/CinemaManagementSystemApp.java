package com.presentation;

import cn.hutool.core.io.resource.ResourceUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @Author: WangYuyang
 * @Date: 2021/12/9-13:01
 * @Project: comp3013j_assignment
 * @Package: com.presentation
 * @Description: The entry point of this application.
 **/
public class CinemaManagementSystemApp extends Application {
    private static Stage primaryStage;

    public static void main(String[] args) {
        //Open the application
        launch(args);
    }

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Load XML file for UI
        FXMLLoader fxmlLoader = new FXMLLoader(ResourceUtil.getResource("fx/index-view.fxml"));
        Scene scene = null;
        scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Cinema Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void show() {
        try {
            start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
