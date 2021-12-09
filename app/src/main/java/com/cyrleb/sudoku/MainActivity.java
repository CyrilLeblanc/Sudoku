package com.cyrleb.sudoku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cyrleb.sudoku.databinding.ActivityMainBinding;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View v = mBinding.getRoot();
        // FACILE
        mBinding.facile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setDifficulty("facile");
                startGame();
            }
        });

        // MOYEN
        mBinding.moyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setDifficulty("moyen");
                startGame();
            }
        });

        // DIFFICILE
        mBinding.difficile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setDifficulty("difficile");
                startGame();
            }
        });

        setFragment();
        setContentView(v);
    }

    // permet de commencer le jeu en allant à l'activité PageJeu
    public void startGame(){
        Intent intent = new Intent(getApplicationContext(), PageJeu.class);
        startActivity(intent);
    }

    public void setFragment(){
        mBinding.infoJoueur.removeAllViews();
        Fragment fragment = new PlayerInfoFragment();
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction.add(mBinding.infoJoueur.getId(), fragment);
        fragmentTransaction.commitAllowingStateLoss();
    }
}