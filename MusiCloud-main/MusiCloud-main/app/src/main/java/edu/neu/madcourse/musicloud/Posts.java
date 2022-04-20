package edu.neu.madcourse.musicloud;

public class Posts {
    private Integer id;
    private String title;
    private String subContent;
    private Integer image;

    public Posts(Integer id, String title, String subContent, Integer image){
        this.id = id;
        this.title = title;
        this.subContent=subContent;
        this.image=image;

    }

    public String getSubContent() {
        return this.subContent;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getImage() {
        return this.image;
    }

    public String getTitle() {
        return this.title;
    }
}
