package com.example.logutil;

import android.annotation.SuppressLint;
import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;


import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;

import com.example.logutil.interface_.CallBackData;
import com.example.logutil.model.UserLogin;
import com.example.logutil.model.UserLoginResponse;
import com.example.logutil.remote.client.Client;
import com.example.logutil.remote.pojo.response.BaseResponse;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.WIFI_SERVICE;

public class  SpaceShareClass {

    private final CallBackData callBackData;
    private final Context context;

    String plaFrom, osName, osVersion, timeZone, screenResolution, ipAddress, androidID;
    boolean isSafeMode;
    float xdpi, ydpi;
    List<String> preferredLanguages;

    public SpaceShareClass(Context context, CallBackData callBackData) {
        this.context = context;
        this.callBackData = callBackData;
    }

    public void login(String email, String passWord) {
        //get PlatForm
        plaFrom = getPlatForm();

        //get OSName
        osName = getOSName();

        //get OsVersion
        osVersion = getOSVersion();

        //get TimeZone
        timeZone = getTimeZone();

        //get Screen Resolution
        screenResolution = getScreenResolution();

        //get IP Address
        ipAddress = getIPAddress();

        //get android id
        androidID = getAndroidID();

        //get Safe Mode
        isSafeMode = getSafeMode();

        //get xdpi
        xdpi = getXdpi();

        //get ydpi
        ydpi = getYdpi();

        //get preferred Languages
        preferredLanguages = getPreferredLanguages();

        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(passWord)) {
            UserLogin userLogin = new UserLogin(email, passWord);
            //call api get list office
            postLogin(userLogin);
        }else {
            callBackData.callBackData(null);
        }

    }

    private List<String> getPreferredLanguages() {
        List<String> preferredLanguages = new ArrayList<>();
        LocaleListCompat localeListCompat = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
        for (int i=0; i < localeListCompat.size(); i++){
            preferredLanguages.add(localeListCompat.get(i).getDisplayLanguage());
        }
        return preferredLanguages;
    }

    private float getYdpi() {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.heightPixels / metrics.ydpi;
    }

    private float getXdpi() {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.widthPixels / metrics.xdpi;
    }

    private boolean getSafeMode() {
        return context.getPackageManager().isSafeMode();
    }

    @SuppressLint("HardwareIds")
    private String getAndroidID() {
       return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);

    }

    private String getIPAddress() {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(WIFI_SERVICE);
        return Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress());
    }

    private String getScreenResolution() {
        int widthPixels = Resources.getSystem().getDisplayMetrics().widthPixels;
        int heightPixels = Resources.getSystem().getDisplayMetrics().heightPixels;
        return widthPixels+"x"+heightPixels;
    }

    private String getTimeZone() {
        TimeZone timeZone = TimeZone.getDefault();
        return timeZone.toString();
    }

    private String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    private String getOSName() {

        String osName = null;

        Field[] fields = Build.VERSION_CODES.class.getFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            int fieldValue = -1;

            try {
                fieldValue = field.getInt(new Object());
            } catch (IllegalArgumentException | IllegalAccessException | NullPointerException e) {
                e.printStackTrace();
            }

            if (fieldValue == Build.VERSION.SDK_INT) {
                osName = fieldName;
            }

        }
        return osName;
    }

    private String getPlatForm() {
        String platForm =  null;
        try {
            Class.forName("android.app.Activity");
            platForm = "Android";
        } catch (ClassNotFoundException ignored) {
        }
        return platForm;
    }


    private void postLogin(UserLogin userLogin) {
        Client client = Client.getInstance();
        Call<BaseResponse<UserLoginResponse>> call = client.getApiService().postLogin(userLogin);

        call.enqueue(new Callback<BaseResponse<UserLoginResponse>>() {
            @Override
            public void onResponse(Call<BaseResponse<UserLoginResponse>> call, Response<BaseResponse<UserLoginResponse>> response) {
                if (response.body() != null){
                    System.out.println("DATA POST "+"plaFrom: "+plaFrom+", osName: "+osName+", osVersion: "+osVersion+", timeZone: "+timeZone
                            +", screenResolution: "+screenResolution+", ipAddress: "+ipAddress+", androidID: "+androidID+", isSafeMode: "+isSafeMode
                            +", xdpi: "+xdpi+", ydpi: "+ydpi+", preferredLanguages: "+preferredLanguages);

                    callBackData.callBackData(response.body().data.token);
                }else {
                    callBackData.callBackData(null);
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<UserLoginResponse>> call, Throwable t) {
                System.out.println("DATAA lỗi: "+t.toString());
               callBackData.callBackData(null);
            }
        });
    }

}