package com.example.task.data;

import com.google.gson.annotations.SerializedName;

public class Location{

	@SerializedName("city")
	private String city;

	@SerializedName("postcode")
	private String postcode;

	@SerializedName("state")
	private String state;

	public String getCity(){
		return city;
	}

	public String getPostcode(){
		return postcode;
	}

	public String getState(){
		return state;
	}
}