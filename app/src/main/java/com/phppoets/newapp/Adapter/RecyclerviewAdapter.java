package com.phppoets.newapp.Adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.phppoets.newapp.Activity.RecyclerviewActivity;
import com.phppoets.newapp.Model.Gallery.Response;
import com.phppoets.newapp.Model.Movie.Movie;
import com.phppoets.newapp.Model.blog.Blogs;
import com.phppoets.newapp.Model.event.Eventlist;
import com.phppoets.newapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by user on 11/10/2017.
 */
public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {

    List<Movie> movieList;
    List<Eventlist> eventlist;
    List<Blogs> blogs;
    List<Response> responses;
    RecyclerviewActivity recyclerviewActivity;

    public RecyclerviewAdapter(List<Movie> movieList) {
        this.movieList = movieList;

    }

    public RecyclerviewAdapter(RecyclerviewActivity recyclerviewActivity, List<Eventlist> eventlist,String test) {
        this.recyclerviewActivity = recyclerviewActivity;
        this.eventlist = eventlist;
    }

//    public RecyclerviewAdapter(RecyclerviewActivity recyclerviewActivity, List<Blogs> blogs) {
//        this.recyclerviewActivity = recyclerviewActivity;
//        this.blogs = blogs;
//    }

    public RecyclerviewAdapter(RecyclerviewActivity recyclerviewActivity, List<Response> response) {
        this.recyclerviewActivity = recyclerviewActivity;
        this.responses = response;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerviewAdapter.MyViewHolder holder, int position) {
        holder.title.setText(responses.get(position).getName());
//        holder.year.setText(responses.get(position).getCreatedBy());
//        holder.genre.setText(responses.get(position).getId());
        String imgUrl = responses.get(position).getGalleryCoverPhotos();
        Picasso.with(recyclerviewActivity).load(imgUrl).into(holder.imgEvent);
    }

    @Override
    public int getItemCount() {
        return responses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
        public ImageView imgEvent;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            imgEvent = (ImageView) view.findViewById(R.id.imgEvent);
        }
    }
}
