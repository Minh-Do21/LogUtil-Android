package com.example.logutil.model;

import com.google.gson.annotations.SerializedName;

public class UserLoginResponse {
    @SerializedName("token")
    public final String token;

    public UserLoginResponse(String token) {
        this.token = token;
    }
}
