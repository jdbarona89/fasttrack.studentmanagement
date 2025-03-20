package com.fasttrack.studentmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasttrack.studentmanagement.exception.MateriaNoExiste;
import com.fasttrack.studentmanagement.modelo.Materia;
import com.fasttrack.studentmanagement.repository.MateriaRepository;

@Service
public class MateriaServices implements  ImateriaServices{


    private final MateriaRepository materiaRepository;

    public MateriaServices(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }


    @Override
    public Materia materiaById(Long id) {
        return Optional.ofNullable(materiaRepository.MateriaById(id))
        .orElseThrow(()->new MateriaNoExiste("La materia con " + id + "No existe"));
    }

    @Override
    public List<Materia> listarMaterias() {
        return materiaRepository.listarMaterias();
    }

    @Override
    public Integer addMateria(Materia materia) {
        return materiaRepository.addMateria(materia);
    }

    @Override
    public Integer updateMateria(Materia materia) {

        return Optional.ofNullable(materiaRepository.MateriaById(materia.getId_materia())).map(m->{
            m.setNombre(materia.getNombre());
            m.setCreditos(materia.getCreditos());
            m.setId_materia(materia.getId_materia());
            return materiaRepository.updateMateria(m);
        }).orElseThrow(()->new MateriaNoExiste("La materia" + materia.getNombre() + "No existe en la base de datos"));
     
    }

    @Override
    public Integer deleteMateria(Long id) {

        return  Optional.ofNullable(materiaRepository.MateriaById(id)).map(m->{
           return  materiaRepository.deleteMateria(id);
        }).orElseThrow(()->new MateriaNoExiste("La materia con " + id + "no existe"));
    }




}
