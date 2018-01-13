package com.phppoets.newapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.phppoets.newapp.Adapter.NewsAdapter;
import com.phppoets.newapp.Model.News.NewsResponse;
import com.phppoets.newapp.R;
import com.phppoets.newapp.rest.RestClient;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    NewsResponse newsResponse;
    NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
        recyclerView = (RecyclerView) findViewById(R.id.news_recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        getNewsList();
    }

    @OnClick({R.id.BackNews, R.id.imgOption})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.BackRecycle:
                break;
            case R.id.imgOption:
                break;
        }
    }

    public void getNewsList() {
        //Utils.hideKeyboard(Login.this);


        final Call<NewsResponse> loginResponseCall = RestClient.getClient().
                getNewsList();
        loginResponseCall.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                Log.d("MainActivity", "Status Code = " + response.code());

                if (response.isSuccessful()) {
                    newsResponse = response.body();
                    if (newsResponse.getSuccess()) {
                        newsAdapter = new NewsAdapter(NewsActivity.this, newsResponse.getResponse());
                        recyclerView.setAdapter(newsAdapter);
                        // request successful (status code 200, 201)

                    } else {
                        Toast.makeText(NewsActivity.this, newsResponse.getError(), Toast.LENGTH_SHORT).show();
                    }


                } else {
                    // homeResponse received but request not successful (like 400,401,403 etc)
                    //Handle errors
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {

            }
        });
    }


}
