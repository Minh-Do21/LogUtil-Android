package com.example.logutil;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;


import com.example.logutil.interface_.CallBackData;
import com.example.logutil.model.UserLogin;
import com.example.logutil.model.UserLoginResponse;
import com.example.logutil.remote.api.ApiService;
import com.example.logutil.remote.client.Client;
import com.example.logutil.remote.pojo.response.BaseResponse;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.observers.BlockingBaseObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class  SpaceShareClass {

    private final CallBackData callBackData;

    public SpaceShareClass(CallBackData callBackData) {
        this.callBackData = callBackData;
    }


    public synchronized void login(String email, String passWord) {
        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(passWord)) {

            UserLogin userLogin = new UserLogin(email, passWord);
            //call api get list office
            Client.getInstance()
                    .postLogin(userLogin)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(postUserLogin());

        }

    }

    private Observer<BaseResponse<UserLoginResponse>> postUserLogin() {
       return new BlockingBaseObserver<BaseResponse<UserLoginResponse>>() {
           @Override
           public void onNext(@NonNull BaseResponse<UserLoginResponse> userLoginResponseBaseResponse) {
               System.out.println("DATAA: "+userLoginResponseBaseResponse.data.token);
               callBackData.callBackData(userLoginResponseBaseResponse.data.token);
           }

           @Override
           public void onError(@NonNull Throwable e) {
               System.out.println("DATAA lỗi: "+e.toString());
               callBackData.callBackData(null);
           }
       };
    }

//    private synchronized String postLogin(UserLogin userLogin) {
//
//        Call<BaseResponse<UserLoginResponse>> call = ApiService.apiService.postLogin(userLogin);
//
//        call.enqueue(new Callback<BaseResponse<UserLoginResponse>>() {
//            @Override
//            public void onResponse(Call<BaseResponse<UserLoginResponse>> call, Response<BaseResponse<UserLoginResponse>> response) {
////                System.out.println("DATAA sssss: "+response.body().data.token);
//                token = response.body().data.token;
//                callBackData.callBackData(token);
//            }
//
//            @Override
//            public void onFailure(Call<BaseResponse<UserLoginResponse>> call, Throwable t) {
////                System.out.println("DATAA lôix: "+token);
//                token = "";
//            }
//        });
//
//
//        return token;
//    }

}