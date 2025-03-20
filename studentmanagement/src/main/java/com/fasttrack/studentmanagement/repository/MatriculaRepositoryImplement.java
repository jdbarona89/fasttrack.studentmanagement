package com.fasttrack.studentmanagement.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.fasttrack.studentmanagement.modelo.Matricula;
import com.fasttrack.studentmanagement.modelo.MatriculaDTO;

@Repository
public class MatriculaRepositoryImplement implements MatriculaRepository{

    private final JdbcTemplate jdbcTemplate;

    private String sql="";

    public MatriculaRepositoryImplement(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

      private final RowMapper<Matricula> MatriculaRowMapper = (rs, rowNum) -> new Matricula(
            rs.getLong("id_matricula"),
            rs.getLong("id_estudiante"),
            rs.getLong("id_materia"),
            rs.getTimestamp("fecha_matricula").toLocalDateTime() 
    );


    @Override
    public Integer addMatricula(Matricula matricula) {
       sql = "INSERT INTO matricula (id_estudiante, id_materia, fecha_matricula) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, 
                matricula.getId_estudiante(), 
                matricula.getId_materia(), 
                Timestamp.valueOf(matricula.getFecha_matricula()) 
        );
    }

    @Override
    public Integer deleteMatricula(Long id) {
        sql = "UPDATE matricula SET active = 0  WHERE id_matricula = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Matricula MatriculaById(Long id) {
        sql = "SELECT * FROM matricula where id_matricula= ?";
        return jdbcTemplate.queryForObject(sql, MatriculaRowMapper, id);
    }


    public List<MatriculaDTO> listarMatriculas() {
       sql = "SELECT m.id_matricula, m.id_estudiante, m.id_materia, m.fecha_matricula,e.nombre AS nombre_estudiante, e.apellido AS apellido_estudiante, mat.nombre AS nombre_materia FROM matricula m INNER JOIN estudiante e ON m.id_estudiante = e.id_estudiante INNER JOIN materia mat ON m.id_materia = mat.id_materia AND m.active=1";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new MatriculaDTO(
            rs.getLong("id_matricula"),
            rs.getLong("id_estudiante"),
            rs.getString("nombre_estudiante"),
            rs.getString("apellido_estudiante"),
            rs.getLong("id_materia"),
            rs.getString("nombre_materia"),
            rs.getTimestamp("fecha_matricula").toLocalDateTime()
    ));
    }






    }

    

