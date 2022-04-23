package edu.neu.madcourse.musicloud;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Posts {
    private String id;
    private String title;
    private String subContent;
    private String image;



    public Posts(String  id, String title, String subContent, String image){
        this.id = id;
        this.title = title;
        this.subContent=subContent;
        this.image=image;

    }

    public String getSubContent() {
        return this.subContent;
    }

    public String getId() {
        return this.id;
    }

    public String getImage() {
        return this.image;
    }

    public String getTitle() {
        return this.title;
    }
}
