package com.example.task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.task.api.Api;
import com.example.task.api.Request;
import com.example.task.data.RandomUserResponse;
import com.example.task.recyclerview.RecyclerViewAdapter;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView usersRV;
    GridLayoutManager gridLayoutManager;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usersRV = findViewById(R.id.recyclerview);
        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        usersRV.setLayoutManager(gridLayoutManager);
        startRequest();
    }

    private void startRequest() {
        Api api = new Request().buildRetrofitConfig();
        Call<RandomUserResponse> call = api.getWeatherForecastResult
                (Api.cnt);

        call.enqueue(new Callback<RandomUserResponse>() {
            @Override
            public void onResponse(@NotNull Call<RandomUserResponse> call,
                                   @NotNull Response<RandomUserResponse> response) {
                if(response.isSuccessful()) {
                    adapter = new RecyclerViewAdapter(response.body().getResults(), getApplicationContext());
                    usersRV.setAdapter(adapter);
                }else {
                    Toast.makeText(getApplicationContext(), "Sorry, we did't find nobody(",
                            Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<RandomUserResponse> call, Throwable t) {
            }
        });
    }
}