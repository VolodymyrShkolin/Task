package com.example.task.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.task.InfoActivity;
import com.example.task.R;
import com.example.task.data.ResultsItem;

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

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.random_person_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context).load(list_.get(position).getPicture().getLarge()).into(holder.photo);

        holder.name.setText(String.format(list_.get(position).getName().getFirst()));

        String firstName = String.format("First name: %s", list_.get(position).getName().getFirst());
        String lastName = String.format("Last name: %s", list_.get(position).getName().getLast());
        String date = String.format("Date: %s", date(list_.get(position).getDob().getDate()));
        String age = String.format("Age: %s", list_.get(position).getDob().getAge());
        String city = String.format("City: %s", list_.get(position).getLocation().getCity());


        holder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), InfoActivity.class);
                intent.putExtra("photo", list_.get(position).getPicture().getLarge());
                intent.putExtra("firstName", firstName);
                intent.putExtra("lastName", lastName);
                intent.putExtra("date", date);
                intent.putExtra("age", age);
                intent.putExtra("city", city);
                v.getContext().startActivity(intent);
            }

        });
    }

    @Override
    public int getItemCount() {
        return list_.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView photo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            photo = itemView.findViewById(R.id.photo);

        }
    }

    private String date(String dateInfo){
        String[] info = dateInfo.split(":");
        String result = info[0].substring(0,10);
        return result;
    }
}
