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
        View v = mBinding.getRoot();
        nAdapter = new AdapterNumbers();
        mBinding.numbers.setLayoutManager(new GridLayoutManager(this, 10));
        mBinding.numbers.setAdapter(nAdapter);
        nAdapter.FillArray();

        gAdapter = new AdapterGrille();
        mBinding.grille.setLayoutManager(new GridLayoutManager(this, 9));
        mBinding.grille.setAdapter(gAdapter);
        gAdapter.FillArray();

        // TEST
        Case[][] cases11 = {
                {new Case("5"), new Case("3"), new Case("9")},
                {new Case("7"), new Case("2"), new Case("8")},
                {new Case("6"), new Case("4"), new Case("1")}};

        Case[][] cases12 = {
                {new Case("8"), new Case("7"), new Case("6")},
                {new Case("3"), new Case("1"), new Case("4")},
                {new Case("2"), new Case("9"), new Case("5")}};

        Case[][] cases13 = {
                {new Case("4"), new Case("1"), new Case("2")},
                {new Case("9"), new Case("6"), new Case("5")},
                {new Case("7"), new Case("3"), new Case("8")}};
        // -----
        Case[][] cases21 = {
                {new Case("4"), new Case("6"), new Case("2")},
                {new Case("3"), new Case("8"), new Case("5")},
                {new Case("1"), new Case("9"), new Case("7")}};

        Case[][] cases22 = {
                {new Case("5"), new Case("3"), new Case("9")},
                {new Case("7"), new Case("2"), new Case("1")},
                {new Case("4"), new Case("6"), new Case("8")}};

        Case[][] cases23 = {
                {new Case("8"), new Case("7"), new Case("1")},
                {new Case("6"), new Case("4"), new Case("9")},
                {new Case("2"), new Case("5"), new Case("3")}};
        // ----
        Case[][] cases31 = {
                {new Case("2"), new Case("5"), new Case("6")},
                {new Case("9"), new Case("1"), new Case("3")},
                {new Case("8"), new Case("7"), new Case("4")}};

        Case[][] cases32 = {
                {new Case("1"), new Case("8"), new Case("7")},
                {new Case("6"), new Case("4"), new Case("2")},
                {new Case("9"), new Case("5"), new Case("3")}};

        Case[][] cases33 = {
                {new Case("3"), new Case("9"), new Case("4")},
                {new Case("5"), new Case("8"), new Case("7")},
                {new Case("1"), new Case("2"), new Case("6")}};


        Section[][] temp = {{new Section(cases11), new Section(cases12), new Section(cases13)},
            {new Section(cases21),new Section(cases22),new Section(cases23)},
            {new Section(cases31),new Section(cases32),new Section(cases33)}};

        Grille grille = new Grille(temp);

        Log.wtf("wtf", grille.isTermine() + "");

        // TEST

        setContentView(v);
    }
}