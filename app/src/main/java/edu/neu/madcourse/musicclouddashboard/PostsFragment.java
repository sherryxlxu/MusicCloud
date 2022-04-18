package edu.neu.madcourse.musicclouddashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

import java.util.ArrayList;


public class PostsFragment extends Fragment {
    private ArrayList<Posts> postsArrayList = new ArrayList<>();
    private LinearLayoutManager rLayoutManager;
    private RelativeLayout dashboard;
    private RelativeLayout dashboardHead;
    private RecyclerView recyclerView;
    private RecyclerviewAdapter recyclerViewAdapter;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        addPosts();
        view = inflater.inflate(R.layout.fragment_posts, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        rLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(rLayoutManager);
        recyclerView.setHasFixedSize(false);

        recyclerViewAdapter = new RecyclerviewAdapter(postsArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(rLayoutManager);
        return view;

    }



    private void addPosts(){
        postsArrayList.add(new Posts(0,"The Weekend","Great!",R.drawable.weekend));
        postsArrayList.add(new Posts(1,"avril","Nice",R.drawable.avril));
        postsArrayList.add(new Posts(2,"index","Boring",R.drawable.index));
        postsArrayList.add(new Posts(3,"plain","Nothing",R.drawable.plain));
    }





}