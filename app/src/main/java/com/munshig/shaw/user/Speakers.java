package com.munshig.shaw.user;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Speakers extends AppCompatActivity implements View.OnClickListener{

    ListView ListView;
    ArrayList<String> usersList = new ArrayList<>();
   // FloatingActionButton  speaker_image_Button=findViewById(R.id.speaker_image_Button);;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speakers);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");
        Log.i(String.valueOf(databaseReference), "I am here");
        ListView = findViewById(R.id.speakers_listview);
        Log.i(String.valueOf(databaseReference), "I am here now!!");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.username,usersList);
        ListView.setAdapter(arrayAdapter);


        findViewById(R.id.speaker_image_Button).setOnClickListener(this);


    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot i: dataSnapshot.getChildren()){
                    String data = (String) i.getValue();
                    Log.i(String.valueOf(databaseReference), "Aggaya abhi Khush!");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.speaker_image_Button:
                startActivity(new Intent(Speakers.this, AddUsers.class));
                break;
        }
    }
}
