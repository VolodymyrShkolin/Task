package com.example.task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.task.databinding.ActivityInfoBinding;
import com.example.task.user.User;

import org.parceler.Parcels;

public class InfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityInfoBinding activityInfoBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_info);
        Parcelable parcelable = getIntent().getParcelableExtra("DATA_KEY");
        User parcUser = Parcels.unwrap(parcelable);

        User user = new User(parcUser.getImageUrl(), parcUser.getFirstName(),
                parcUser.getLastName(), parcUser.getDate(),
                parcUser.getAge(), parcUser.getCity());
        activityInfoBinding.setUser(user);
    }
}