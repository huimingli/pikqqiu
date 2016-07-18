package com.celt.estation.template.bean;

import com.celt.estation.template.base.BaseModel;

/**
 * Created by 00013811 on 2016/7/13.
 */
public class User extends BaseModel {
    private static User user;
    private boolean isLogin;
    private int id;
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    private User(){
        user = new User();
    }
    public static User getInstance(){
        if (user == null)          //1
            user = new User();  //2
        return user;
    }
}
