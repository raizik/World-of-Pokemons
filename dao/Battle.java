package com.plainid.assignment.dao;

public class Battle {
    String status, message;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void goBattle(Trainer t1, Trainer t2){
        //check if trainers can battle
        if (t1.bag.size() < 3 || t2.bag.size() < 3){
            this.status = "Error";
            this.message = "Canceled";
            return;
        }
        this.status = "Success";
        int numPokemonsWin_t1 = 0, numPokemonsWin_t2 = 0;
        int numBattles = 0;
        //3 battle rounds
        while (numBattles < 3){
            PokemonType t1_type = t1.bag.get(numBattles).getType();
            PokemonType t2_type = t2.bag.get(numBattles).getType();
            if (t1_type.compareTo(t2_type) == 0){
                //tie!
                numPokemonsWin_t1++;
                numPokemonsWin_t2++;
                t1.addToLevel(1);
                t2.addToLevel(1);
            }
            if (t1_type.compareTo(t2_type) < 0 ){
                if (t1_type.toString() == "Grass" && t2_type.toString() == "Water"){
                    //t1 wins!
                    numPokemonsWin_t1++;
                    t1.addToLevel(2);
                }
                else{
                    //t2 wins!
                    numPokemonsWin_t2++;
                    t2.addToLevel(2);
                }
            }
            else if (t2_type.compareTo(t1_type) < 0){
                if (t2_type.toString() == "Grass" && t1_type.toString() == "Water"){
                    //t2 wins!
                    numPokemonsWin_t2++;
                    t2.addToLevel(2);
                }
                else{
                    //t1 wins!
                    numPokemonsWin_t1++;
                    t1.addToLevel(2);
                }
            }
            numBattles++;
        }
        if (numPokemonsWin_t1 == numPokemonsWin_t2){
            this.message = "Draw";
            return;
        }
        if (numPokemonsWin_t1 > numPokemonsWin_t2){
            this.message = t1.name + " wins";
            return;
        }
        //else
        this.message = t2.name + " wins";
    }
}
