package com.plainid.assignment.converter.mapper;

import com.plainid.assignment.dao.Pokemon;
import com.plainid.assignment.dao.Trainer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Stack;

public class TrainerRawMapper implements RowMapper<Trainer> {
    @Override
    public Trainer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Trainer trainer = new Trainer();
        trainer.setName(rs.getString("NAME"));
        trainer.setLevel(rs.getInt("LEVEL"));
        trainer.setBag(new ArrayList<Pokemon>());
        trainer.setBagSize(rs.getInt("BAGSIZE"));
            return trainer;
    }
}
