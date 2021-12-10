package com.cyrleb.sudoku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cyrleb.sudoku.databinding.ActivityMainBinding;
import com.cyrleb.sudoku.databinding.ActivityPageJeuBinding;

public class PageJeu extends AppCompatActivity implements SelectedNumber{

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
        nAdapter = new AdapterNumbers(this);
        mBinding.numbers.setLayoutManager(new GridLayoutManager(this, 10));
        mBinding.numbers.setAdapter(nAdapter);
        nAdapter.FillArray();

        // GRID
        gAdapter = new AdapterGrille();
        mBinding.grille.setLayoutManager(new GridLayoutManager(this, 3));
        mBinding.grille.setAdapter(gAdapter);
        gAdapter.FillArray();

        setFragment();
        setContentView(v);
    }

    /**
     * permet d'ajouter le fragment PlayerInfo
     */
    public void setFragment(){
        mBinding.infoJoueur.removeAllViews();
        Fragment fragment = new PlayerInfoFragment();
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction.add(mBinding.infoJoueur.getId(), fragment);
        fragmentTransaction.commitAllowingStateLoss();
    }


    /**
     * permet de faire passer l'information du changement de numéro à la grille
     * @param value
     */
    @Override
    public void setNumber(String value) {
        Log.wtf("wtf", "from PageJeu\t" + value);
        gAdapter.setNumber(value);
    }
}