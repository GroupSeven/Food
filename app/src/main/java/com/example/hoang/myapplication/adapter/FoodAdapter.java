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
import com.example.hoang.myapplication.model.Food;

import java.util.List;

/**
 * Created by hoang on 11/13/16.
 */


public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    private static final String TAG = "SongAdapter";
    private List<Food> mFoodList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public FoodAdapter(Context context, List<Food> datas) {
        mContext = context;
        mFoodList = datas;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.list_item_food, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Food food = mFoodList.get(position);
        holder.tvName.setText(food.getName());
        holder.tvSnip.setText(food.getSnippet());
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
            ivPost = (ImageView) itemView.findViewById(R.id.ivImgFood);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Food food = mFoodList.get(getAdapterPosition());
                    Toast.makeText(mContext, food.getImgUrl(), Toast.LENGTH_SHORT).show();
                    mContext.startActivity(new Intent(mContext, FoodDetailActivity.class));
                }
            });
        }
    }
}