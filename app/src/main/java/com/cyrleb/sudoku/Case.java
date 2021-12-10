package com.cyrleb.sudoku;

/**
 * Le plus petit élément de la grille contient un numéro ou du vide.
 */
public class Case {

    private String value;
    private final boolean modifiable;     // si la case n'est pas modifiable alors elle fait partie des numéros données au début du jeu

    /**
     * Constructeur permettant de préciser la valeur non modifiable
     * @param value String
     */
    public Case(String value){
        this.value = value;
        modifiable = false;
    }

    /**
     * Constructeur d'une case vide modifiable par la suite par le joueur
     */
    public Case(){
        this.modifiable = true;
        this.value = "";
    }

    /**
     * Renvoi la valeur de la case courrante
     * @return String
     */
    public String getValue(){
        return this.value;
    }

    /**
     * permet de changer la valeur de la case si c'est possible
     * @param value String
     */
    public void setValue(String value){
        if (this.modifiable){
            this.value = value;
        }
    }

    /**
     * permet de savoir si la case est modifiable par le joueur
     * @return boolean
     */
    public boolean getModifiable(){
        return this.modifiable;
    }

    public String toString(){
        return this.value;
    }
}
