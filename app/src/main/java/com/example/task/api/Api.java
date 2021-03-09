package com.example.task.api;

import com.example.task.data.RandomUserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL = "https://randomuser.me/";

    @GET("api/?results=20")
    Call<RandomUserResponse> getWeatherForecastResult();
}
