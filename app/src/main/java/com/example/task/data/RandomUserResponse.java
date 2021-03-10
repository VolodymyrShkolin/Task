package com.example.task.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RandomUserResponse{

	@SerializedName("results")
	private List<ResultsItem> results;

	public List<ResultsItem> getResults(){
		return results;
	}
}