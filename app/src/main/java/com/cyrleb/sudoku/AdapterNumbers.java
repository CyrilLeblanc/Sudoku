package com.cyrleb.sudoku;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.cyrleb.sudoku.databinding.ItemNumberBinding;

import java.util.ArrayList;
import java.util.List;

public class AdapterNumbers extends RecyclerView.Adapter {

    private List<String> num = new ArrayList<>();
    private List<Button> numberButtons = new ArrayList<Button>();

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
                numberButtons.add(mBinding.button);     // on stocke chaque bouton dans une List

                mBinding.button.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("ResourceAsColor")
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onClick(View v) {
                        Singleton.getInstance().setSelectedNumber(item);        // le numéro sélectionné est celui sur lequel on a cliqué
                        numberButtons.forEach((Button button) -> {  // on passe sur chaque bouton dans la List
                            if (button != mBinding.button){         // si ce n'est pas celui sur lequel on a cliqué
                                button.setBackgroundColor(v.getResources().getColor(R.color.orange));   // on remet la couleur par défaut
                            }
                        });
                        mBinding.button.setBackgroundColor(v.getResources().getColor(R.color.orange_dark)); // on met la couleur d'un click
                    }
                });
            }
        }
    }
}
