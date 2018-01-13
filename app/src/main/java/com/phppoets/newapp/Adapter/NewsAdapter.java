package com.phppoets.newapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.phppoets.newapp.Activity.NewsActivity;
import com.phppoets.newapp.Model.News.Response;
import com.phppoets.newapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {


    List<Response> response;
    NewsActivity newsActivity;


    public NewsAdapter(NewsActivity newsActivity, List<Response> response ) {
        this.newsActivity =  newsActivity;
        this.response = response;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_news, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txtTitle.setText(response.get(position).getTitle());
        holder.txtContent.setText(response.get(position).getDescription());
        String imgUrl = response.get(position).getCoverImageFullpath();
        Picasso.with(newsActivity).load(imgUrl).into(holder.imgBlog);
    }

    @Override
    public int getItemCount() {
        return response.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgBlog;
        TextView txtTitle;
        TextView txtContent;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            txtContent = (TextView) view.findViewById(R.id.txtContent);
            imgBlog = (ImageView) view.findViewById(R.id.imgBlog);
        }
    }


}
