package com.fasttrack.studentmanagement.service;

import java.util.List;

import com.fasttrack.studentmanagement.modelo.Matricula;
import com.fasttrack.studentmanagement.modelo.MatriculaDTO;

public interface ImatriculaServices {

     Integer addMatricula(Matricula matricula);

    Integer deleteMatricula(Long id);

    List<MatriculaDTO> listaMatriculas();

}
