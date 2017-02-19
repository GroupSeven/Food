package com.example.hoang.myapplication.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.hoang.myapplication.R;
import com.example.hoang.myapplication.activity.UserStoreActivity;
import com.example.hoang.myapplication.helper.Helper;
import com.example.hoang.myapplication.model.Timeline;

import java.util.List;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

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
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Timeline timeline = mFoodList.get(position);
        holder.tvName.setText(timeline.getName());
        holder.tvSnip.setText(timeline.getContent());
        Glide.with(mContext)
                .load(timeline.getImgUrl())
                .placeholder(R.drawable.pladeholder)
                .centerCrop()
                .into(holder.ivPost);
        Glide.with(mContext)
                .load(timeline.getAvatar())
                .placeholder(R.drawable.pladeholder)
                .into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        holder.userAvatar.setImageDrawable(resource);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return mFoodList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView userAvatar;
        private TextView tvName;
        private TextView tvSnip;
        private ImageView ivPost;
        private LinearLayout emoActionButton;
        private LinearLayout commentActionButton;
        private LinearLayout shareActionButton;

        public ViewHolder(final View itemView) {
            super(itemView);
            userAvatar = (CircleImageView) itemView.findViewById(R.id.ivUserAvatar);
            emoActionButton = (LinearLayout) itemView.findViewById(R.id.button_addemotion);
            commentActionButton = (LinearLayout) itemView.findViewById(R.id.button_addcomment);
            shareActionButton = (LinearLayout) itemView.findViewById(R.id.button_addfollow);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvSnip = (TextView) itemView.findViewById(R.id.tvSnip);
            ivPost = (ImageView) itemView.findViewById(R.id.ivImgPostTiemline);

            imgViewCLickAction();
            emoAction();
            commentAction();
            shareAction();
        }

        private void imgViewCLickAction() {
            ivPost.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Timeline timeline = mFoodList.get(getAdapterPosition());
                    Toast.makeText(mContext, "" + timeline.getName(), Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(mContext, UserStoreActivity.class);
//                    mContext.startActivity(new Intent(mContext, SplashActivity.class));
                    i.putExtra("name", timeline.getName());
                    mContext.startActivity(i);
                }
            });

            userAvatar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Timeline timeline = mFoodList.get(getAdapterPosition());
                    Toast.makeText(mContext, "" + timeline.getAvatar(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        private void shareAction() {
            shareActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "Sharing button", Toast.LENGTH_SHORT).show();
                    Helper.ShowDialog("Adding action for Share", mContext);
                }

            });
        }

        private void commentAction() {
            commentActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "Comment Button", Toast.LENGTH_SHORT).show();
                    Helper.ShowDialog("Adding action for Comment", mContext);
                }
            });
        }

        private void emoAction() {
            emoActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "Emotion Button", Toast.LENGTH_SHORT).show();
                    Helper.ShowDialog("Adding action for Commen", mContext);


                }
            });
        }


    }
}