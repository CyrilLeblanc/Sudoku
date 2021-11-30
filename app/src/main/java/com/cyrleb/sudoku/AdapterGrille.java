package com.cyrleb.sudoku;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.cyrleb.sudoku.databinding.ItemGrilleBinding;
import com.cyrleb.sudoku.databinding.ItemNumberBinding;

import java.util.ArrayList;
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
                    cases[i].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.wtf("wtf", position + "/" + finalI);
                        }
                    });
                }
            }
        }
    }
}

