package com.cyrleb.sudoku;

public class Case {

    private String value;
    private boolean modifiable;

    Case(String value){
        this.value = value;
        modifiable = false;
    }

    Case(String value, boolean modifiable){
        this.value = value;
        this.modifiable = modifiable;
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
}
