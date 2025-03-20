package com.fasttrack.studentmanagement.repository;

import java.util.List;

import com.fasttrack.studentmanagement.modelo.Materia;

public interface  MateriaRepository {

    
    Materia MateriaById (Long id);

    List<Materia> listarMaterias();

    Integer addMateria(Materia materia);

    Integer updateMateria(Materia materia);

    Integer deleteMateria(Long id);

    

}
