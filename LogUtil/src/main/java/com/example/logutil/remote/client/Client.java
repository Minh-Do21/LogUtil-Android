package com.example.logutil.remote.client;

import androidx.annotation.NonNull;

import com.example.logutil.model.Office;
import com.example.logutil.model.UserLogin;
import com.example.logutil.model.UserLoginResponse;
import com.example.logutil.remote.api.ApiService;
import com.example.logutil.remote.pojo.response.BaseListResponse;
import com.example.logutil.remote.pojo.response.BaseResponse;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    private static final String BASE_URL = "https://develop.api.spaceshare.vn";
    private static Client instance;
    private ApiService apiService;

    private Client(){
        final Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public static Client getInstance(){
        if (instance == null){
            instance = new Client();
        }
        return instance;
    }

    public Observable<BaseResponse<UserLoginResponse>> postLogin(@NonNull UserLogin userLogin){
        return apiService.postLogin(userLogin);
    }


}
