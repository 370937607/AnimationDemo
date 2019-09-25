package com.example.traing.bean;

import android.widget.EditText;

import cn.bmob.v3.BmobObject;

public class BmobUser extends BmobObject {

    private String username;
    private String password;
    private String email;
    private String emailVerified;
    private int mobilePhoneNumber;
    private Boolean mobilePhoneNumberVerified;

    @Override
    public String toString() {
        return "BmobUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", emailVerified='" + emailVerified + '\'' +
                ", mobilePhoneNumber=" + mobilePhoneNumber +
                ", mobilePhoneNumberVerified=" + mobilePhoneNumberVerified +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(String emailVerified) {
        this.emailVerified = emailVerified;
    }

    public int getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(int mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public Boolean getMobilePhoneNumberVerified() {
        return mobilePhoneNumberVerified;
    }

    public void setMobilePhoneNumberVerified(Boolean mobilePhoneNumberVerified) {
        this.mobilePhoneNumberVerified = mobilePhoneNumberVerified;
    }



}