package com.fasttrack.studentmanagement.repository;


import java.util.Collections;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fasttrack.studentmanagement.modelo.Estudiante;

@Repository
public class EstudianteRepositoryImplement implements EstudianteRepository {


    private static final Logger logger = LoggerFactory.getLogger(EstudianteRepositoryImplement.class);

    private final JdbcTemplate jdbcTemplate;

    private String sql;

    public EstudianteRepositoryImplement(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    private final RowMapper<Estudiante> EstudianteRowMapper = (rs, rowNum) -> new Estudiante(
            rs.getLong("id_estudiante"),
            rs.getString("nombre"),
            rs.getString("apellido"),
            rs.getString("pais"),
            rs.getString("email")
    );


    public Estudiante estudianteById(Long id) {
        sql = "SELECT * FROM estudiante where id_estudiante= ?";
        return jdbcTemplate.queryForObject(sql, EstudianteRowMapper, id);
    }

    @Override
    public List<Estudiante> listarEstudiantes() {
        sql = "SELECT * FROM estudiante where active = 1";
        return jdbcTemplate.query(sql, EstudianteRowMapper);
    }

    @Override
    public Integer addEstudiante(Estudiante estudiante) {
        try {
            String sql = "INSERT INTO estudiante (nombre, apellido, email, pais) VALUES (?, ?, ?, ?)";
            int filasAfectadas = jdbcTemplate.update(sql, estudiante.getNombre(), estudiante.getApellido(), estudiante.getEmail(), estudiante.getPais());
            logger.info("Estudiante agregado correctamente: {}", estudiante);
            return filasAfectadas;
        } catch (DataAccessException e) {
            logger.error("Error al guardar el estudiante: {}", e.getMessage(), e);
            return 0;
        }
    }

    @Override
    public Integer updateEstudiante(Estudiante estudiante) {
        try{
            sql = "UPDATE estudiante SET nombre = ?, apellido = ?, pais = ?, email = ? WHERE id_estudiante =?";
            int filasAfectadas = jdbcTemplate.update(sql, estudiante.getNombre(), estudiante.getApellido(), estudiante.getPais(), estudiante.getEmail(), estudiante.getId_estudiante());
            logger.info("Estudiante actualizado correctamente: {}", estudiante);
            return filasAfectadas;
        }catch (DataAccessException e){
            logger.error("Error al actualizar el estudiante: {}", e.getMessage(), e);
            return 0;
        }


    }

    @Override
    public Integer deleteEstudiante(Long id) {
        sql = "UPDATE estudiante SET active = 0  WHERE id_estudiante = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Estudiante> estudianteByName(String nombre, String apellido) {
        sql = "SELECT * FROM estudiante WHERE split_part(nombre, ' ', 1) = ? AND split_part(apellido, ' ', 1) = ?";
        String primerNombre = nombre.split(" ")[0];
        String primerApellido = apellido.split(" ")[0];
        List<Estudiante> estudiantes = jdbcTemplate.query(sql, EstudianteRowMapper, primerNombre, primerApellido);
        return estudiantes.isEmpty() ? Collections.emptyList() : estudiantes;
    }


}