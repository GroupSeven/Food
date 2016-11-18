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

import com.example.hoang.myapplication.R;
import com.example.hoang.myapplication.activity.UserStoreActivity;
import com.example.hoang.myapplication.model.StoreUser;

import java.util.List;

/**
 * Created by hoang on 11/15/16.
 */

public class ListStoreAdapter extends RecyclerView.Adapter<ListStoreAdapter.ViewHolder> {
    private static final String TAG = "SongAdapter";
    private List<StoreUser> mFoodList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public ListStoreAdapter(Context context, List<StoreUser> datas) {
        mContext = context;
        mFoodList = datas;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ListStoreAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.list_item_store, parent, false);
        return new ListStoreAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        StoreUser storeUser = mFoodList.get(position);
        holder.tvName.setText(storeUser.getName());
        holder.tvSnip.setText(storeUser.getPhone());
//        Glide.with(mContext)
////                .load(storeUser.getImgUrl())
//                .placeholder(R.drawable.pladeholder)
//                .into(holder.ivPost);
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
                    StoreUser storeUser = mFoodList.get(getAdapterPosition());
                    Toast.makeText(mContext, "" + storeUser.getName(), Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(mContext, UserStoreActivity.class);
//                    mContext.startActivity(new Intent(mContext, SplashActivity.class));
                    i.putExtra("name", storeUser.getName());
                    i.putExtra("phone", storeUser.getPhone());
                    mContext.startActivity(i);
                }
            });
        }
    }
}