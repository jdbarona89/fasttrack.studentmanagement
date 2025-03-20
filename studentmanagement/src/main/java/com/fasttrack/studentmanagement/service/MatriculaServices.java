package com.fasttrack.studentmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasttrack.studentmanagement.exception.MateriaNoExiste;
import com.fasttrack.studentmanagement.modelo.Matricula;
import com.fasttrack.studentmanagement.modelo.MatriculaDTO;
import com.fasttrack.studentmanagement.repository.MatriculaRepository;

@Service
public class MatriculaServices implements ImatriculaServices {


    private final MatriculaRepository matriculaRepository;

    public MatriculaServices (MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }



    @Override
    public Integer addMatricula(Matricula matricula) {
        return matriculaRepository.addMatricula(matricula);
    }

    @Override
    public Integer deleteMatricula(Long id) {
           return  Optional.ofNullable(matriculaRepository.MatriculaById(id)).map(m->{
           return  matriculaRepository.deleteMatricula(id);
        }).orElseThrow(()->new MateriaNoExiste("La Matricula con " + " "+  id + " " + "no existe"));
    };

    @Override
    public List<MatriculaDTO> listaMatriculas() {
        return matriculaRepository.listarMatriculas();
    }
    }


