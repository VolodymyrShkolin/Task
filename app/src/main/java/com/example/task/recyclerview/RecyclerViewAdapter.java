package com.example.task.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task.InfoActivity;
import com.example.task.data.ResultsItem;
import com.example.task.databinding.RandomPersonLayoutBinding;
import com.example.task.user.User;

import org.parceler.Parcels;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<ResultsItem> list_;
    Context context;

    public RecyclerViewAdapter(List<ResultsItem> list_, Context context)
    {
        this.list_ = list_;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RandomPersonLayoutBinding randomPersonLayoutBinding = RandomPersonLayoutBinding
                .inflate(layoutInflater, parent, false);
        return new ViewHolder(randomPersonLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ResultsItem user = list_.get(position);
        holder.mRandomPersonLayoutBinding.setUserRI(user);

        String photo = list_.get(position).getPicture().getLarge();
        String firstName = String.format("First name: %s", list_.get(position).getName().getFirst());
        String lastName = String.format("Last name: %s", list_.get(position).getName().getLast());
        String date = String.format("Date: %s", User.date(list_.get(position).getDob().getDate()));
        String age = String.format("Age: %s", list_.get(position).getDob().getAge());
        String city = String.format("City: %s", list_.get(position).getLocation().getCity());
        User parcUser = new User(photo,firstName, lastName, date, age, city);
        Parcelable parcelable =  Parcels.wrap(parcUser);

        holder.mRandomPersonLayoutBinding.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), InfoActivity.class);
                intent.putExtra("DATA_KEY", parcelable);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RandomPersonLayoutBinding mRandomPersonLayoutBinding;

        public ViewHolder(@NonNull RandomPersonLayoutBinding randomPersonLayoutBinding) {
            super(randomPersonLayoutBinding.getRoot());
            this.mRandomPersonLayoutBinding = randomPersonLayoutBinding;

        }
    }
}
