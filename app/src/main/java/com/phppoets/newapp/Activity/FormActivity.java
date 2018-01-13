package com.phppoets.newapp.Activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.phppoets.newapp.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class FormActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String name, mobile, email, password, sex, age, agree, date,time;
    Button buttonSignUp, buttonContinue;
    EditText editName, editMobile, editEmail, editPassword;
    RadioGroup radiogrp;
    Spinner spinner1;
    RadioButton rbtn;
    CheckBox checkb;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private int year;
    private int month;
    private int day;
    TextView textDate, textTime;
    static final int DATE_PICKER_ID = 1111;
    private int hour;
    private int minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        editName = (EditText) findViewById(R.id.editName);
        editMobile = (EditText) findViewById(R.id.editMobile);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editPassword = (EditText) findViewById(R.id.editPassword);
        buttonSignUp = (Button) findViewById(R.id.buttonSubmit);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        radiogrp = (RadioGroup) findViewById(R.id.radiogrp);
        checkb = (CheckBox) findViewById(R.id.checkboxAgree);
        buttonContinue = (Button) findViewById(R.id.buttonContinue);
        buttonContinue.setVisibility(View.GONE);
        textDate = (TextView) findViewById(R.id.textDate);
        textTime = (TextView) findViewById(R.id.textTime);
        final Calendar c = Calendar.getInstance();


        ImageView backbtn= (ImageView) findViewById(R.id.imgBackForm);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        textDate.setText(new StringBuilder()
                .append("DD").append("-").append("MM").append("-").append("YY").append(""));

        textTime.setText(new StringBuilder().append("HH").append(":").append("MM").append(""));

        date=textDate.getText().toString();
        time=textTime.getText().toString();

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValid()) {
                    int selected = radiogrp.getCheckedRadioButtonId();
                    rbtn = (RadioButton) findViewById(selected);


                    if (rbtn == null) {
                        Toast.makeText(view.getContext(), "Select Sex", Toast.LENGTH_SHORT).show();
                        return;

                    } else if (age.equalsIgnoreCase("select")) {
                        Toast.makeText(view.getContext(), "Please Select age", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (date.equalsIgnoreCase("DD:MM:YY")) {
                        Toast.makeText(view.getContext(),"please Enter Date", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (checkb.isChecked() != true) {
                        Toast.makeText(view.getContext(), "Please Check Agree Box", Toast.LENGTH_SHORT).show();
                        return;

                    } else
                        agree = "Agreed";
                    sex = rbtn.getText().toString();
                    Toast.makeText(view.getContext(), "Submitted", Toast.LENGTH_LONG).show();





                    buttonContinue.setVisibility(View.VISIBLE);

                }
            }
        });


        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putString("mobile", mobile);
                bundle.putString("email", email);
                bundle.putString("pass", password);
                bundle.putString("sex", sex);
                bundle.putString("age", age);
                bundle.putString("agree", agree);
                bundle.putString("date",date);
                bundle.putString("time",time);
                Intent i = new Intent(FormActivity.this, DataActivity.class);
                i.putExtras(bundle);
                startActivity(i);

            }


        });


        spinner1.setOnItemSelectedListener(this);
        List<String> age = new ArrayList<String>();
        age.add("Select");
        age.add("15");
        age.add("20");
        age.add("25");
        age.add("30");
        age.add("35");
        age.add("40");
        age.add("45");
        age.add("50");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, age);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);

        textDate.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // On button click show datepicker dialog
                showDialog(DATE_PICKER_ID);
                return false;
            }
        });

        textTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                hour = c.get(Calendar.HOUR_OF_DAY);
                minute = c.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(FormActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        hour=selectedHour;
                        minute=selectedMinute;
                        textTime.setText(new StringBuilder().append(hour)
                                .append(":").append(minute).append(" "));
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        age = parent.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }

    public boolean isValid() {
        name = editName.getText().toString();
        mobile = editMobile.getText().toString();
        email = editEmail.getText().toString();


        password = editPassword.getText().toString();


        if (name.equalsIgnoreCase("")) {
            Toast.makeText(FormActivity.this, "EnterName", Toast.LENGTH_SHORT).show();
            return false;
        } else if (mobile.equalsIgnoreCase("")) {
            Toast.makeText(FormActivity.this, "Enter Mobile No", Toast.LENGTH_SHORT).show();
            return false;
        } else if (mobile.length() < 10) {
            Toast.makeText(FormActivity.this, "Enter Valid Mobile No", Toast.LENGTH_SHORT).show();
            return false;
        } else if (email.equalsIgnoreCase("")) {
            Toast.makeText(FormActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!email.matches(emailPattern)) {
            Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
            return false;
        } else if (password.equalsIgnoreCase("")) {
            Toast.makeText(FormActivity.this, "Enter Pass Word", Toast.LENGTH_SHORT).show();
            return false;
        } else if (password.length() < 8) {
            Toast.makeText(FormActivity.this, "Min Password Length 8", Toast.LENGTH_SHORT).show();
            return false;
        } else
            return true;
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_PICKER_ID:


                DatePickerDialog datePickerDialog = new DatePickerDialog(this, pickerListener, year, month, day);

                Date newDate = new Date();

                datePickerDialog.getDatePicker().setMaxDate(2000);
                return datePickerDialog;
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        @Override
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {

            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            // Show selected date
            textDate.setText(new StringBuilder().append(day)
                    .append("-").append(month + 1).append("-").append(year)
                    .append(" "));

        }
    };




}