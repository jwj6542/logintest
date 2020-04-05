package com.example.logintest_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ActivityLogup extends AppCompatActivity {
    private EditText et_id, et_password, et_name, et_age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logup);

        et_id = findViewById(R.id.et_id);
        et_password = findViewById(R.id.et_password);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);

        Button button = findViewById(R.id.btn_log);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = et_id.getText().toString();
                String userPassword = et_password.getText().toString();
                String userName = et_name.getText().toString();
                int userage = Integer.parseInt(et_age.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jasonObject = new JSONObject(response);
                            boolean success = jasonObject.getBoolean("success");
                            if (success) {
                                Toast.makeText(getApplicationContext(), "회원등록에 성공하였습니다", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(ActivityLogup.this, LoginActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "회원등록에 실패하였습니다", Toast.LENGTH_SHORT).show();
                                return;

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(userID,userPassword,userName,userage,responseListener);
                RequestQueue queue = Volley.newRequestQueue(ActivityLogup.this);
                queue.add(registerRequest);
            }
        });
    }
}
