package com.example.task.user;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class User {
    private String imageUrl;
    private String firstName;
    private String lastName;
    private String date;
    private String age;
    private String city;

    public User(String imageUrl, String firstName){
        this.imageUrl=imageUrl;
        this.firstName=firstName;
    }

    public User(String imageUrl, String firstName,
                String lastName, String date,
                String age, String city) {
        this.imageUrl = imageUrl;
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.age = age;
        this.city = city;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @BindingAdapter("android:loadImage")
    public static void loadImage(ImageView imageView, String imageUrl){
        Glide.with(imageView)
                .load(imageUrl)
                .into(imageView);
    }
}
