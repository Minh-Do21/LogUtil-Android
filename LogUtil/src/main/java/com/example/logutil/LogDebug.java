package com.example.logutil;

import android.util.Log;

public class LogDebug {
    private static final String TAG = "DEMO_MINH_DO";

    public static void d(String message){
        Log.d(TAG, message);
    }
}
