package com.munshig.shaw.user;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class settings extends AppCompatActivity implements View.OnClickListener{

    TextView settings_textview;
    Spinner shared_pref;
    Button settings_save_button;
    final String Pref = "MyPrefs";
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        settings_textview = findViewById(R.id.text_samples);
        shared_pref = findViewById(R.id.shared_pref);
        settings_save_button = findViewById(R.id.save_button);
        settings_save_button.setOnClickListener(this);
        sharedPreferences = getSharedPreferences(Pref, Context.MODE_PRIVATE);
    }


    public void shared(){

        int number = Integer.parseInt(shared_pref.getSelectedItem().toString());
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(Pref, number);
        editor.apply();
        Toast.makeText(this, "Kitne aadmi the," + " "+number + "  Sarkar!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.save_button:
                shared();
                break;

        }
    }
}
