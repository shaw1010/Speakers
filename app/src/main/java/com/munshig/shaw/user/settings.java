package com.munshig.shaw.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class settings extends AppCompatActivity {

    TextView settings_textview;
    Spinner settings_spinner;
    Button settings_save_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        settings_textview = findViewById(R.id.settings_textview);
        settings_spinner = findViewById(R.id.settings_spinner);
        settings_save_button = findViewById(R.id.settings_save_button);

    }
}
