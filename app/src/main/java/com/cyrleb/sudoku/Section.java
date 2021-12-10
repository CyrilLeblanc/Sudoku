package com.cyrleb.sudoku;

/**
 * Une Section est une série de 9 Case. (La grille est constituée de 9 Sections)
 */
public class Section {
    private final Case[][] section;

    /**
     * Constructeur initialisant les Cases contenu dans la Section
     * @param section Case[][]
     */
    public Section(Case[][] section){
        this.section = section;
    }

    /**
     * permet de retourner une case dans la section
     * @param x int
     * @param y int
     * @return Case
     */
    public Case getCase(int x, int y){
        return this.section[x][y];
    }

    /**
     * renvoie true seulement s'il n'y a pas de numéro en double dans la section
     * @return boolean
     */
    private boolean withoutDuplicate(){
        int[][] coord = {{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
        for(int i = 0; i <= 7; i++){
            int Row = coord[i][0];
            int Col = coord[i][1];
            String value = section[Row][Col].getValue();
            if (!value.equals("")){
                for(int j = i+1; j <= 8; j++){
                    if (value == section[coord[j][0]][coord[j][1]].getValue()){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * renvoie true si la section est complète et juste par rapport à elle-même seulement (pas par rapport au reste de la grille)
     * @return boolean
     */
    public boolean finishSection(){
        if (!this.withoutDuplicate()){
            return false;
        }
        for(int i = 0; i <= 2; i++){
            for(int j = 0; j <= 2; j++){
                if (section[i][j].getValue().equals("")){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * renvoie la ligne demandée
     * @param row int
     * @return String
     */
    public String[] getRow(int row){
        String[] tab = new String[3];
        tab[0] = section[row][0].getValue();
        tab[1] = section[row][1].getValue();
        tab[2] = section[row][2].getValue();
        return tab;
    }

    /**
     * renvoie la colonne demandée
     * @param col int
     * @return String
     */
    public String[] getCol(int col){
        String[] tab = new String[3];
        tab[0] = section[0][col].getValue();
        tab[1] = section[1][col].getValue();
        tab[2] = section[2][col].getValue();
        return tab;
    }

    /**
     * Renvoi un boolean true si toute les cases sont remplie
     * @return boolean
     */
    public boolean isRemplie(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if (section[j][i].getValue().equals("")){
                    return false;
                }
            }
        }
        return true;
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
}
