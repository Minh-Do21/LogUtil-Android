package com.example.logutil.remote.client;

import com.example.logutil.remote.api.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    String BASE_URL = "https://develop.api.spaceshare.vn";
    private static RetrofitClient instance = null;
    private Api myApi;

    private  RetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myApi = retrofit.create(Api.class);
    }

    public static synchronized RetrofitClient getInstance(){
        if (instance == null){
            instance = new RetrofitClient();
        }
        return instance;
    }

    public Api getMyApi(){
        return myApi;
    }
}
