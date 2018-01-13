package com.phppoets.newapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.phppoets.newapp.Model.newHome.Slider;
import com.phppoets.newapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;
    Activity activity;
    List<Slider> slider;

    public ViewPagerAdapter(Activity activity, List<Slider> sliders) {
        this.activity = activity;
        this.slider=sliders;

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.layout_slider, container, false);
        ImageView im_slider = (ImageView) view.findViewById(R.id.im_slider);

        String url = slider.get(position).getGalleryCoverPhotos();
        Picasso.with(activity.getApplicationContext()).load(url).into(im_slider);


        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return slider.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object obj) {

        return view == obj;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}