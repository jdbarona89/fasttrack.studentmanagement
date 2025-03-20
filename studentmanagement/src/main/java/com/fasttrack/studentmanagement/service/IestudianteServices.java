package com.fasttrack.studentmanagement.service;

import com.fasttrack.studentmanagement.modelo.Estudiante;

import java.util.List;

public interface IestudianteServices {


    Estudiante estudianteById (Long id);

    List<Estudiante> listarEstudiantes();

    Integer addEstudiante(Estudiante estudiante);

    Integer updateEstudiante(Estudiante estudiante);

    Integer deleteEstudiante(Long id);

}
