package com.view.login;

import com.mapper.AdminUserMapper;
import com.model.AdminUser;
import com.model.AdminUserExample;
import com.util.DatabaseUtil;
import com.util.QueryStatement;
import com.view.compoments.LoginDialog;
import com.view.index_management.IndexManagementViewControl;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LoginView {
    private JPanel panel;
    private JButton LoginButton;
    private JButton ClearButton;
    private JTextField Username_Text;
    private JTextField Password_Text;
    private LoginViewControl loginViewControl;

    public LoginView(LoginViewControl loginViewControl) {

        LoginButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginViewData data = new LoginViewData();
                getData(data);
                loginViewControl.process_login(data);



            }
        });
        ClearButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginViewData data = new LoginViewData();
                data.setUsername("");
                data.setPassword("");
                setData(data);
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setData(LoginViewData data) {
        Password_Text.setText(data.getPassword());
        Username_Text.setText(data.getUsername());
    }

    public void getData(LoginViewData data) {
        data.setPassword(Password_Text.getText());
        data.setUsername(Username_Text.getText());
    }

    public boolean isModified(LoginViewData data) {
        if (Password_Text.getText() != null ? !Password_Text.getText().equals(data.getPassword()) : data.getPassword() != null)
            return true;
        if (Username_Text.getText() != null ? !Username_Text.getText().equals(data.getUsername()) : data.getUsername() != null)
            return true;
        return false;
    }
}
