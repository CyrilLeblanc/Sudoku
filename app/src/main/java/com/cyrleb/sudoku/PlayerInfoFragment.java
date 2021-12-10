package com.cyrleb.sudoku;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cyrleb.sudoku.databinding.FragmentPlayerInfoBinding;

public class PlayerInfoFragment extends Fragment {
    private FragmentPlayerInfoBinding mBinding;

    /**
     * Met à jour les informations contenu dans la page courrante
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentPlayerInfoBinding.inflate(inflater);
        View v = mBinding.getRoot();

        // on affiche l'avatar et le nom du joueur
        mBinding.username.setText(Singleton.getInstance().getUser().getName());
        mBinding.avatar.setImageBitmap(Singleton.getInstance().getUser().getAvatar());

        // quand on clique sur le fragment alors on va sur l'activité SettingsMenu
        mBinding.fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), SettingsMenu.class);
                startActivity(intent);
            }
        });

        return v ;
    }


    /**
     * on met à jour l'avatar et le nom du joueur quand on retourne sur la page courrante
     */
    @SuppressLint("ResourceAsColor")
    @Override
    public void onResume() {
        super.onResume();
        mBinding.username.setText(Singleton.getInstance().getUser().getName());
        mBinding.avatar.setImageBitmap(Singleton.getInstance().getUser().getAvatar());
    }
}