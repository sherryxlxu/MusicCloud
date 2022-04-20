package edu.neu.madcourse.musicloud;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{
    private ArrayList<Posts> postsArrayList;

    public RecyclerviewAdapter(ArrayList<Posts> postsArrayList){
        this.postsArrayList = postsArrayList;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_list,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Posts post = postsArrayList.get(position);
        holder.setId(post.getId());
        holder.postsTitle.setText(post.getTitle());
        holder.subContent.setText(post.getSubContent());
        holder.imageView.setImageResource(post.getImage());

    }

    @Override
    public int getItemCount() {
        return postsArrayList.size();
    }
}
