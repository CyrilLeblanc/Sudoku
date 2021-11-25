package com.cyrleb.sudoku;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cyrleb.sudoku.databinding.ItemNumberBinding;

import java.util.ArrayList;
import java.util.List;

public class AdapterNumbers extends RecyclerView.Adapter {

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
        this.num.add("X");
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNumberBinding binding = ItemNumberBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new AdapterNumbers.ItemViewHolder(binding);
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
        public ItemNumberBinding mBinding;

        ItemViewHolder(ItemNumberBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }
        void bindTo(final String item, int position) {
            if (item != null) {
                mBinding.button.setText(item);
            }
        }
    }
}
