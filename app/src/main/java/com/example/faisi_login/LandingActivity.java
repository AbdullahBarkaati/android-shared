package com.example.faisi_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LandingActivity extends AppCompatActivity {

    TextView tv_title;
    ImageView iv_back, iv_notification;
    LinearLayout lin_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        getSupportActionBar().hide();

        tv_title = findViewById(R.id.tv_title);
        iv_back = findViewById(R.id.iv_back);
        iv_notification = findViewById(R.id.iv_notification);
        lin_toolbar = findViewById(R.id.lin_toolbar);


        lin_toolbar.setBackgroundColor(getResources().getColor(R.color.teal_700));
        tv_title.setText("Landing");
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(LandingActivity.this,MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
    }
}