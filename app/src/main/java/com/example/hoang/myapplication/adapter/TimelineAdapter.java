package com.example.hoang.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.hoang.myapplication.R;
import com.example.hoang.myapplication.activity.FoodDetailActivity;
import com.example.hoang.myapplication.model.Timeline;

import java.util.List;

/**
 * Created by hoang on 11/18/16.
 */



public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.ViewHolder> {
    private static final String TAG = "SongAdapter";
    private List<Timeline> mFoodList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public TimelineAdapter(Context context, List<Timeline> datas) {
        mContext = context;
        mFoodList = datas;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public TimelineAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.list_item_timeline, parent, false);
        return new TimelineAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Timeline food = mFoodList.get(position);
        holder.tvName.setText(food.getName());
        holder.tvSnip.setText(food.getContent());
        Glide.with(mContext)
                .load(food.getImgUrl())
                .placeholder(R.drawable.pladeholder)
                .into(holder.ivPost);
    }

    @Override
    public int getItemCount() {
        return mFoodList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvSnip;
        private ImageView ivPost;

        public ViewHolder(final View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvSnip = (TextView) itemView.findViewById(R.id.tvSnip);
            ivPost = (ImageView) itemView.findViewById(R.id.ivImgPostTiemline);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Timeline food = mFoodList.get(getAdapterPosition());
                    Toast.makeText(mContext, "" + food.getName(), Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(mContext, FoodDetailActivity.class);
//                    mContext.startActivity(new Intent(mContext, SplashActivity.class));
                    i.putExtra("name", food.getName());
                    mContext.startActivity(i);
                }
            });
        }
    }
}