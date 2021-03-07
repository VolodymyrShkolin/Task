package com.example.task.data;

import com.google.gson.annotations.SerializedName;

public class Coordinates{

	@SerializedName("latitude")
	private String latitude;

	@SerializedName("longitude")
	private String longitude;

	public String getLatitude(){
		return latitude;
	}

	public String getLongitude(){
		return longitude;
	}
}