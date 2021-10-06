package com.example.logutil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.logutil.interface_.CallBackData;
import com.example.logutil.interface_.CallBackValidationFrom;
import com.example.logutil.model.UserLogin;

public class FromLogin extends LinearLayout{

    private EditText edtEmail, edtPassword;
    private Button btnClearTextEmail, btnClearTextPassword, btnLogin;
    private TextView tvValidationEmail, tvValidationPassWord;


    public FromLogin(Context context) {
        this(context, null);
    }
    public FromLogin(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.Options, 0, 0);

        String titleText = a.getString(R.styleable.Options_titleText);
        @SuppressLint("ResourceAsColor")
        int valueColor = a.getColor(R.styleable.Options_valueColor, android.R.color.black);
        a.recycle();

        // more stuff
        //set LineLayout properties
        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.form_login, this, true);

        mappingView();
        initOnClick();
        changeEditText();
    }

    private void changeEditText() {
        edtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                UserLogin userLogin = new UserLogin(charSequence.toString(), "");
                if (!userLogin.validationUserName()){
                    showMessageValidationUserName("Tài khoản không chính xác !", View.VISIBLE);
                }else {
                    showMessageValidationUserName(null, View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                UserLogin userLogin = new UserLogin("", charSequence.toString());
                if (!userLogin.validationPassWord()){
                    showMessageValidationPassword("Mật khẩu không chính xác !", View.VISIBLE);
                }else {
                    showMessageValidationPassword(null, View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    private void initOnClick() {
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                submitLogin();
            }
        });

        btnClearTextEmail.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                edtEmail.setText("");
            }
        });

        btnClearTextPassword.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                edtPassword.setText("");
            }
        });
    }

    private boolean submitLogin() {
        String userName = edtEmail.getText().toString().trim();
        String passWord = edtPassword.getText().toString().trim();

        UserLogin userLogin = new UserLogin(userName, passWord);

        boolean isValidation = true;

        if (!userLogin.validationUserName()){
            isValidation = false;
            showMessageValidationUserName("Tài khoản không chính xác !", View.VISIBLE);
        }

        if (!userLogin.validationPassWord()){
            isValidation = false;
            showMessageValidationPassword("Mật khẩu không chính xác !", View.VISIBLE);
        }

        System.out.println("Validation Login: "+ isValidation );
        return isValidation;
    }

    private void mappingView() {
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnClearTextEmail = findViewById(R.id.btnClearTextEmail);
        btnClearTextPassword = findViewById(R.id.btnClearTextPassword);
        tvValidationEmail = findViewById(R.id.tvValidationEmail);
        tvValidationPassWord = findViewById(R.id.tvValidationPassWord);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private void showMessageValidationUserName(String message, int view){
        tvValidationEmail.setVisibility(view);
        tvValidationEmail.setText(message);
    }

    private void showMessageValidationPassword(String message, int view){
        tvValidationPassWord.setVisibility(view);
        tvValidationPassWord.setText(message);
    }
}
