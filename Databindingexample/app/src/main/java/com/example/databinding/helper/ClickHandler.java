package com.example.databinding.helper;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.example.databinding.model.User;

public class ClickHandler {

    Context context;

    public ClickHandler(Context context) {
        this.context = context;
    }

    public void onFabClicked(User user) {

    }

    public void onButtonClick(View view) {
        Toast.makeText(context, "Button clicked!", Toast.LENGTH_SHORT).show();
    }

    public void onButtonClickWithParam(User user) {
        Toast.makeText(context, "Button clicked! Name: " + user.name.get(), Toast.LENGTH_SHORT).show();
        user.name.set("test");
        user.email.set("test@gmail.com");

    }

    public boolean onButtonLongPressed(View view) {
        Toast.makeText(context, "Button long pressed!", Toast.LENGTH_SHORT).show();
        return false;
    }

    public void onChangeText(CharSequence s, User user){
        user.name.set(s.toString());
    }
}