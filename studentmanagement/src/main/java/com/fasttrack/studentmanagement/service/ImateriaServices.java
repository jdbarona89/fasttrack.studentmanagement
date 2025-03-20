package com.fasttrack.studentmanagement.service;

import java.util.List;

import com.fasttrack.studentmanagement.modelo.Materia;

public interface ImateriaServices {


    Materia materiaById (Long id);

    List<Materia> listarMaterias();

    Integer addMateria(Materia materia);

    Integer updateMateria(Materia materia);

    Integer deleteMateria(Long id);




}
