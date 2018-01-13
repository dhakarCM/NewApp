package com.phppoets.newapp.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.phppoets.newapp.Activity.NavigationActivity;
import com.phppoets.newapp.Model.newHome.Events;
import com.phppoets.newapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by user on 12/9/2017.
 */
public class EventHomeAdapter extends PagerAdapter {
    private LayoutInflater layoutInflater;
    List<Events>eventsList;
    NavigationActivity navigationActivity;

    public EventHomeAdapter (NavigationActivity navigationActivity, List<Events>events){
        this.navigationActivity=navigationActivity;
        this.eventsList=events;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) navigationActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.custom_event_home, container, false);

        ImageView imgEvent;
        TextView txtTitle,txtDesc,txtTime,txtLocation;

        imgEvent= (ImageView) itemView.findViewById(R.id.imgEventHome);
        txtTitle= (TextView) itemView.findViewById(R.id.txtTitleEventHome);
        txtDesc= (TextView) itemView.findViewById(R.id.txtDescEventHome);
        txtTime= (TextView) itemView.findViewById(R.id.txtTimeEventHome);
        txtLocation= (TextView) itemView.findViewById(R.id.txtLocationHome);


        String url = eventsList.get(position).getCoverImageFullpath();
        Picasso.with(navigationActivity.getApplicationContext()).load(url).into(imgEvent);

        txtTitle.setText(eventsList.get(position).getName());
        txtTime.setText(eventsList.get(position).getEventDay()+" "+eventsList.get(position).getTime()+", ");


        txtLocation.setText(eventsList.get(position).getLocation());

        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.N) {
            txtDesc.setText(Html.fromHtml(eventsList.get(position).getDescription()));
        } else {

            txtDesc.setText(Html.fromHtml(eventsList.get(position).getDescription(), Html.FROM_HTML_MODE_LEGACY));

        }


        container.addView(itemView);

        return itemView;
    }

    @Override
    public int getCount() {
        return eventsList.size();
    }

    @Override
    public boolean isViewFromObject(View itemView, Object object) {


        return itemView==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }

    //    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_event_home,parent,false);
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(MyViewHolder holder, int position) {
//
//        holder.txtTitle.setText(eventsList.get(position).getName());
//        holder.txtTime.setText(eventsList.get(position).getEventDay()+" "+eventsList.get(position).getTime()+", ");
//
//
//        holder.txtLocation.setText(eventsList.get(position).getLocation());
//
//        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.N) {
//            holder.txtDesc.setText(Html.fromHtml(eventsList.get(position).getDescription()));
//        } else {
//
//            holder.txtDesc.setText(Html.fromHtml(eventsList.get(position).getDescription(), Html.FROM_HTML_MODE_LEGACY));
//
//        }
//
//        String Url=eventsList.get(position).getCoverImageFullpath();
//        Picasso.with(navigationActivity).load(Url).into(holder.imgEvent);
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return eventsList.size();
//    }

//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        ImageView imgEvent;
//        TextView txtTitle,txtDesc,txtTime,txtLocation;
//        public MyViewHolder(View itemView) {
//            super(itemView);
//            imgEvent= (ImageView) itemView.findViewById(R.id.imgEventHome);
//            txtTitle= (TextView) itemView.findViewById(R.id.txtTitleEventHome);
//            txtDesc= (TextView) itemView.findViewById(R.id.txtDescEventHome);
//            txtTime= (TextView) itemView.findViewById(R.id.txtTimeEventHome);
//            txtLocation= (TextView) itemView.findViewById(R.id.txtLocationHome);
//
//        }
//    }
}
