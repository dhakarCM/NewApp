package com.phppoets.newapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.phppoets.newapp.R;

public class RegisterActivity extends AppCompatActivity {

    Button btnRegister;
    TextView login;
    String name,mobile,password,username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        login= (TextView) findViewById(R.id.txtLogin);
        btnRegister= (Button) findViewById(R.id.btnRegister);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
