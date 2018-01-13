package com.phppoets.newapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.phppoets.newapp.Activity.NavigationActivity;
import com.phppoets.newapp.Model.newHome.Advertisements;
import com.phppoets.newapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by user on 12/8/2017.
 */
public class AdvertiseAdapter extends RecyclerView.Adapter<AdvertiseAdapter.MyViewHolder> {

    List<Advertisements> advertisementsList;
    NavigationActivity navigationActivity;


    public AdvertiseAdapter(NavigationActivity navigationActivity, List<Advertisements> advertisementsList) {
        this.navigationActivity = navigationActivity;
        this.advertisementsList = advertisementsList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_advertisement, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        String imgUrl = advertisementsList.get(position).getImageFullpath();
        Picasso.with(navigationActivity).load(imgUrl).into(holder.imgAdvertise);
    }

    @Override
    public int getItemCount() {
        return advertisementsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAdvertise;


        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

            imgAdvertise = (ImageView) view.findViewById(R.id.imgAdvertise);
        }
    }
}
