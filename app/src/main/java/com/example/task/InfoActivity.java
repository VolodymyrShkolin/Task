package com.example.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class InfoActivity extends AppCompatActivity {
    TextView firstName, lastName, date, age, city;
    ImageView photoPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        date = findViewById(R.id.date);
        age = findViewById(R.id.age);
        city = findViewById(R.id.city);

        photoPerson = findViewById(R.id.photoPerson);

        Intent intent = getIntent();

        String mFirstName = intent.getStringExtra("firstName");
        String mLastName = intent.getStringExtra("lastName");
        String mDate = intent.getStringExtra("date");
        String mAge = intent.getStringExtra("age");
        String mCity = intent.getStringExtra("city");
        String photo = intent.getStringExtra("photo");

        firstName.setText(mFirstName);
        lastName.setText(mLastName);
        date.setText(mDate);
        age.setText(mAge);
        city.setText(mCity);
        Glide.with(this).load(photo).into(photoPerson);
    }
}