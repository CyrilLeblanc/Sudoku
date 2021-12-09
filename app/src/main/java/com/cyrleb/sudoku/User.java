package com.cyrleb.sudoku;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

/**
 * User permet de stoquer les informations du joueur
 */
public class User {
    private String name;
    private Bitmap avatar;

    User(String name, Bitmap avatar){
        this.name = name;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public Bitmap getAvatar() {
        return avatar;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAvatar(Bitmap avatar) {
        this.avatar = avatar;
    }

    public String toString(){
        return name + "\t" + this.avatar.toString();
    }
}
