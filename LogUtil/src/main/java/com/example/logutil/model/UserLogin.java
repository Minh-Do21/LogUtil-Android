package com.example.logutil.model;

import android.text.TextUtils;
import android.util.Patterns;

import com.google.gson.annotations.SerializedName;

public class UserLogin {
    @SerializedName("username")
    public final String userName;

    @SerializedName("password")
    public final String passWord;

    public UserLogin(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public boolean validationUserName(){
//        boolean isValidation = true;
        if (TextUtils.isEmpty(userName)){
            return false;
        }

        if (Patterns.EMAIL_ADDRESS.matcher(userName).matches()){
            return true;
        }

        if (android.util.Patterns.PHONE.matcher(userName).matches() && (userName.length() >8 && userName.length() <12)){
            return true;
        }

        return false;
    }

    public boolean validationPassWord(){
        return !TextUtils.isEmpty(passWord) && passWord.length() > 5;
    }
}
