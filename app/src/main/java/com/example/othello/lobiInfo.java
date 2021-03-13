package com.example.othello;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Comment;

import java.util.ArrayList;

public class lobiInfo {
    private static final String TAG = "lobiInfo";

    FirebaseDatabase database;
    ArrayList<room> rooms;
//    FirebaseDatabase database;
//    DatabaseReference myRef;

    public lobiInfo(){
//        database = FirebaseDatabase.getInstance();
//        myRef = database.getReference("message");
        database = FirebaseDatabase.getInstance();

        rooms = new ArrayList<room>();

        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildAdded:" + dataSnapshot.getKey());

                // A new comment has been added, add it to the displayed list
                room room1 = dataSnapshot.getValue(room.class);
                rooms.add(room1);
                // ...
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
//                Log.d(TAG, "onChildChanged:" + dataSnapshot.getKey());
//
//                // A comment has changed, use the key to determine if we are displaying this
//                // comment and if so displayed the changed comment.
//                Comment newComment = dataSnapshot.getValue(Comment.class);
//                String commentKey = dataSnapshot.getKey();

                // ...
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
//                Log.d(TAG, "onChildRemoved:" + dataSnapshot.getKey());
//
//                // A comment has changed, use the key to determine if we are displaying this
//                // comment and if so remove it.
//                String commentKey = dataSnapshot.getKey();
//
//                // ...
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
//                Log.d(TAG, "onChildMoved:" + dataSnapshot.getKey());
//
//                // A comment has changed position, use the key to determine if we are
//                // displaying this comment and if so move it.
//                Comment movedComment = dataSnapshot.getValue(Comment.class);
//                String commentKey = dataSnapshot.getKey();

                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
//                Log.w(TAG, "postComments:onCancelled", databaseError.toException());
//                Toast.makeText(, "Failed to load comments.",
//                        Toast.LENGTH_SHORT).show();
            }
        };
        DatabaseReference ref = database.getReference().child("he");
        ref.addChildEventListener(childEventListener);
    }

    public void create_room(String room_name, String head, String load){
        room room1 = new room(room_name, head, load);

        DatabaseReference myRef = database.getReference(room_name);
        myRef.setValue(room1);

    }

    public void entrance_room(String room_name, String load){


        for(int i=0;i<rooms.size();i++){
            if(rooms.get(i).getRoom_name().equals(room_name)){
                room room1 = rooms.get(i);
                room1.setLoad(load);

                DatabaseReference myRef = database.getReference();
                myRef.setValue(room1);
            }

        }

    }




    //   ValueEventListener postListener = new ValueEventListener() {
//        @Override
//        public void onDataChange(DataSnapshot dataSnapshot) {
//            // Get Post object and use the values to update the UI
//            room room1 = dataSnapshot.getValue(room.class);
//            // ..
//        }
//
//        @Override
//        public void onCancelled(DatabaseError databaseError) {
//            // Getting Post failed, log a message
//            Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//        }
//    };
//    mPostReference.addValueEventListener(postListener);
}
