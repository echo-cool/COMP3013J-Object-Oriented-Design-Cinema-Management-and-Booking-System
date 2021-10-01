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
import java.util.List;

/**
 * @Author: WangYuyang
 * @Date: 2021/10/1-23:32
 * @Project: comp3013j_assignment
 * @Package: com.view.login
 * @Description:
 **/
public class LoginViewControl {
    private JFrame window;
    private LoginView login_view;
    private IndexManagementViewControl indexManagementViewControl;

    public LoginViewControl(JFrame window) {
        this.window = window;
        this.login_view = new LoginView(this);
    }

    public void run() {
        window.setContentPane(login_view.getPanel());
        window.setVisible(true);
    }

    public void process_login(LoginViewData data) {
        DatabaseUtil.query(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                AdminUserMapper mapper = sqlSession.getMapper(AdminUserMapper.class);
                AdminUserExample example = new AdminUserExample();
                example
                        .createCriteria()
                        .andUsernameEqualTo(data.getUsername());
                List<AdminUser> users = mapper.selectByExample(example);
                for (AdminUser user : users) {
                    if(user.getPassword().equals(data.getPassword())){
                        System.out.println("Password Correct");
                        LoginDialog dialog = new LoginDialog("Login Success !");
                        dialog.pack();
                        dialog.setLocationRelativeTo(null);
                        dialog.setVisible(true);
                        indexManagementViewControl = new IndexManagementViewControl(window);
                        indexManagementViewControl.run();
                        return;
                    }
                }
                LoginDialog dialog = new LoginDialog("Password or Username Error !");
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
                System.out.println("Password Wrong");
                return;
            }
        });
    }
}
