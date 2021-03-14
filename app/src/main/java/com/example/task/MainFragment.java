package com.example.task;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.task.api.Api;
import com.example.task.api.Request;
import com.example.task.data.RandomUserResponse;
import com.example.task.recyclerview.RecyclerViewAdapter;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {
    RecyclerView usersRV;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        recRequest(view);
        startRequest();
        return view;
    }

    private void recRequest(View view){
        usersRV = view.findViewById(R.id.recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 2);
        usersRV.setLayoutManager(gridLayoutManager);
        usersRV.setHasFixedSize(true);
    }

    private void startRequest() {
        Api api = new Request().buildRetrofitConfig();
        Call<RandomUserResponse> call = api.getWeatherForecastResult(Api.cnt);

        call.enqueue(new Callback<RandomUserResponse>() {
            @Override
            public void onResponse(@NotNull Call<RandomUserResponse> call,
                                   @NotNull Response<RandomUserResponse> response) {
                if(response.isSuccessful()) {
                    RecyclerViewAdapter adapter = new RecyclerViewAdapter(response.body().getResults(), getContext());
                    usersRV.setAdapter(adapter);
                }else {
                    Toast.makeText(getContext(), R.string.sorry,
                            Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<RandomUserResponse> call, Throwable t) {
            }
        });
    }
}