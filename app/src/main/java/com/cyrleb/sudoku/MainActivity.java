package com.cyrleb.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cyrleb.sudoku.databinding.ActivityMainBinding;
import com.cyrleb.sudoku.databinding.ActivityPageJeuBinding;

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
                startGame("facile");
                Singleton.getInstance().setDifficulty("facile");
            }
        });

        // MOYEN
        mBinding.moyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame("moyen");
                Singleton.getInstance().setDifficulty("moyen");
            }
        });

        // DIFICILE
        mBinding.difficile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame("difficile");
                Singleton.getInstance().setDifficulty("difficile");
            }
        });

        setContentView(v);
    }

    public void startGame(String difficulty){
        Intent intent = new Intent(getApplicationContext(), PageJeu.class);
        startActivity(intent);
    }

}