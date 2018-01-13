package com.phppoets.newapp.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.phppoets.newapp.Model.EventDetail.EventDetailResponse;
import com.phppoets.newapp.R;
import com.phppoets.newapp.rest.RestClient;
import com.phppoets.newapp.support.AppConfig;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by user on 12/1/2017.
 */
public class EventDetailActivity extends AppCompatActivity {

    EventDetailResponse eventDetailResponse;
    SharedPreferences sharedPreferences;
    int userId, eventId;

    ImageView imgEvent;
    TextView txtTitleEvent, txtDateEvent, txtLocationEvent, txtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_detail);
        ButterKnife.bind(this);
        imgEvent = (ImageView) findViewById(R.id.imgEvent);
        txtTitleEvent= (TextView) findViewById(R.id.txtTitleEvent);
        txtDateEvent= (TextView) findViewById(R.id.txtDateEvent);
        txtLocationEvent= (TextView) findViewById(R.id.txtLocationEvent);
        txtDescription= (TextView) findViewById(R.id.txtDescription);

        sharedPreferences = getSharedPreferences(AppConfig.KEY_PREFS_NAME, MODE_PRIVATE);
        userId = sharedPreferences.getInt(AppConfig.KEY_USER_ID, 0);
        if (getIntent().hasExtra("eventId"))
            eventId = getIntent().getIntExtra("eventId", 0);
        getEventList(userId, eventId);
    }

    public void getEventList(int userId, final int eventId) {
        //Utils.hideKeyboard(Login.this);


        final Call<EventDetailResponse> loginResponseCall = RestClient.getClient().
                getEventDetail(userId, eventId);
        loginResponseCall.enqueue(new Callback<EventDetailResponse>() {
            @Override
            public void onResponse(Call<EventDetailResponse> call, Response<EventDetailResponse> response) {
                Log.d("MainActivity", "Status Code = " + response.code());

                if (response.isSuccessful()) {
                    eventDetailResponse = response.body();
                    if (eventDetailResponse.getSuccess()) {
                        String imgUrl = eventDetailResponse.getEvent().get(0).getCoverImageFullpath();
                        Picasso.with(EventDetailActivity.this).load(imgUrl).into(imgEvent);
                        txtTitleEvent.setText(eventDetailResponse.getEvent().get(0).getName());
                        txtLocationEvent.setText(eventDetailResponse.getEvent().get(0).getLocation());
                        txtDateEvent.setText(eventDetailResponse.getEvent().get(0).getEventDay()+", " + eventDetailResponse.getEvent().get(0).getEventDate()+" "+ eventDetailResponse.getEvent().get(0).getTime());

                        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.N) {
                            txtDescription.setText(Html.fromHtml(eventDetailResponse.getEvent().get(0).getDescription()));
                        } else {

                            txtDescription.setText(Html.fromHtml(eventDetailResponse.getEvent().get(0).getDescription(), Html.FROM_HTML_MODE_LEGACY));

                        }

                        // request successful (status code 200, 201)

                    } else {
                        Toast.makeText(EventDetailActivity.this, eventDetailResponse.getError(), Toast.LENGTH_SHORT).show();
                    }


                } else {
                    // homeResponse received but request not successful (like 400,401,403 etc)
                    //Handle errors
                }
            }

            @Override
            public void onFailure(Call<EventDetailResponse> call, Throwable t) {

            }


        });
    }

}