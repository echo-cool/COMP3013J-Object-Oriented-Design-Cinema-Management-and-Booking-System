package com.view.fxlogin;

import com.mapper.AdminUserMapper;
import com.model.AdminUser;
import com.model.AdminUserExample;
import com.util.DatabaseUtil;
import com.util.QueryStatement;
import com.view.Dialog;
import com.view.fxindex.IndexView;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author: WangYuyang
 * @Date: 2021/10/4-14:41
 * @Project: comp3013j_assignment
 * @Package: com.view.fxlogin
 * @Description:
 **/
public class FxLoginController {
    @FXML private TextField username;
    @FXML private TextField password;


    @FXML
    protected void onLoginButtonClicked(){
        System.out.println("Login");
        String username = this.username.getText();
        String password = this.password.getText();
        DatabaseUtil.query(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                AdminUserMapper mapper = sqlSession.getMapper(AdminUserMapper.class);
                AdminUserExample example = new AdminUserExample();
                example
                        .createCriteria()
                        .andUsernameEqualTo(username);
                List<AdminUser> users = mapper.selectByExample(example);
                for (AdminUser user : users) {
                    if(user.getPassword().equals(password)){
                        System.out.println("Password Correct");
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                Dialog.showInfoDialog("Password Correct");
                                IndexView indexView = new IndexView();
                                indexView.show();
                            }
                        });

                        return;
                    }
                }
                System.out.println("Password Wrong");
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Dialog.showInfoDialog("Password Wrong");
                    }
                });
                return;
            }
        });
    }

    @FXML
    protected void onClearButtonClicked(){
        username.setText("");
        password.setText("");

    }




}
