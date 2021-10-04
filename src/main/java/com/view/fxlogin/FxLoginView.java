package com.view.fxlogin;

import cn.hutool.core.io.resource.ResourceUtil;
import com.util.fxMain;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @Author: WangYuyang
 * @Date: 2021/10/4-15:02
 * @Project: comp3013j_assignment
 * @Package: com.view.fxlogin
 * @Description:
 **/
public class FxLoginView extends Application{
    private Stage primaryStage = fxMain.getPrimaryStage();;


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(ResourceUtil.getResource("fx/login-view.fxml"));
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
}
