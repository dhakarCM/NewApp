package com.phppoets.newapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.phppoets.newapp.Activity.NavigationActivity;
import com.phppoets.newapp.Model.newHome.Initiatives;
import com.phppoets.newapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by user on 12/8/2017.
 */
public class InitiativeAdapter extends RecyclerView.Adapter<InitiativeAdapter.MyViewHolder> {

    List<Initiatives> initiatives;
    NavigationActivity navigationActivity;


    public InitiativeAdapter(NavigationActivity navigationActivity, List<Initiatives> initiatives) {
        this.navigationActivity = navigationActivity;
        this.initiatives = initiatives;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_initiatives, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txtTitle.setText(initiatives.get(position).getTitle());

        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.N) {
            holder.txtDesc.setText(Html.fromHtml(initiatives.get(position).getDescription()));

        } else {

            holder.txtDesc.setText(Html.fromHtml(initiatives.get(position).getDescription(), Html.FROM_HTML_MODE_LEGACY));

        }

        String imgUrl = initiatives.get(position).getPhoto();
        Picasso.with(navigationActivity).load(imgUrl).into(holder.iconIni);
    }

    @Override
    public int getItemCount() {
        return initiatives.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView iconIni;
        TextView txtTitle,txtDesc;


        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            txtTitle = (TextView) view.findViewById(R.id.txtTitleIni);
            txtDesc = (TextView) view.findViewById(R.id.txtIniDesc);

            iconIni = (CircleImageView) view.findViewById(R.id.imgIni);
        }
    }
}
