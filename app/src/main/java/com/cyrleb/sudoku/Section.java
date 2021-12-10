package com.cyrleb.sudoku;

import android.util.Log;

import java.util.Arrays;
import java.util.List;

/**
 * Une Section est une série de 9 Case. (La grille est constituée de 9 Sections)
 */
public class Section {
    private Case[][] section;

    public Section(Case[][] section){
        this.section = section;
    }

    // modifie la valeur d'une case en fonction de ces coordonées dans la section courrante.
    public void setCase(String value, int row, int col){
        this.section[row][col].setValue(value);
    }

    // permet de retourner une case dans la section
    public Case getCase(int x, int y){
        return this.section[x][y];
    }

    //renvoie true seulement s'il n'y a pas de numéro en double dans la section
    public boolean withoutDuplicate(){
        int[][] coord = {{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
        for(int i = 0; i <= 7; i++){
            int Row = coord[i][0];
            int Col = coord[i][1];
            String value = section[Row][Col].getValue();
            if (value != ""){
                for(int j = i+1; j <= 8; j++){
                    if (value == section[coord[j][0]][coord[j][1]].getValue()){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //renvoie true si la section est complète et juste par rapport à elle-même seulement (pas par rapport au reste de la grille)
    public boolean finishSection(){
        if (!this.withoutDuplicate()){
            return false;
        }
        for(int i = 0; i <= 2; i++){
            for(int j = 0; j <= 2; j++){
                if (section[i][j].getValue() == ""){
                    return false;
                }
            }
        }
        return true;
    }

    // renvoie la ligne demandée
    public String[] getRow(int row){
        String[] tab = new String[3];
        tab[0] = section[row][0].getValue();
        tab[1] = section[row][1].getValue();
        tab[2] = section[row][2].getValue();
        return tab;
    }

    // renvoie la colonne demandée
    public String[] getCol(int col){
        String[] tab = new String[3];
        tab[0] = section[0][col].getValue();
        tab[1] = section[1][col].getValue();
        tab[2] = section[2][col].getValue();
        return tab;
    }

    public String toString(){
        String str = "";
        for(int i = 0; i <= 2; i++){
            for(int j = 0; j <= 2; j++){
                str += section[i][j].toString();
            }
            str += "\n";
        }
        return str;
    }

    public boolean isRempli(){
        boolean value = true;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if (section[j][i].getValue() == ""){
                    value = false;
                }
            }
        }
        return value;
    }
}
