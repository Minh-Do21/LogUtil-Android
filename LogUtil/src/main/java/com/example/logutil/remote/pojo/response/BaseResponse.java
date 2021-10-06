package com.example.logutil.remote.pojo.response;

import com.google.gson.annotations.SerializedName;

public class BaseResponse<T> {
    @SerializedName("status")
    public final boolean status;

    @SerializedName("message_code")
    public final String messageCode;

    @SerializedName("message")
    public final String message;

    @SerializedName("data")
    public final T data;

    public BaseResponse(boolean status, String messageCode, String message, T data) {
        this.status = status;
        this.messageCode = messageCode;
        this.message = message;
        this.data = data;
    }
}
