package com.cyrleb.sudoku;

public class Case {

    private String value;
    private boolean modifiable;

    public Case(String value){
        this.value = value;
        modifiable = false;
    }

    public Case(String value, boolean modifiable){
        this.value = value;
        this.modifiable = modifiable;
    }

    public Case(){
        this.modifiable = true;
        this.value = "";
    }

    public String getValue(){
        return this.value;
    }

    public void setValue(String value){
        if (this.modifiable){
            this.value = value;
        }
    }

    public boolean getModifiable(){
        return this.modifiable;
    }

    public String toString(){
        return this.value;
    }
}
