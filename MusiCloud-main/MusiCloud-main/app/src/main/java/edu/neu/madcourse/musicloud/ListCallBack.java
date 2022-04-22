package edu.neu.madcourse.musicloud;

import java.util.ArrayList;

import edu.neu.madcourse.musicloud.comments.Comment;

public interface ListCallBack {
    void ListCallBack(ArrayList<Comment> commentArrayList, ArrayList<Posts>postsArrayList);
}
