package com.cyrleb.sudoku;

import android.util.Log;

import java.util.List;

public class Grille {

    private Section[][] grille;

    public Grille(Section[][] grille){
        this.grille = grille;
    }


    public boolean withoutDuplicateInRow(int row){
        // récupérer les 3 sections
        Section[] sections = new Section[3];
        sections[0] = grille[row/3][0];
        sections[1] = grille[row/3][1];
        sections[2] = grille[row/3][2];

        // récupérer les row des sections
        String[] cases = new String[9];
        for (int i = 0; i < cases.length ; i++){

            cases[i] = sections[i/3].getRow(row%3)[i%3];
        }

        // vérifier les dupliqués
        for(int i = 0; i <= 7; i++){
            if (cases[i] != ""){
                for(int j = i+1; j <= 8; j++){
                    if (cases[i] == cases[j]){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean withoutDuplicateInCol(int col){
        // récupérer les 3 sections
        Section[] sections = new Section[3];
        sections[0] = grille[0][col/3];
        sections[1] = grille[1][col/3];
        sections[2] = grille[2][col/3];

        // récupérer les col des sections
        String[] cases = new String[9];
        for (int i = 0; i < cases.length ; i++){

            cases[i] = sections[i/3].getCol(col%3)[i%3];
        }

        // vérifier les dupliqués
        for(int i = 0; i <= 7; i++){
            if (cases[i] != ""){
                for(int j = i+1; j <= 8; j++){
                    if (cases[i] == cases[j]){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean isTermine(){
        // pour chaque sections
        for(int i = 0; i <= 2; i++){
            for(int j= 0; j <= 2; j++){
                if (!grille[i][j].finishSection()){
                    return false;
                }
            }
        }
        // pour chaque lignes et colonnes
        for(int i = 0; i <= 8; i++){
            if (!this.withoutDuplicateInCol(i) || !this.withoutDuplicateInRow(i)){
                return false;
            }
        }

        return true;
    }

    public String toString(){
        String str = "";
        for(int i = 0; i <= 2; i++){
            for(int j = 0; j <= 2; j++){
                str += grille[i][j].toString();
            }
        }
        return str;
    }

}
