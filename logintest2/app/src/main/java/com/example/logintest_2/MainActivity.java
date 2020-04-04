package com.example.logintest_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.awt.font.TextAttribute;

public class MainActivity extends AppCompatActivity {

    private TextView tv_id, tv_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_id = findViewById(R.id.tv_id);
        tv_password=findViewById(R.id.tv_password);


        Intent intent = getIntent();
        String userID = intent.getStringExtra("nameID");
        String userPassword = intent.getStringExtra("userPassword");

        tv_password.setText(userPassword);
        tv_id.setText(userID);
    }
}
