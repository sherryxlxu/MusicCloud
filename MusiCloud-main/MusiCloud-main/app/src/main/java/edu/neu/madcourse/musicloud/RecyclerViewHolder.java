package edu.neu.madcourse.musicloud;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder{
    public ImageView imageView;
    public TextView postsTitle;
    public TextView subContent;
    public Integer id;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.albumCover1);
        postsTitle = itemView.findViewById(R.id.post_title);
        subContent = itemView.findViewById(R.id.subContent);
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
