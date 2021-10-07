package com.example.logutil.remote.api;

import com.example.logutil.model.UserLogin;
import com.example.logutil.model.UserLoginResponse;
import com.example.logutil.remote.pojo.response.BaseResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    //api login
    @POST("/authentication/v1/login/")
    Call<BaseResponse<UserLoginResponse>> postLogin(@Body UserLogin userLogin);
}
