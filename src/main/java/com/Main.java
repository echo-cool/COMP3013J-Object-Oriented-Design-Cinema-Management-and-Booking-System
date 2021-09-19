package com;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.github.weisj.darklaf.LafManager;
import com.github.weisj.darklaf.theme.IntelliJTheme;
import mdlaf.MaterialLookAndFeel;

import javax.swing.*;

/**
 * @author WangYuyang
 * @version 1.0
 * @date 2021/9/8 16:31
 */

public class Main {
    private static JFrame window;
    private static ContentMain_View contentMain_view;
    private static Log log;
    private static final int SCREEN_HEIGHT = 600;
    private static final int SCREEN_WIDTH = 800;
    private static final String ProjectName = "haha";
    public static final boolean DEBUG = true;

    public static void main(String[] args) {
        window = new JFrame();
        log = LogFactory.get();
        contentMain_view = new ContentMain_View();
        window.setContentPane(contentMain_view.getPanel());
        if(!DEBUG) {
            LafManager.install();
            for (int i = 0; i < SCREEN_HEIGHT; i += 20) {
                window.setSize(SCREEN_WIDTH, i);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setTitle(ProjectName);
                window.setLocationRelativeTo(null);
                window.setVisible(true);
                window.requestFocusInWindow();
            }
        } else{
            window.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setTitle(ProjectName);
            window.setLocationRelativeTo(null);
            window.setVisible(true);
            window.requestFocusInWindow();
        }

    }
}
