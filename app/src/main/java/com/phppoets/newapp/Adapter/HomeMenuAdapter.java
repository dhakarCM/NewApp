package com.phppoets.newapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.phppoets.newapp.Activity.NavigationActivity;
import com.phppoets.newapp.Model.newHome.Homemenus;
import com.phppoets.newapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 12/8/2017.
 */
public class HomeMenuAdapter extends RecyclerView.Adapter<HomeMenuAdapter.MyViewHolder> {

    List<Homemenus> homemenuses;
    NavigationActivity navigationActivity;


    public HomeMenuAdapter(NavigationActivity navigationActivity, List<Homemenus> homemenuses) {
        this.navigationActivity = navigationActivity;
        this.homemenuses = homemenuses;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_home_menu, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txtHome.setText(homemenuses.get(position).getName());
        String imgUrl = homemenuses.get(position).getImageFullpath();
        Picasso.with(navigationActivity).load(imgUrl).into(holder.imgHomeMenu);


    }

    @Override
    public int getItemCount() {
        return homemenuses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgBlog)
        ImageView imgHomeMenu;
        @BindView(R.id.txtTitle)
        TextView txtHome;


        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            txtHome = (TextView) view.findViewById(R.id.textMenu);
            imgHomeMenu = (ImageView) view.findViewById(R.id.menuIcon);
        }
    }


}
