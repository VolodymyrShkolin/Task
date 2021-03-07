package com.example.task.data;

import com.google.gson.annotations.SerializedName;

public class Location{

	@SerializedName("city")
	private String city;

//	@SerializedName("street")
//	private String street;

	@SerializedName("timezone")
	private Timezone timezone;

	@SerializedName("postcode")
	private String postcode;

	@SerializedName("coordinates")
	private Coordinates coordinates;

	@SerializedName("state")
	private String state;

	public String getCity(){
		return city;
	}

//	public String getStreet(){
//		return street;
//	}

	public Timezone getTimezone(){
		return timezone;
	}

	public String getPostcode(){
		return postcode;
	}

	public Coordinates getCoordinates(){
		return coordinates;
	}

	public String getState(){
		return state;
	}
}