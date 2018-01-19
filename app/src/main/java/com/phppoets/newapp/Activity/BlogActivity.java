package com.phppoets.newapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.phppoets.newapp.Adapter.BlogAdapter;
import com.phppoets.newapp.Model.blog.BlogResponse;
import com.phppoets.newapp.R;
import com.phppoets.newapp.rest.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BlogActivity extends AppCompatActivity {

//    @BindView(R.id.BackRecycle)
//    ImageView BackRecycle;
//    @BindView(R.id.txtAct)
//    TextView txtAct;
//    @BindView(R.id.imgOption)
//    ImageView imgOption;
//    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    BlogResponse blogResponse;
    BlogAdapter blogAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
//        ButterKnife.bind(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        getBlogList();
    }
//
//    @OnClick({R.id.BackRecycle, R.id.imgOption})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.BackRecycle:
//                break;
//            case R.id.imgOption:
//                break;
//        }
//    }

    public void getBlogList() {
        //Utils.hideKeyboard(Login.this);


        final Call<BlogResponse> loginResponseCall = RestClient.getClient().
                getBlogList();
        loginResponseCall.enqueue(new Callback<BlogResponse>() {
            @Override
            public void onResponse(Call<BlogResponse> call, Response<BlogResponse> response) {
                Log.d("MainActivity", "Status Code = " + response.code());

                if (response.isSuccessful()) {
                    blogResponse = response.body();
                    if (blogResponse.getSuccess()) {
                        blogAdapter = new BlogAdapter(BlogActivity.this, blogResponse.getBlogs());
                        recyclerView.setAdapter(blogAdapter);
                        // request successful (status code 200, 201)

                    } else {
                        Toast.makeText(BlogActivity.this, blogResponse.getError(), Toast.LENGTH_SHORT).show();
                    }


                } else {
                    // homeResponse received but request not successful (like 400,401,403 etc)
                    //Handle errors
                }
            }

            @Override
            public void onFailure(Call<BlogResponse> call, Throwable t) {

            }
        });
    }
}
