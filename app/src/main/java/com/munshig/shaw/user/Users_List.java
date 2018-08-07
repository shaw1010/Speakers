package com.munshig.shaw.user;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static com.munshig.shaw.user.R.*;

public class Users_List extends ArrayAdapter<String> {

    private Activity list;
    private ArrayList<String> userList;

    public Users_List(Activity list, ArrayList<String> userList){
        super(list,layout.username, userList);
        this.list=list;
        this.userList=userList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = list.getLayoutInflater();

        View userInfo_view = inflater.inflate(layout.username,null,true);

        TextView users_list_name = userInfo_view.findViewById(id.users_list_name);
        String user = userList.get(position);
        users_list_name.setText(user);

        return userInfo_view;

    }

    }

