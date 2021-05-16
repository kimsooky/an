package com.ssaurel.count;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    Context context;
    List<Item> postList;

    public PostAdapter(Context context, List<Item> postList){
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(context).inflate(R.layout.rachpost, parent, false);
        return new PostHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {

        Item item = postList.get(position);
        holder.setImageView(item.getImageUrl());
        holder.setmTags(item.getTags());
        holder.setmLikes(item.getLikes());
        holder.setFavIV();
        holder.setmFav(item.getFav());
        holder.fav.setOnClickListener(v -> {
            item.setFav(!item.getFav());

            // save api
            callbackPost.saveFav(item);

            holder.setmFav(item.getFav());
        });
//        holder.setmheart(item.getBtn());

    }

    public CallbackPost callbackPost;

    interface CallbackPost {
        public void saveFav(Item item);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView mLikes, mTags;
        View view;
        //        View favbtn;
        ImageView fav;

        public PostHolder(@NonNull View itemView){
            super(itemView);
            view = itemView;
        }

        public void setImageView(String url){
            imageView = view.findViewById(R.id.imageview);
            Glide.with(context).load(url).into(imageView);
        }
        public void setmLikes(int likes){
            mLikes = view.findViewById(R.id.likes);
            mLikes.setText(likes + " CAL");
        }
        public void  setmTags(String tags){
            mTags = view.findViewById(R.id.tags);
            mTags.setText(tags);
        }
        //        public void  setmheart(Button favBtn){
//            favbtn = view.findViewById(R.id.favBtn);
//        }
        public void  setmFav(Boolean status){
            if(status){
                fav.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
            } else {
                fav.setBackgroundResource(R.drawable.ic_baseline_gray_24);
            }
        }

        public void setFavIV() {
            fav = view.findViewById(R.id.favBtn);
        }
    }
}
