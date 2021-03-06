package com.cyrleb.sudoku;

import android.content.Context;
import android.graphics.Bitmap;

import com.cyrleb.sudoku.databinding.ActivityPageJeuBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Singleton accessible partout dans l'application
 */
public class Singleton {
   private final static Singleton instance = new Singleton();
   private String difficulty;                   // permet de connaitre la difficulté choisie par le joueur
   private Grille grille;
   private ActivityPageJeuBinding mBinding;     // permet d'intéragir avec les éléments de l'activité ActivityPageJeu
   private long startedGameAt;                  // permet de connaitre le timestamp du début de partie
   private final User user = new User("Player1", null);

    /**
     * Renvoi le Singleton
     * @return Singleton
     */
   static Singleton getInstance(){
       return instance;
   }

    /**
     * Renvoi le User
     * @return User
     */
   public User getUser(){
       return this.user;
   }

   /**
     * permet de mettre en place le bitmap de User
     * @param bitmap Bitmap
     */
   public void setUserImage(Bitmap bitmap){
       this.user.setAvatar(bitmap);
   }

    /**
     * permet de changer le username du user
     * @param name String
     */
   public void setUserName(String name){
       this.user.setName(name);
   }

    /**
     * permet de changer la difficulté de la grille
     * @param difficulty String
     */
   public void setDifficulty(String difficulty) {
       this.difficulty = difficulty;
       this.setGrille();
       startedGameAt = Calendar.getInstance().getTimeInMillis();
   }

    /**
     * Permet de récupérer le mBinding de la page jeu
     * @param mBinding ActivityPageJeuBinding
     */
   public void bindingPageJeu(ActivityPageJeuBinding mBinding){
       this.mBinding = mBinding;
   }

    /**
     * Teste si la partie est terminé
     * @param context Context
     */
   public void controlFinishedGame(Context context){
       if (grille.isTermine()){
           Date date  = new Date(Calendar.getInstance().getTimeInMillis()-this.startedGameAt-3600*1000);
           String str = " " + new SimpleDateFormat("mm").format(date) + "m " + new SimpleDateFormat("ss").format(date) + "s";
           mBinding.finishLabel.setText(context.getResources().getString(R.string.congrats) + " " + user.getName() + context.getResources().getString(R.string.congrats2) + str);
       } else if (grille.isRemplie()){
           mBinding.finishLabel.setText(context.getResources().getString(R.string.notFinished));
       } else {
           mBinding.finishLabel.setText("");
       }
   }

    /**
     * renvoie la grille
     * @return Grille
     */
   public Grille getGrille() {
       return grille;
   }

    /**
     * génération de la grille en fonction du niveau de difficulté choisi par le joueur
     */
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
