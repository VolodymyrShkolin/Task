package com.example.task;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task.databinding.FragmentInfoBinding;
import com.example.task.user.User;

import org.parceler.Parcels;

public class InfoFragment extends FragmentActivity {
    final String dataKey = "DATA_KEY";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentInfoBinding fragmentInfoBinding = DataBindingUtil
                .setContentView(this, R.layout.fragment_info);
        Parcelable parcelable = getIntent().getParcelableExtra(dataKey);
        User parcUser = Parcels.unwrap(parcelable);
        User user = new User(parcUser.getImageUrl(), parcUser.getFirstName(),
                parcUser.getLastName(), parcUser.getDate(),
                parcUser.getAge(), parcUser.getCity());
        fragmentInfoBinding.setUser(user);
    }
}