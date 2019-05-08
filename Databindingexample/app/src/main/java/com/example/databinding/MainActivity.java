package com.example.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.databinding.databinding.ActivityMainBinding;
import com.example.databinding.helper.ClickHandler;
import com.example.databinding.model.User;

public class MainActivity extends AppCompatActivity {

    private User user;
    private ClickHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        user = new User();
        user.name.set("Sergio");
        user.email.set("sergio@gmail.com");

        handler = new ClickHandler(this);

        binding.setUser(user);
        binding.setHandler(handler);
    }


}
