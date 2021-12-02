package com.cyrleb.sudoku;


import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.cyrleb.sudoku.databinding.ItemGrilleBinding;
import com.cyrleb.sudoku.databinding.ItemNumberBinding;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class AdapterGrille extends RecyclerView.Adapter {

    private List<String> num = new ArrayList<>();

    public void FillArray() {
        this.num.add("1");
        this.num.add("2");
        this.num.add("3");
        this.num.add("4");
        this.num.add("5");
        this.num.add("6");
        this.num.add("7");
        this.num.add("8");
        this.num.add("9");
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemGrilleBinding binding = ItemGrilleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new AdapterGrille.ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ItemViewHolder)holder).bindTo(num.get(position), position);
    }

    @Override
    public int getItemCount() {
        return num.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        public ItemGrilleBinding mBinding;

        ItemViewHolder(ItemGrilleBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        void bindTo(final String item, int position) {
            if (item != null) {
                androidx.appcompat.widget.AppCompatButton[] cases = {mBinding.case1, mBinding.case2, mBinding.case3, mBinding.case4, mBinding.case5, mBinding.case6, mBinding.case7, mBinding.case8, mBinding.case9};
                for (int i = 0; i < cases.length; i++) {
                    int finalI = i;
                    Case c = Singleton.getInstance().getGrille().getSection(position % 3, position / 3).getCase(finalI % 3, finalI / 3);
                    if (c.getModifiable()){
                        cases[i].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //Log.wtf("wtf", position + "/" + finalI);
                                String value = Singleton.getInstance().getSelectedNumber();
                                if (value == "X") { value = ""; }
                                cases[finalI].setText(value);
                                c.setValue(value);
                                Singleton.getInstance().controlFinishedGame();
                            }
                        });
                    } else {
                        cases[finalI].setTextColor(Color.GRAY);
                    }
                    cases[i].setText(c.getValue());
                }
            }
        }
    }
}

