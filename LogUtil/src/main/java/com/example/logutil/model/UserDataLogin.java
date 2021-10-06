package com.example.logutil.model;

import com.google.gson.annotations.SerializedName;

public class UserDataLogin {
    @SerializedName("status")
    final boolean status;

    @SerializedName("message_code")
    final String messageCode;

    @SerializedName("message")
    final String message;

    @SerializedName("data")
    final Data data;

    public UserDataLogin(boolean status, String messageCode, String message, Data data) {
        this.status = status;
        this.messageCode = messageCode;
        this.message = message;
        this.data = data;
    }
}

class Data{
    @SerializedName("token")
    final String token;

    public Data(String token) {
        this.token = token;
    }
}
