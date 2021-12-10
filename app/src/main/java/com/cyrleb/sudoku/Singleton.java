package com.cyrleb.sudoku;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.Button;

import com.cyrleb.sudoku.databinding.ActivityPageJeuBinding;
import com.cyrleb.sudoku.databinding.ItemNumberBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Singleton {
   private static Singleton instance = new Singleton();
   private String selectedNumber;       // permet durant la partie de stocker le numéro sélectionné par le joueur
   private String difficulty;           // permet de connaitre la difficulté choisie par le joueur
   private Grille grille;
   private ActivityPageJeuBinding mBinding;    // permet d'intéragir avec les éléments de l'activité ActivityPageJeu
   private long startedGameAt;                 // permet de connaitre le timestamp du début de partie
   private User user;

   public Singleton(){
       this.selectedNumber = "";
       this.user = new User("Player1", null);
   }

   static Singleton getInstance(){
       return instance;
   }

   public User getUser(){
       return this.user;
   }

   public void setUserImage(Bitmap bitmap){
       this.user.setAvatar(bitmap);
   }

   public void setUserName(String name){
       this.user.setName(name);
   }

   public String getSelectedNumber() {
       return selectedNumber;
   }

   public void setSelectedNumber(String selectedNumber) {
       this.selectedNumber = selectedNumber;
   }

   public void setDifficulty(String difficulty) {
       this.difficulty = difficulty;
       this.setGrille();
       startedGameAt = Calendar.getInstance().getTimeInMillis();
   }

   // set in instance the mBinding for PageJeu
   public void bindingPageJeu(ActivityPageJeuBinding mBinding){
       this.mBinding = mBinding;
   }

   public void controlFinishedGame(Context context){
       if (grille.isTermine()){
           Date date  = new Date(Calendar.getInstance().getTimeInMillis()-this.startedGameAt-3600*1000);
           String str = " " + new SimpleDateFormat("mm").format(date) + "m " + new SimpleDateFormat("ss").format(date) + "s";
           mBinding.finishLabel.setText(context.getResources().getString(R.string.congrats) + " " + user.getName() + context.getResources().getString(R.string.congrats2) + str);
       } else if (grille.isRempli()){
           mBinding.finishLabel.setText(context.getResources().getString(R.string.notFinished));
       } else {
           mBinding.finishLabel.setText("");
       }
   }

   public Grille getGrille() {
       return grille;
   }

   // génération de la grille en fonction du niveau de difficulté choisi par le joueur
   private void setGrille() {
       Case[][] cases11 = {{}};
       Case[][] cases12 = {{}};
       Case[][] cases13 = {{}};
       Case[][] cases21 = {{}};
       Case[][] cases22 = {{}};
       Case[][] cases23 = {{}};
       Case[][] cases31 = {{}};
       Case[][] cases32 = {{}};
       Case[][] cases33 = {{}};
       switch(this.difficulty){
           case "facile":
               cases11 = new Case[][]{
                       {new Case(), new Case(), new Case("7")},
                       {new Case("6"), new Case(), new Case("3")},
                       {new Case(), new Case("1"), new Case()}};

               cases12 = new Case[][]{
                       {new Case("4"), new Case(), new Case()},
                       {new Case("9"), new Case("2"), new Case()},
                       {new Case("5"), new Case(), new Case("8")}};

               cases13 = new Case[][]{
                       {new Case(), new Case("3"), new Case()},
                       {new Case(), new Case("1"), new Case()},
                       {new Case("7"), new Case(), new Case("4")}};
               // -----
               cases21 = new Case[][]{
                       {new Case("8"), new Case(), new Case()},
                       {new Case("2"), new Case("3"), new Case()},
                       {new Case("1"), new Case(), new Case()}};

               cases22 = new Case[][]{
                       {new Case(), new Case(), new Case("4")},
                       {new Case(), new Case(), new Case()},
                       {new Case("6"), new Case(), new Case()}};

               cases23 = new Case[][]{
                       {new Case(), new Case(), new Case("1")},
                       {new Case(), new Case("7"), new Case("5")},
                       {new Case(), new Case(), new Case("3")}};
               // ----
               cases31 = new Case[][]{
                       {new Case("7"), new Case("6"), new Case()},
                       {new Case(), new Case("2"), new Case()},
                       {new Case(), new Case("9"), new Case()}};

               cases32 = new Case[][]{
                       {new Case("1"), new Case(), new Case("3")},
                       {new Case(), new Case("4"), new Case("9")},
                       {new Case(), new Case(), new Case("5")}};

               cases33 = new Case[][]{
                       {new Case(), new Case("9"), new Case()},
                       {new Case("1"), new Case(), new Case("6")},
                       {new Case("3"), new Case(), new Case()}};
               break;
           case "moyen":
               cases11 = new Case[][]{
                       {new Case(), new Case(), new Case("8")},
                       {new Case(), new Case(), new Case()},
                       {new Case(), new Case(), new Case()}};

               cases12 = new Case[][]{
                       {new Case(), new Case("5"), new Case()},
                       {new Case("4"), new Case("8"), new Case("3")},
                       {new Case("6"), new Case(), new Case()}};

               cases13 = new Case[][]{
                       {new Case(), new Case("9"), new Case()},
                       {new Case(), new Case("2"), new Case("7")},
                       {new Case("5"), new Case("3"), new Case()}};
               // -----
               cases21 = new Case[][]{
                       {new Case("3"), new Case("8"), new Case()},
                       {new Case("6"), new Case(), new Case()},
                       {new Case("2"), new Case("1"), new Case()}};

               cases22 = new Case[][]{
                       {new Case(), new Case("1"), new Case()},
                       {new Case("7"), new Case(), new Case("4")},
                       {new Case(), new Case("6"), new Case()}};

               cases23 = new Case[][]{
                       {new Case(), new Case("7"), new Case("6")},
                       {new Case(), new Case(), new Case("1")},
                       {new Case(), new Case("4"), new Case("5")}};
               // ----
               cases31 = new Case[][]{
                       {new Case(), new Case("7"), new Case("3")},
                       {new Case("8"), new Case("5"), new Case()},
                       {new Case(), new Case("2"), new Case()}};

               cases32 = new Case[][]{
                       {new Case(), new Case(), new Case("1")},
                       {new Case("3"), new Case("9"), new Case("7")},
                       {new Case(), new Case("4"), new Case()}};

               cases33 = new Case[][]{
                       {new Case(), new Case(), new Case()},
                       {new Case(), new Case(), new Case()},
                       {new Case("7"), new Case(), new Case()}};
               break;
           case "difficile":
               cases11 = new Case[][]{
                       {new Case("3"), new Case(), new Case()},
                       {new Case(), new Case("7"), new Case()},
                       {new Case(), new Case(), new Case()}};

               cases12 = new Case[][]{
                       {new Case("8"), new Case(), new Case("5")},
                       {new Case(), new Case("2"), new Case("3")},
                       {new Case(), new Case("7"), new Case()}};

               cases13 = new Case[][]{
                       {new Case(), new Case(), new Case("2")},
                       {new Case(), new Case(), new Case()},
                       {new Case(), new Case(), new Case("3")}};
               // -----
               cases21 = new Case[][]{
                       {new Case(), new Case(), new Case("9")},
                       {new Case(), new Case(), new Case("2")},
                       {new Case(), new Case("1"), new Case("6")}};

               cases22 = new Case[][]{
                       {new Case("7"), new Case(), new Case()},
                       {new Case(), new Case(), new Case()},
                       {new Case(), new Case(), new Case("2")}};

               cases23 = new Case[][]{
                       {new Case("5"), new Case("2"), new Case()},
                       {new Case("8"), new Case(), new Case()},
                       {new Case("3"), new Case(), new Case()}};
               // ----
               cases31 = new Case[][]{
                       {new Case("6"), new Case(), new Case()},
                       {new Case(), new Case(), new Case()},
                       {new Case("9"), new Case(), new Case()}};

               cases32 = new Case[][]{
                       {new Case(), new Case("4"), new Case()},
                       {new Case("2"), new Case("9"), new Case()},
                       {new Case("5"), new Case(), new Case("1")}};

               cases33 = new Case[][]{
                       {new Case(), new Case(), new Case()},
                       {new Case(), new Case("4"), new Case()},
                       {new Case(), new Case(), new Case("6")}};
               break;

       }
       Section[][] temp = new Section[][]{{new Section(cases11), new Section(cases12), new Section(cases13)},
               {new Section(cases21), new Section(cases22), new Section(cases23)},
               {new Section(cases31), new Section(cases32), new Section(cases33)}};

       this.grille = new Grille(temp);
   }
}
