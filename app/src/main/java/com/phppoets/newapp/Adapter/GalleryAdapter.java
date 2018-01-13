package com.phppoets.newapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.phppoets.newapp.Activity.GalleryActivity;
import com.phppoets.newapp.Model.Gallery.Response;
import com.phppoets.newapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MyViewHolder> {



    List<Response> responses;
    GalleryActivity galleryActivity;
    @BindView(R.id.imgBlog)
    ImageView imgBlog;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.txtContent)
    TextView txtContent;


    public GalleryAdapter(GalleryActivity galleryActivity, List<Response> responses) {
        this.galleryActivity = galleryActivity;
        this.responses = responses;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_gallery, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txtTitle.setText(responses.get(position).getName());
//        holder.year.setText(responses.get(position).getCreatedBy());
//        holder.genre.setText(responses.get(position).getId());
        String imgUrl = responses.get(position).getGalleryCoverPhotos();
        Picasso.with(galleryActivity).load(imgUrl).into(holder.imgBlog);
    }

    @Override
    public int getItemCount() {
        return responses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTitle, year, genre;
        public ImageView imgBlog;

        public MyViewHolder(View view) {
            super(view);
            txtTitle = (TextView) view.findViewById(R.id.txtTitle);
//            genre = (TextView) view.findViewById(R.id.genre);
//            year = (TextView) view.findViewById(R.id.year);
            imgBlog = (ImageView) view.findViewById(R.id.imgBlog);
        }
    }
}
