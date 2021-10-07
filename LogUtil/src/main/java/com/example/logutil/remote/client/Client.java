package com.example.logutil.remote.client;

import com.example.logutil.remote.api.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    String BASE_URL = "https://develop.api.spaceshare.vn";
    private static Client instance = null;
    private ApiService apiService;

    private  Client(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public static synchronized Client getInstance(){
        if (instance == null){
            instance = new Client();
        }
        return instance;
    }

    public ApiService getApiService(){
        return apiService;
    }
}
