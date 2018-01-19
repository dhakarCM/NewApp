package com.phppoets.newapp.Adapter;


import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.phppoets.newapp.Activity.BlogActivity;
import com.phppoets.newapp.Model.blog.Blogs;
import com.phppoets.newapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by user on 11/10/2017.
 */
public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.MyViewHolder> {


    List<Blogs> blogs;
    BlogActivity recyclerviewActivity;


    public BlogAdapter(BlogActivity recyclerviewActivity, List<Blogs> blogs) {
        this.recyclerviewActivity = recyclerviewActivity;
        this.blogs = blogs;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_blog, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txtTitle.setText(blogs.get(position).getTitle());
        

        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.N) {
           holder.txtContent.setText(Html.fromHtml(blogs.get(position).getDescription()));
        } else {

           holder.txtContent.setText(Html.fromHtml(blogs.get(position).getDescription(), Html.FROM_HTML_MODE_LEGACY));

        }
        String imgUrl = blogs.get(position).getCoverImageFullpath();
        Picasso.with(recyclerviewActivity).load(imgUrl).into(holder.imgBlog);
    }

    @Override
    public int getItemCount() {
        return blogs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgBlog;
        TextView txtTitle;
        TextView txtContent;

        public MyViewHolder(View view) {
            super(view);
            txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            txtContent = (TextView) view.findViewById(R.id.txtContent);
            imgBlog = (ImageView) view.findViewById(R.id.imgBlog);
        }
    }


}
