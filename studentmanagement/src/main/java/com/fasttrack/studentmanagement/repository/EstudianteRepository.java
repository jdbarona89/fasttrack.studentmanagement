package com.fasttrack.studentmanagement.repository;

import java.util.List;

import com.fasttrack.studentmanagement.modelo.Estudiante;

public interface EstudianteRepository {

    Estudiante estudianteById (Long id);

    List<Estudiante> listarEstudiantes();

    Integer addEstudiante(Estudiante estudiante);

    Integer updateEstudiante(Estudiante estudiante);

    Integer deleteEstudiante(Long id);

    List<Estudiante> estudianteByName(String nombre,String apellido);

}
