package edu.neu.madcourse.musicloud;

import android.widget.Button;

public class Posts {
    private String id;
    private String title;
    private String subContent;
    private Integer image;



    public Posts(String  id, String title, String subContent, Integer image){
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

    public Integer getImage() {
        return this.image;
    }

    public String getTitle() {
        return this.title;
    }
}
