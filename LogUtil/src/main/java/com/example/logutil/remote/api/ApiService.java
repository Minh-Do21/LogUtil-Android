package com.example.logutil.remote.api;


import com.example.logutil.model.Office;
import com.example.logutil.model.UserLogin;
import com.example.logutil.model.UserLoginResponse;
import com.example.logutil.remote.pojo.response.BaseListResponse;
import com.example.logutil.remote.pojo.response.BaseResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    //api login
    @POST("/authentication/v1/login/")
    Observable<BaseResponse<UserLoginResponse>> postLogin(@Body UserLogin userLogin);

    //api get office home
    @GET("/office-space-service/v3/")
    Observable<BaseResponse<BaseListResponse<Office>>> getOfficeHome(@Query("limit") int limit,
                                                                     @Query("offset") int offset);
}
