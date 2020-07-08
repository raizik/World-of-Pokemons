package com.plainid.assignment.dao;

import com.plainid.assignment.converter.mapper.PokemonRawMapper;
import com.plainid.assignment.converter.mapper.TrainerRawMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class TrainerDao implements Dao<Trainer, Integer, String, Integer> {
    private

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Trainer get(String id) {
        String query1 = "select * from TRAINERS where NAME = '" + id + "'";
        String query2 = "select * from POKEMON where NAMET = '" + id + "'" + "ORDER BY INSERTIME";
        Trainer t = jdbcTemplate.queryForObject(query1, new TrainerRawMapper());
        List<Pokemon> tBag = jdbcTemplate.query(query2 ,new PokemonRawMapper());
        t.setBag(tBag);
        t.setBagSize(t.getBagSize());
        return t;
    }
    //todo: think of more efficient way to do this
    @Override
    public List<Trainer> getAll() {

        List<Trainer> tList = jdbcTemplate.query("SELECT * from TRAINERS", new TrainerRawMapper());
        for (Trainer e : tList) {
            String tName = e.getName();
            List<Pokemon> tBag = jdbcTemplate.query("SELECT * from POKEMON where NAMET = '" + tName + "'"  +
                    "ORDER BY INSERTIME" ,new PokemonRawMapper());
            e.setBag(tBag);
        }
        return tList;
    }

    @Override
    public void save(Trainer t) {
        jdbcTemplate.update("insert into TRAINERS (name, level) " + "values(?,  ?)",
                new Object[] {
                        t.getName(), t.getLevel()
                });
    }
    //todo: no need for third argument, consider change in Dao interface
    @Override
    public void update(Trainer t, Integer tLevel, Integer i) {
        jdbcTemplate.update("update TRAINERS " + " set LEVEL = ? " + " where NAME = ?",
                new Object[] {
                        tLevel, t.getName()
                });
    }

    @Override
    public void delete(Trainer t) {
        jdbcTemplate.update("delete from TRAINERS where NAME=?", new Object[] {
                t.getName()
        });
    }
    public Pokemon getMostFormerPokemon(Trainer t) {
        List<Pokemon> tBag = jdbcTemplate.query("SELECT * from POKEMON where NAMET = '" + t.getName() + "'" +"ORDER BY INSERTIME" ,new PokemonRawMapper());
        return tBag.get(0);
    }
    public void updateBagSize(Trainer t, Integer bagSize) {
        jdbcTemplate.update("update TRAINERS " + " set BAGSIZE = ? " + " where NAME = ?",
                new Object[] {
                        bagSize, t.getName()
                });
    }
}
