package com.phppoets.newapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.phppoets.newapp.Adapter.RecyclerviewAdapter;
import com.phppoets.newapp.Model.Gallery.GalleriesResponse;
import com.phppoets.newapp.Model.blog.BlogResponse;
import com.phppoets.newapp.Model.event.EventResponse;
import com.phppoets.newapp.R;
import com.phppoets.newapp.rest.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerviewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerviewAdapter mAdapter;
    EventResponse eventResponse;
    BlogResponse blogResponse;
    GalleriesResponse galleriesResponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        recyclerView = (RecyclerView) findViewById(R.id.movieList);
//        prepareMovieData();


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //getEventList();
//        getBlogList();
        getGalleryList();
        ImageView imgback= (ImageView) findViewById(R.id.BackRecycle);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

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
                        mAdapter = new RecyclerviewAdapter(RecyclerviewActivity.this,eventResponse.getEventlist(),"");
                        recyclerView.setAdapter(mAdapter);
                        // request successful (status code 200, 201)

                    } else {
                        Toast.makeText(RecyclerviewActivity.this, eventResponse.getError(), Toast.LENGTH_SHORT).show();
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


    public void getGalleryList() {
        //Utils.hideKeyboard(Login.this);


        final Call<GalleriesResponse> loginResponseCall = RestClient.getClient().
                getGalleryList();
        loginResponseCall.enqueue(new Callback<GalleriesResponse>() {
            @Override
            public void onResponse(Call<GalleriesResponse> call, Response<GalleriesResponse> response) {
                Log.d("MainActivity", "Status Code = " + response.code());

                if (response.isSuccessful()) {
                    galleriesResponse = response.body();
                    if (galleriesResponse.getSuccess()) {
                        mAdapter = new RecyclerviewAdapter(RecyclerviewActivity.this,galleriesResponse.getResponse());
                        recyclerView.setAdapter(mAdapter);
                        // request successful (status code 200, 201)

                    } else {
                        Toast.makeText(RecyclerviewActivity.this, eventResponse.getError(), Toast.LENGTH_SHORT).show();
                    }


                } else {
                    // homeResponse received but request not successful (like 400,401,403 etc)
                    //Handle errors
                }
            }

            @Override
            public void onFailure(Call<GalleriesResponse> call, Throwable t) {

            }
        });
    }

}
