package edu.neu.madcourse.musicloud;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LikesFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private LinearLayoutManager rLayoutManager;
    private RecyclerviewAdapter recyclerViewAdapter;
    private ArrayList<Posts> postsArrayList = new ArrayList<>();
    private ArrayList<String> likesArrayList = new ArrayList<>();
    private DatabaseReference databaseReference;
    private DatabaseReference likesReference;
    private DatabaseReference postDatabase;
    private User user;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        user = MainActivity.currentUser;
        Log.e("Username:",user.getUsername());
        String username = user.getUsername();
        //set up database
        databaseReference = FirebaseDatabase.getInstance().getReference();
        postDatabase = databaseReference.child("posts");
        likesReference = databaseReference.child("users").child(username).child("likes");
        getLikesId();
        view =inflater.inflate(R.layout.fragment_likes, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        rLayoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(rLayoutManager);
        recyclerView.setHasFixedSize(false);
        recyclerViewAdapter = new RecyclerviewAdapter(postsArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),2));

        return view;
    }
    private void getLikesId(){
        likesReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    String postId = dataSnapshot.getValue(String.class);
                    likesArrayList.add(postId);
                }
                addPosts(likesArrayList,postsArrayList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    private void addPosts(ArrayList<String> likesArrayList, ArrayList<Posts>postsArrayList){
        if(likesArrayList!=null && likesArrayList.size()!=0){
            for (String id : likesArrayList){
                getSong(id, new ListCallBack() {
                    @Override
                    public void songCallBack(String title, String content, String image) {
                        postsArrayList.add(new Posts(id,title,content,image));
                        Log.e("Pa size:",String.valueOf(postsArrayList.size()));
                        Log.e("Title",title);
                        Log.e("CommentId:",id);
                        Log.e("content:",content);
                        Log.e("image",image);
                        recyclerViewAdapter.setItems(postsArrayList);
                    }
                });

            }
        }
    }
    private void getSong(String id, ListCallBack callBack){
        postDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Song song = snapshot.child(id).child("song").getValue(Song.class);
                callBack.songCallBack(song.getTitle(),song.getArtist(),song.getImg());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}