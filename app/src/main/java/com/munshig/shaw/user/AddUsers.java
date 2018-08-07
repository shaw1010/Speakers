package com.munshig.shaw.user;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddUsers extends AppCompatActivity implements View.OnClickListener {

    EditText add_username_edittext;
    EditText add_userage_edittext;
    RadioGroup add_radio_group;
    Spinner add_lang_spinner;
    Button add_add_button;

    DatabaseReference data_users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_users);

        data_users = FirebaseDatabase.getInstance().getReference("Users");
        add_lang_spinner = findViewById(R.id.add_lang_spinner);
        add_add_button = findViewById(R.id.add_add_button);
        add_username_edittext = findViewById(R.id.add_username_edittext);
        add_userage_edittext = findViewById(R.id.add_userage_edittext);
        add_radio_group = findViewById(R.id.add_radio_group);

        add_add_button.setOnClickListener(this);
    }

    private void entry(){
        String name = add_username_edittext.getText().toString().trim();
        String age = add_userage_edittext.getText().toString();
        String lang = add_lang_spinner.getSelectedItem().toString();
        int value = add_radio_group.getCheckedRadioButtonId();
        String user_phone_brand = Build.BRAND;
        String user_phone_model = Build.MODEL;
        String user_phone_version = Build.VERSION.RELEASE;
        int user_phone_api = Build.VERSION.SDK_INT;
        String sex = null;

        if(value!=-1){
            RadioButton selected = findViewById(value);
            sex = selected.getText().toString();

        }else{
            Toast.makeText(this, "Bakchodi mat kar!" , Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(AddUsers.this, name +" "+ age +" "+ sex +" "+ lang + " " + user_phone_api + " " + user_phone_brand + " " + user_phone_model + " " + user_phone_version, Toast.LENGTH_LONG).show();


        if((!name.isEmpty()) && (!age.isEmpty())){

            String id = data_users.push().getKey();

            User_Info user = new User_Info(id, name, age, sex, lang,user_phone_brand,user_phone_model,user_phone_version,user_phone_api);


            data_users.child(id).child("Users Information").setValue(user);

            Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_add_button:
                entry();
                break;
        }
    }
}
