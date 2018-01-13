package com.phppoets.newapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.phppoets.newapp.Adapter.EventAdapter;
import com.phppoets.newapp.Model.event.EventResponse;
import com.phppoets.newapp.R;
import com.phppoets.newapp.rest.RestClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventActivity extends AppCompatActivity {

    @BindView(R.id.imgBackEvent)
    ImageView imgBackEvent;
    @BindView(R.id.txtAct)
    TextView txtAct;
    @BindView(R.id.imgOption)
    ImageView imgOption;
    @BindView(R.id.recyclerViewEvents)
    RecyclerView recyclerViewEvents;
    EventResponse eventResponse;
    EventAdapter eventAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        ButterKnife.bind(this);
        recyclerViewEvents = (RecyclerView) findViewById(R.id.recyclerViewEvents);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewEvents.setLayoutManager(mLayoutManager);
        recyclerViewEvents.setItemAnimator(new DefaultItemAnimator());
        getEventList();
    }

    public void getEventList() {
        //Utils.hideKeyboard(Login.this);


        final Call<EventResponse> loginResponseCall = RestClient.getClient().
                getEventList();
        loginResponseCall.enqueue(new Callback<EventResponse>() {
            @Override
                  public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                Log.d("MainActivity", "Status Code = " + response.code());

                if (response.isSuccessful()) {
                    eventResponse = response.body();
                    if (eventResponse.getSuccess()) {
                        eventAdapter = new EventAdapter(EventActivity.this, eventResponse.getEventlist());
                        recyclerViewEvents.setAdapter(eventAdapter);
                        // request successful (status code 200, 201)

                    } else {
                        Toast.makeText(EventActivity.this, eventResponse.getError(), Toast.LENGTH_SHORT).show();
                    }


                } else {
                    // homeResponse received but request not successful (like 400,401,403 etc)
                    //Handle errors
                }
            }

            @Override
            public void onFailure(Call<EventResponse> call, Throwable t) {

            }


        });
    }

}
