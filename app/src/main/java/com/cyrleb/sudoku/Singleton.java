package com.cyrleb.sudoku;

import com.cyrleb.sudoku.databinding.ActivityPageJeuBinding;

public class Singleton {
   private static Singleton instance = new Singleton();
   private String selectedNumber;
   private String difficulty;
   private Grille grille;
   private ActivityPageJeuBinding mBinding;

   public Singleton(){
       this.selectedNumber = "";
       this.difficulty = "";
   }
   static Singleton getInstance(){
       return instance;
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
   }

   // set in instance the mBinding for PageJeu
   public void bindingPageJeu(ActivityPageJeuBinding mBinding){
       this.mBinding = mBinding;
   }

   public void controlFinishedGame(){
       if (grille.isTermine()){
           mBinding.finishLabel.setText("Bravo ! Vous avez gagné");
       } else {
           mBinding.finishLabel.setText("");
       }
   }

   public Grille getGrille() {
       return grille;
   }
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
       Section[][] temp = {{}};
       switch(this.difficulty){
           case "facile":
               cases11 = new Case[][]{
                       {new Case("3"), new Case("9"), new Case("1")},
                       {new Case("4"), new Case("8"), new Case("7")},
                       {new Case("6"), new Case("5"), new Case("2")}};

               cases12 = new Case[][]{
                       {new Case("2"), new Case("8"), new Case("6")},
                       {new Case("3"), new Case("5"), new Case("9")},
                       {new Case("7"), new Case("1"), new Case("4")}};

               cases13 = new Case[][]{
                       {new Case("5"), new Case("7"), new Case("4")},
                       {new Case("1"), new Case("2"), new Case("6")},
                       {new Case("8"), new Case("3"), new Case("9")}};
               // -----
               cases21 = new Case[][]{
                       {new Case("8"), new Case("7"), new Case("5")},
                       {new Case("2"), new Case("1"), new Case("3")},
                       {new Case("9"), new Case("6"), new Case("4")}};

               cases22 = new Case[][]{
                       {new Case("4"), new Case("3"), new Case("1")},
                       {new Case("9"), new Case("6"), new Case("7")},
                       {new Case("5"), new Case("2"), new Case("8")}};

               cases23 = new Case[][]{
                       {new Case("6"), new Case("9"), new Case("2")},
                       {new Case("4"), new Case("8"), new Case("5")},
                       {new Case("7"), new Case("1"), new Case("3")}};
               // ----
               cases31 = new Case[][]{
                       {new Case("1"), new Case("4"), new Case("9")},
                       {new Case("5"), new Case("3"), new Case("8")},
                       {new Case("7"), new Case("2"), new Case("6")}};

               cases32 = new Case[][]{
                       {new Case("6"), new Case("7"), new Case("3")},
                       {new Case("1"), new Case("4"), new Case("2")},
                       {new Case("8"), new Case("9"), new Case("5")}};

               cases33 = new Case[][]{
                       {new Case("2"), new Case("5"), new Case("8")},
                       {new Case("9"), new Case("6"), new Case("7")},
                       {new Case("3"), new Case("4"), new Case()}};
               break;
           case "moyen":
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
           case "difficile":
               cases11 = new Case[][]{
                       {new Case(), new Case(), new Case("8")},
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

       }
       temp = new Section[][]{{new Section(cases11), new Section(cases12), new Section(cases13)},
               {new Section(cases21), new Section(cases22), new Section(cases23)},
               {new Section(cases31), new Section(cases32), new Section(cases33)}};

       this.grille = new Grille(temp);
   }
}
