package com.cyrleb.sudoku;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cyrleb.sudoku.databinding.FragmentPlayerInfoBinding;

public class PlayerInfoFragment extends Fragment {
    private FragmentPlayerInfoBinding mBinding;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentPlayerInfoBinding.inflate(inflater);
        View v = mBinding.getRoot();

        mBinding.username.setText(Singleton.getInstance().getUser().getName());
        mBinding.avatar.setImageBitmap(Singleton.getInstance().getUser().getAvatar());

        mBinding.fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), SettingsMenu.class);
                startActivity(intent);
            }
        });

        return v ;
    }

    @Override
    public void onResume() {
        super.onResume();
        mBinding.username.setText(Singleton.getInstance().getUser().getName());
        mBinding.avatar.setImageBitmap(Singleton.getInstance().getUser().getAvatar());
    }
}