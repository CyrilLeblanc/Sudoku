package com.cyrleb.sudoku;

import androidx.annotation.NonNull;
import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;
import com.cyrleb.sudoku.databinding.ItemGrilleBinding;

/**
 * RecyclerView affichant les 9 sections de la grille
 */
public class AdapterGrille extends RecyclerView.Adapter {

    private final List<String> num = new ArrayList<>();
    public String selectedNumber = "";

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

    public void setNumber(String value) {
        this.selectedNumber = value;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        public ItemGrilleBinding mBinding;

        ItemViewHolder(ItemGrilleBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        /**
         * ajoute la gestion du click sur chaque case de la grille
         * @param item String
         * @param position  int
         */
        @SuppressLint("ResourceAsColor")
        void bindTo(final String item, int position) {
            if (item != null) {
                // on stocke toutes les cases dans un tableau pour agir sur chacune sans duplication de code
                androidx.appcompat.widget.AppCompatButton[] cases = {mBinding.case1, mBinding.case2, mBinding.case3, mBinding.case4, mBinding.case5, mBinding.case6, mBinding.case7, mBinding.case8, mBinding.case9};

                for (int i = 0; i < cases.length; i++) {
                    int finalI = i;

                    // on récupère la case de la classe Case correspondant à la case
                    Case c = Singleton.getInstance().getGrille().getSection(position % 3, position / 3).getCase(finalI % 3, finalI / 3);

                    if (c.getModifiable()){         // si la case est modifiable
                        cases[i].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {       // quand on clique
                                //String value = Singleton.getInstance().getSelectedNumber();
                                String value = selectedNumber;      // on récupère la valeur du bouton depuis l'interface
                                if (value.equals("X")) { value = ""; }
                                cases[finalI].setText(value);
                                c.setValue(value);
                                Singleton.getInstance().controlFinishedGame(v.getContext());    // on teste si la grille est bien remplie
                            }
                        });
                    } else { // si la case n'est pas modifiable on change la couleur du texte
                        cases[finalI].setTextColor(Color.GRAY);
                    }
                    cases[i].setText(c.getValue());     // on attribue la valeur de la case
                }
            }
        }
    }
}

