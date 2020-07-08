package com.plainid.assignment.dao;

import java.util.List;

/**
 * List of pojenons
 */
public class PokemonList {
    List<Pokemon> pokemons;

    public List<Pokemon> getPokemons() {
        return pokemons;
    }
    public Pokemon findPokemon(String name) {
        for (Pokemon element : this.pokemons) {
            if (element.name == name)
                return element;
        }
        return null;
    }
    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}