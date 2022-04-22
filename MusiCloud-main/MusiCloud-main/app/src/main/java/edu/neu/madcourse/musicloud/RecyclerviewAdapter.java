package edu.neu.madcourse.musicloud;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{
    private ArrayList<Posts> postsArrayList;

    public RecyclerviewAdapter(ArrayList<Posts> postsArrayList){
        this.postsArrayList = postsArrayList;
    }
    @SuppressLint("NotifyDataSetChanged")
    public ArrayList<Posts> setItems(ArrayList<Posts> arrayList){
        if(postsArrayList!=null){
            this.postsArrayList = arrayList;
            notifyDataSetChanged();
        }
        return this.postsArrayList;
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
        holder.imageView.setImageDrawable(ContextCompat.getDrawable(holder.imageView.getContext(),post.getImage()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),PostActivity.class);
                intent.putExtra("postId",holder.id);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return postsArrayList.size();
    }
}
