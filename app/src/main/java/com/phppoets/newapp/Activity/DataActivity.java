package com.phppoets.newapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.phppoets.newapp.R;

public class DataActivity extends AppCompatActivity {
    String name,mobile,email,password,sex,age,agree,date,time;
    Bundle bundle;
    TextView txtName, txtMobile, txtEmail, txtPass, txtAge, txtSex, txtAgree, txtDate, txtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        bundle = getIntent().getExtras();
        if (bundle == null) {
            System.out.println("No Data To show");
        } else {
             name = bundle.getString("name");
             mobile = bundle.getString("mobile");
             email = bundle.getString("email");
             password = bundle.getString("pass");
             sex = bundle.getString("sex");
             age = bundle.getString("age");
             agree = bundle.getString("agree");
             date = bundle.getString("date");
             time = bundle.getString("time");
        }


        txtName = (TextView) findViewById(R.id.txtName);
        txtMobile = (TextView) findViewById(R.id.txtMobile);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtPass = (TextView) findViewById(R.id.txtPass);
        txtSex = (TextView) findViewById(R.id.txtSex);
        txtAge = (TextView) findViewById(R.id.txtAge);
        txtAgree = (TextView) findViewById(R.id.txtAgree);
        txtDate = (TextView) findViewById(R.id.txtDate);
        txtTime = (TextView) findViewById(R.id.txtTime);


        txtName.setText(name);
        txtMobile.setText(mobile);
        txtEmail.setText(email);
        txtPass.setText(password);
        txtSex.setText(sex);
        txtAge.setText(age);
        txtAgree.setText(agree);
        txtDate.setText(date);
        txtTime.setText(time);


        ImageView ImgBack = (ImageView) findViewById(R.id.imgBackData);
        ImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
