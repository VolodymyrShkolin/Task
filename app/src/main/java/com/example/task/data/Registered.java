package com.example.task.data;

import com.google.gson.annotations.SerializedName;

public class Registered{

	@SerializedName("date")
	private String date;

	@SerializedName("age")
	private int age;

	public String getDate(){
		return date;
	}

	public int getAge(){
		return age;
	}
}