package com.example.faisi_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText et_username,et_email,et_password;
    int value = 0;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_password = findViewById(R.id.et_password);
        et_username = findViewById(R.id.et_username);
        et_email = findViewById(R.id.et_email);
        btn_login = findViewById(R.id.btn_login);

//        et_username.setText(value);
        et_username.setText(String.valueOf(value));
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                value = value + 1;
//                et_username.setText(String.valueOf(value));
                if (validation()){
                    startActivity(new Intent(MainActivity.this,Signup.class));
                    finish();
                }
            }
        });
    }

    public void Go_signup(View view){

        if (validation()){
            startActivity(new Intent(MainActivity.this,Signup.class));
            finish();
        }


    }


    @Override
    protected void onStart() {
        super.onStart();
//        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
        Log.e("Main","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    public boolean validation(){

        if (et_username.getText().toString().equals("")){
            Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show();
            return false;
        }
//        if (!isValidEmail(et_email.getText().toString())){
        if (!isValidEmailnew(et_email.getText().toString())){
            Toast.makeText(this, "Enter valid email", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (et_password.getText().toString().equals("")){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
            return  false;
        }
        return  true;
    }

    public  boolean isValidEmail(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidEmailnew(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}