package com.plainid.assignment.dao;

/**
 * Pokémon are creatures of all shapes and sizes who live in the wild or alongside humans.
 * For the most part, Pokémon do not speak except to utter their names.
 * There are currently more than 700 creatures that inhabit the Pokémon universe.
 */
public class Pokemon {

    int id;
    String name;
    PokemonType type;
    String tname;
    int insertime;

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public int getInsertime() {
        return insertime;
    }

    public void setInsertime(int insertime) {
        this.insertime = insertime;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokemonType getType() {
        return type;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{"+ " name='" + this.name + '\"' +", type='" + this.type + "}";
    }
}
