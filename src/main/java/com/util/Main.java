package com.util;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.github.weisj.darklaf.LafManager;
import com.view.login.LoginViewControl;

import javax.swing.*;

/**
 * @author WangYuyang
 * @version 1.0
 * @date 2021/9/8 16:31
 */

public class Main {
    public static final boolean DEBUG = true;
    private static final int SCREEN_HEIGHT = 300;
    private static final int SCREEN_WIDTH = 300;
    private static final String ProjectName = "Cinema Management System";
    private static JFrame window;
    private static Log log;

    public static void main(String[] args) {
        window = new JFrame();
        log = LogFactory.get();
        LafManager.install();
        window.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle(ProjectName);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.requestFocusInWindow();
        LoginViewControl viewControl = new LoginViewControl(window);
        viewControl.run();
//        contentMain_view = new Login_View();
//        window.setContentPane(contentMain_view.getPanel());
//        if(!DEBUG) {
//            LafManager.install();
//            for (int i = 0; i < SCREEN_HEIGHT; i += 20) {
//                window.setSize(SCREEN_WIDTH, i);
//                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                window.setTitle(ProjectName);
//                window.setLocationRelativeTo(null);
//                window.setVisible(true);
//                window.requestFocusInWindow();
//            }
//        } else{
//            window.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
//            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            window.setTitle(ProjectName);
//            window.setLocationRelativeTo(null);
//            window.setVisible(true);
//            window.requestFocusInWindow();
//        }

    }
}
