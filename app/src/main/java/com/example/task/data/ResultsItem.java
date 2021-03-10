package com.example.task.data;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;

public class ResultsItem{
	@SerializedName("dob")
	private Dob dob;

	@SerializedName("name")
	private Name name;

	@SerializedName("location")
	private Location location;

	@SerializedName("picture")
	private Picture picture;

	public Dob getDob(){
		return dob;
	}

	public Name getName(){
		return name;
	}

	public Location getLocation(){
		return location;
	}

	public Picture getPicture(){
		return picture;
	}

	@BindingAdapter("android:loadImageRI")
	public static void loadImageRI(ImageView imageView, String imageUrl){
		Glide.with(imageView)
				.load(imageUrl)
				.into(imageView);
	}
}