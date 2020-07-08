package com.plainid.assignment.dao;

import java.util.List;
import java.util.Stack;

public class Trainer {
    String name;
    int level;
    //bag should be LIFO
    //todo: ask if "most former" means last inserted or first inserted?
    List<Pokemon> bag;
    int bagSize;

    public int getBagSize() {
        return bagSize;
    }

    public void setBagSize(int bagSize) {
        this.bagSize = bagSize;
    }


    public void addToLevel(int l){
        level += l;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setBag(List<Pokemon> bag) {
        this.bag = bag;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public List<Pokemon> getBag() {
        return bag;
    }

    public boolean isBagFull() {
        return bagSize == 3;
    }
    /*public void pokemonCatch(Pokemon p){
        //bag of pokemons is full, set free most former (last inserted)
        if (bag.size() == 3)
            bag.pop();
        bag.push(p);
    }*/
   /* @Override
    public String toString() {
        return "{"+ " name='" + this.name + '\'' +',' +", level='" + this.level + '\'' /*+ ", bag='" + "'[' " + this.bag.get(0) + '\'' *///+'}'+"\n";
    //}
}
