package com.fasttrack.studentmanagement.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.fasttrack.studentmanagement.modelo.Materia;

@Repository
public class MateriaRepositoryImplement implements MateriaRepository{

private final JdbcTemplate jdbcTemplate;

    private String sql;

    public MateriaRepositoryImplement(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    private final RowMapper<Materia> MateriaRowMapper = (rs, rowNum) -> new Materia(
            rs.getLong("id_materia"),
            rs.getString("nombre"),
            rs.getInt("creditos")
    );


    @Override
    public Materia MateriaById(Long id) {
        sql = "SELECT * FROM materia where id_materia= ?";
        return jdbcTemplate.queryForObject(sql, MateriaRowMapper, id);
    }

    @Override
    public List<Materia> listarMaterias() {
        sql =  "SELECT * FROM materia where active = 1";
        return jdbcTemplate.query(sql, MateriaRowMapper);
    }

    @Override
    public Integer addMateria(Materia materia) {
        sql = "INSERT INTO materia (nombre,creditos) VALUES (?, ?)";
       return  jdbcTemplate.update(sql, materia.getNombre(),materia.getCreditos());

    }

    @Override
    public Integer updateMateria(Materia materia) {
         sql = "UPDATE materia SET nombre = ?, creditos = ? WHERE id_materia =?";
        return  jdbcTemplate.update(sql, materia.getNombre(),materia.getCreditos(),materia.getId_materia());

    }

    @Override
    public Integer deleteMateria(Long id) {
        sql = "UPDATE materia SET active = 0  WHERE id_materia = ?";
        return jdbcTemplate.update(sql, id);
    }

}


