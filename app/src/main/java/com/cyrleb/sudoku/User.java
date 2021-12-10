package com.cyrleb.sudoku;
import android.graphics.Bitmap;

/**
 * User permet de stoquer les informations du joueur
 */
public class User {
    private String name;
    private Bitmap avatar;

    /**
     * Constructeur initialisant le name et l'avatar suivant les paramètre donnée
     * @param name String
     * @param avatar Bitmap
     */
    User(String name, Bitmap avatar){
        this.name = name;
        this.avatar = avatar;
    }

    /**
     * renvoie le name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * renvoie l'avatar
     * @return Bitmap
     */
    public Bitmap getAvatar() {
        return avatar;
    }

    /**
     * set le name
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set l'avatar
     * @param avatar Bitmap
     */
    public void setAvatar(Bitmap avatar) {
        this.avatar = avatar;
    }

    public String toString(){
        return name + "\t" + this.avatar.toString();
    }
}
