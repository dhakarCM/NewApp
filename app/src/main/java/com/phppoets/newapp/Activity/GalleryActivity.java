package com.phppoets.newapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.phppoets.newapp.Adapter.GalleryAdapter;
import com.phppoets.newapp.Model.Gallery.GalleriesResponse;
import com.phppoets.newapp.R;
import com.phppoets.newapp.rest.RestClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryActivity extends AppCompatActivity {

    @BindView(R.id.BackRecycle)
    ImageView BackRecycle;
    @BindView(R.id.txtAct)
    TextView txtAct;
    @BindView(R.id.imgOption)
    ImageView imgOption;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    GalleriesResponse galleriesResponse;
    GalleryAdapter galleryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        ButterKnife.bind(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewGallery);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        getGalleryList();
    }

    @OnClick({R.id.BackRecycle, R.id.imgOption})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.BackRecycle:
                break;
            case R.id.imgOption:
                break;
        }
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
                        galleryAdapter = new GalleryAdapter(GalleryActivity.this, galleriesResponse.getGallery());
                        recyclerView.setAdapter(galleryAdapter);
                        // request successful (status code 200, 201)
                    } else {
                        Toast.makeText(GalleryActivity.this, galleriesResponse.getError(), Toast.LENGTH_SHORT).show();
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
