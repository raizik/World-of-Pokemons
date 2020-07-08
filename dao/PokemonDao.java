package com.plainid.assignment.dao;

import com.plainid.assignment.converter.mapper.PokemonRawMapper;
import com.plainid.assignment.converter.mapper.TrainerRawMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PokemonDao implements Dao<Pokemon, String, String, Integer> {
    private

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Pokemon get(String id) {
        return jdbcTemplate.queryForObject("select * from POKEMON where NAME = '" + id + "'", new PokemonRawMapper());
    }

    @Override
    public List<Pokemon> getAll() {
        return jdbcTemplate.query("SELECT * from POKEMON", new PokemonRawMapper());
    }

    @Override
    public void save(Pokemon p) {
        jdbcTemplate.update("insert into POKEMON (id, name, type, tname, insertime) " + "values(?,  ?, ?, ?, ?)",
                new Object[] {
                        p.getId(), p.getName(), p.getType(), p.getTname(), p.getInsertime()
                });
    }

    @Override
    public void update(Pokemon p, String tName,Integer iTime) {
        jdbcTemplate.update("update POKEMON " + " set NAMET = ? , INSERTIME = ?" + " where ID = ?",
                new Object[] {
                        tName, iTime, p.getId()
                });
    }

    @Override
    public void delete(Pokemon p) {
        jdbcTemplate.update("delete from POKEMON where id=?", new Object[] {
                p.getId()
        });
    }
}
