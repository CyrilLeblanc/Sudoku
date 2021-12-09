package com.cyrleb.sudoku;

import android.util.Log;

import java.util.List;

public class Grille {

    private Section[][] grille;
    public Grille(Section[][] grille){
        this.grille = grille;
    }

    // permet de savoir si il y a des duplications de numéro dans la ligne donnée
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

    // permet de savoir si il y a des duplications de numéro dans la colonne donnée
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

        // vérifié les dupliqués
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

    // permet de savoir si la grille est remplie et correcte
    public boolean isTermine(){
        // pour chaque section
        for(int i = 0; i <= 2; i++){
            for(int j= 0; j <= 2; j++){
                if (!grille[i][j].finishSection()){
                    return false;
                }
            }
        }
        // pour chaque ligne et colonne
        for(int i = 0; i <= 8; i++){
            if (!this.withoutDuplicateInCol(i) || !this.withoutDuplicateInRow(i)){
                return false;
            }
        }

        return true;
    }

    // permet d'avoir une section en fonction des coordonnées
    public Section getSection(int x, int y){
        return this.grille[x][y];
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
