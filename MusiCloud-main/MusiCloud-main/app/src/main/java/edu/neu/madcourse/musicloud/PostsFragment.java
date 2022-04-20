package edu.neu.madcourse.musicloud;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class PostsFragment extends Fragment {
    private ArrayList<Posts> postsArrayList = new ArrayList<>();
    private LinearLayoutManager rLayoutManager;
    private RelativeLayout dashboard;
    private RelativeLayout dashboardHead;
    private RecyclerView recyclerView;
    private RecyclerviewAdapter recyclerViewAdapter;
    private View view;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private User user;
    private DataSnapshot dataSnapshot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        databaseReference = firebaseDatabase.getReference("https://console.firebase.google.com/u/0/project/musicloud-28210/database/musicloud-28210-default-rtdb/data/~2Fposts~2F-Mzxvh57q8aioVtBv8VZ");
//        databaseReference.child("users").child("TestUser").child("comments").child("-N0-0REC0W-8KDL6z4Uh").child("user").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                user = new User();
//                user = dataSnapshot.getValue(User.class);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//        databaseReference.child("users").child("TestUser").child("comments").child("-N0-0REC0W-8KDL6z4Uh").child("postId").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String postId = dataSnapshot.getValue(String.class);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });


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
        postsArrayList.add(new Posts(0,"The Weekend","Great!",R.drawable.anon));
        postsArrayList.add(new Posts(1,"avril","Nice",R.drawable.cat));
        postsArrayList.add(new Posts(2,"index","Boring",R.drawable.ic_baseline_arrow_back_24));
        postsArrayList.add(new Posts(3,"plain","Nothing",R.drawable.ic_baseline_menu_24));
    }





}