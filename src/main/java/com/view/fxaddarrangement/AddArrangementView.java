package com.view.fxaddarrangement;

import cn.hutool.core.io.resource.ResourceUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @Author: WangYuyang
 * @Date: 2021/10/5-14:51
 * @Project: comp3013j_assignment
 * @Package: com.view.fxaddarrangement
 * @Description:
 **/
public class AddArrangementView extends Application {
    private final Stage primaryStage = new Stage();


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(ResourceUtil.getResource("fx/add-arrangement-view.fxml"));
        Scene scene = null;
        scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Add Arrangement");
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
}
