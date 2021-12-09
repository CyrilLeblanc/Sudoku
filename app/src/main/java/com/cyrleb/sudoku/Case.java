package com.cyrleb.sudoku;

/**
 * Le plus petit élément de la grille contient un numéro ou du vide.
 */
public class Case {

    private String value;
    private boolean modifiable;     // si la case n'est pas modifiable alors elle fait partie des numéros données au début du jeu

    public Case(String value){
        this.value = value;
        modifiable = false;
    }

    public Case(){
        this.modifiable = true;
        this.value = "";
    }

    public String getValue(){
        return this.value;
    }

    // permet de changer la valeur de la case si c'est possible
    public void setValue(String value){
        if (this.modifiable){
            this.value = value;
        }
    }

    // permet de savoir si la case est modifiable par le joueur
    public boolean getModifiable(){
        return this.modifiable;
    }

    public String toString(){
        return this.value;
    }
}
