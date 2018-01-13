package com.phppoets.newapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.phppoets.newapp.R;

public class RadioActivity extends AppCompatActivity {
    Button btngo;
    RadioGroup rg1;
    RadioButton rbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        addListenerRadioButton();

    }
    private void addListenerRadioButton(){
        rg1= (RadioGroup) findViewById(R.id.group1);
        btngo= (Button) findViewById(R.id.buttonGo);
        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selected = rg1.getCheckedRadioButtonId();
                rbtn= (RadioButton) findViewById(selected);
                if(rbtn==null){
                    Toast.makeText(RadioActivity.this,"Please Select",Toast.LENGTH_LONG).show();
                }
                else
                Toast.makeText(RadioActivity.this,rbtn.getText(),Toast.LENGTH_LONG).show();
            }
        });

    }
}
