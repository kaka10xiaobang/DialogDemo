package com.kaka.dialogdemo;

/**
 * Created by kaka on 2018/3/27.
 * email:375120706@qq.com
 */

public class DialogEvent  {
    private String userName;
    private String pwd;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public DialogEvent(String userName, String pwd) {
        this.userName = userName;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "DialogEvent{" +
                "userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
