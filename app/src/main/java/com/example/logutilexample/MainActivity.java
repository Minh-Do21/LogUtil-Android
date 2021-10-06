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

        SpaceShareClass spaceShareClass = new SpaceShareClass(new CallBackData() {
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

        //get các dữ nhiệu như yêu cầu của khách hàng
        StringBuilder builder = new StringBuilder();
        builder.append("android : ").append(Build.VERSION.RELEASE);

        Field[] fields = Build.VERSION_CODES.class.getFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            int fieldValue = -1;

            try {
                fieldValue = field.getInt(new Object());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }

            if (fieldValue == Build.VERSION.SDK_INT) {
                builder.append(" : ").append(fieldName).append(" : ");
                builder.append("sdk=").append(fieldValue);
            }
        }
        Log.d("LOG_TAG", "OS: " + builder.toString());

        String deviceOs = Build.VERSION.RELEASE;
        Log.d("LOG_TAG", "OS Version: " + deviceOs);


        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        String ipAddress = Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress());
        Log.d("LOG_TAG", "Địa chỉ IP: " + ipAddress);

        String AndroidID = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);

        Log.d("LOG_TAG", "AndroidID: " + AndroidID);


        LocaleListCompat llc = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
        for (int i=0; i<llc.size(); i++){
            Log.d("LOG_TAG", "Language: " + llc.get(i).getDisplayLanguage());
        }

        FromLogin fromLogin = new FromLogin(this);
    }

}