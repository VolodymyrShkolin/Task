package com.example.task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.task.databinding.ActivityInfoBinding;
import com.example.task.user.User;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityInfoBinding activityInfoBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_info);

        Intent intent = getIntent();
        String mFirstName = intent.getStringExtra("firstName");
        String mLastName = intent.getStringExtra("lastName");
        String mDate = intent.getStringExtra("date");
        String mAge = intent.getStringExtra("age");
        String mCity = intent.getStringExtra("city");
        String photo = intent.getStringExtra("photo");

        User user = new User(photo, mFirstName, mLastName, mDate, mAge, mCity);
        activityInfoBinding.setUser(user);
    }
}