package com.fasttrack.studentmanagement.repository;

import java.util.List;

import com.fasttrack.studentmanagement.modelo.Matricula;
import com.fasttrack.studentmanagement.modelo.MatriculaDTO;

public interface MatriculaRepository {


    Integer addMatricula(Matricula matricula);

    Integer deleteMatricula(Long id);

    Matricula MatriculaById (Long id);

    List<MatriculaDTO> listarMatriculas();



}
