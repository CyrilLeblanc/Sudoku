package com.cyrleb.sudoku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cyrleb.sudoku.databinding.ActivityMainBinding;
import com.cyrleb.sudoku.databinding.ActivityPageJeuBinding;

public class PageJeu extends AppCompatActivity {

    private ActivityPageJeuBinding mBinding;
    private AdapterNumbers nAdapter;
    private AdapterGrille gAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityPageJeuBinding.inflate(getLayoutInflater());
        Singleton.getInstance().bindingPageJeu(mBinding);
        View v = mBinding.getRoot();

        // NUMBER INPUT
        nAdapter = new AdapterNumbers();
        mBinding.numbers.setLayoutManager(new GridLayoutManager(this, 10));
        mBinding.numbers.setAdapter(nAdapter);
        nAdapter.FillArray();

        // GRID
        gAdapter = new AdapterGrille();
        mBinding.grille.setLayoutManager(new GridLayoutManager(this, 3));
        mBinding.grille.setAdapter(gAdapter);
        gAdapter.FillArray();

        setContentView(v);
    }
}