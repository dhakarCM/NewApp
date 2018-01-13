package com.phppoets.newapp.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.phppoets.newapp.Activity.EventActivity;
import com.phppoets.newapp.Activity.EventDetailActivity;
import com.phppoets.newapp.Model.event.Eventlist;
import com.phppoets.newapp.R;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {
    String str;

    List<Eventlist> eventlists;
    EventActivity eventActivity;
    @BindView(R.id.imgEvent)
    ImageView imgEvent;
    @BindView(R.id.txtDate)
    TextView txtDate;
    @BindView(R.id.txtMonth)
    TextView txtMonth;
    @BindView(R.id.dateLayout)
    RelativeLayout dateLayout;
    @BindView(R.id.txtTitleEvent)
    TextView txtTitleEvent;
    @BindView(R.id.txtTimeEvent)
    TextView txtTimeEvent;
    @BindView(R.id.txtLocationEvent)
    TextView txtLocationEvent;


    public EventAdapter(EventActivity eventActivity, List<Eventlist> eventlists) {
        this.eventActivity = eventActivity;
        this.eventlists = eventlists;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_event, parent, false);
        return new MyViewHolder(itemView);

    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        String input = eventlists.get(position).getEventDate();


        holder.txtDate.setText(parseDateToddMMyyyy(eventlists.get(position).getDate()));
        holder.txtMonth.setText(eventlists.get(position).getEventMonth());
        holder.txtTitleEvent.setText(eventlists.get(position).getName());
        holder.txtTimeEvent.setText(eventlists.get(position).getEventDay() + " " + eventlists.get(position).getTime() + " ,");
        holder.txtLocationEvent.setText(eventlists.get(position).getLocation());

        String imgUrl = eventlists.get(position).getCoverImageFullpath();
        Picasso.with(eventActivity).load(imgUrl).into(holder.imgEvent);

        holder.imgEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                eventActivity.startActivity(new Intent(eventActivity, EventDetailActivity.class).putExtra("eventId", eventlists.get(position).getId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return eventlists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtDate, txtMonth, txtTitleEvent, txtTimeEvent, txtLocationEvent;
        public ImageView imgEvent;

        public MyViewHolder(View view) {
            super(view);
            txtDate = (TextView) view.findViewById(R.id.txtDate);
            txtMonth = (TextView) view.findViewById(R.id.txtMonth);
            txtTitleEvent = (TextView) view.findViewById(R.id.txtTitleEvent);
            txtTimeEvent = (TextView) view.findViewById(R.id.txtTimeEvent);
            txtLocationEvent = (TextView) view.findViewById(R.id.txtLocationEvent);
            imgEvent = (ImageView) view.findViewById(R.id.imgEvent);
        }
    }

    public String parseDateToddMMyyyy(String time) {
        String inputPattern = "dd-MM-yyyy";
        String outputPattern = "dd";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }
}
