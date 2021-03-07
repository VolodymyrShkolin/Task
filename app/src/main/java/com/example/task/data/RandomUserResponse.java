package com.example.task.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RandomUserResponse{

	@SerializedName("results")
	private List<ResultsItem> results;

	@SerializedName("info")
	private Info info;

	public List<ResultsItem> getResults(){
		return results;
	}

	public Info getInfo(){
		return info;
	}
}