package com.phppoets.newapp.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.phppoets.newapp.R;

public class CheckBoxActivity extends AppCompatActivity {
    CheckBox cb1, cb2, cb3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        btn = (Button) findViewById(R.id.button);
        cb1 = (CheckBox) findViewById(R.id.checkbox1);
        cb2 = (CheckBox) findViewById(R.id.checkbox2);
        cb3 = (CheckBox) findViewById(R.id.checkbox3);
        ImageView imgBack= (ImageView) findViewById(R.id.imgBack);
        imgBack.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                finish();
                return false;
            }
        });
    }


    public void ClickMe(View view) {
        if (cb1.isChecked() == true && cb2.isChecked() == true && cb3.isChecked() == true) {
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFFFFF"));
        } else if (cb1.isChecked() == true && cb2.isChecked() == true) {
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFFF00"));
        } else if (cb1.isChecked() == true && cb3.isChecked() == true) {
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF00FF"));
        } else if (cb2.isChecked() == true && cb3.isChecked() == true) {
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
        } else if (cb1.isChecked() == true) {
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));
        } else if (cb2.isChecked() == true) {
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FF00"));
        } else if (cb3.isChecked() == true) {
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#0000FF"));
        } else
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFFFFF"));
    }



}
