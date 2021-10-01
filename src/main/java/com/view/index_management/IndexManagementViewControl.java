package com.view.index_management;

import com.view.login.LoginView;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: WangYuyang
 * @Date: 2021/10/2-00:22
 * @Project: comp3013j_assignment
 * @Package: com.view.index_management
 * @Description:
 **/
public class IndexManagementViewControl {
    private JFrame window;
    private IndexManagementView indexManagementView;
    private Dimension dimension = new Dimension(1000, 800);

    public IndexManagementViewControl(JFrame window) {
        this.window = window;
        this.window.setSize(dimension);
        this.indexManagementView = new IndexManagementView();
    }

    public void run() {
        window.setContentPane(indexManagementView.getPanel());
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
