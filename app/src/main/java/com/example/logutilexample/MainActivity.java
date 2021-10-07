package com.example.logutilexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;

import android.content.res.Resources;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.format.Formatter;
import android.util.Log;
import android.widget.Toast;

import com.example.logutil.FromLogin;
import com.example.logutil.interface_.CallBackData;
import com.example.logutil.SpaceShareClass;
import com.example.logutil.interface_.CallBackValidationFrom;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpaceShareClass spaceShareClass = new SpaceShareClass(this, new CallBackData() {
            @Override
            public void callBackData(String data) {
                if (data != null){
                    Toast.makeText(MainActivity.this, "Đang nhập thành công !"+data, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Đang nhập thất bại !", Toast.LENGTH_SHORT).show();
                }
            }
        });
        spaceShareClass.login("minhdo170920@gmail.com", "Minhdo123");
    }

}