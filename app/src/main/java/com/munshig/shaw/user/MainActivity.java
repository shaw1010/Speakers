package com.munshig.shaw.user;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView home_users_textview;
    Button home_speakers_button;
    Button home_settings_button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.home_speakers_button).setOnClickListener(this);
        findViewById(R.id.home_settings_button).setOnClickListener(this);

        home_users_textview = findViewById(R.id.home_username_textview);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home_settings_button:
                startActivity(new Intent(this, settings.class));
                break;
            case R.id.home_speakers_button:
                startActivity(new Intent(this, Speakers.class));
                break;
        }
    }


}
