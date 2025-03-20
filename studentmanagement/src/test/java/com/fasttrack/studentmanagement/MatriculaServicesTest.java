package com.fasttrack.studentmanagement;


import com.fasttrack.studentmanagement.exception.MateriaNoExiste;
import com.fasttrack.studentmanagement.modelo.Matricula;
import com.fasttrack.studentmanagement.modelo.MatriculaDTO;
import com.fasttrack.studentmanagement.repository.MateriaRepositoryImplement;
import com.fasttrack.studentmanagement.repository.MatriculaRepository;
import com.fasttrack.studentmanagement.repository.MatriculaRepositoryImplement;
import com.fasttrack.studentmanagement.service.MatriculaServices;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


public class MatriculaServicesTest {

    @Mock
    private MatriculaRepositoryImplement mockRepository;

    @InjectMocks
    private MatriculaServices matriculaServices;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddMatricula() {
        Matricula matricula = new Matricula();
        matricula.setId(1L);
        matricula.setId_estudiante(26L);
        matricula.setId_materia(4L);
        matricula.setFecha_matricula(LocalDateTime.now());
        when(mockRepository.addMatricula(matricula)).thenReturn(1);
        Integer result = matriculaServices.addMatricula(matricula);
        assertEquals(Integer.valueOf(1), result);
        verify(mockRepository, times(1)).addMatricula(matricula);

    }

    @Test
    public void testDeleteMatriculaExists() {

        Long id=3L;
        Matricula matricula = new Matricula();
        matricula.setId(3L);
        matricula.setId_estudiante(26L);
        matricula.setId_materia(4L);
        matricula.setFecha_matricula(LocalDateTime.now());
        when(mockRepository.MatriculaById(3L)).thenReturn(matricula);
        when(mockRepository.deleteMatricula(3L)).thenReturn(1);
        Integer result = matriculaServices.deleteMatricula(3L);
        assertEquals(Integer.valueOf(1), result);
    }

    @Test
    public void testDeleteMatriculaNotExists() {
        Long id = 2L;
        when(mockRepository.deleteMatricula(2L)).thenReturn(null);
        Exception ex = assertThrows(MateriaNoExiste.class,()->{
            matriculaServices.deleteMatricula(2L);
        });
          assertEquals("La Matricula con "+ " " + id + " " + "no existe",ex.getMessage());
          verify(mockRepository, never()).deleteMatricula(id);
    }


    @Test
    public void testListaMatriculas() {
        List<MatriculaDTO> mockedList = new ArrayList<>();
        when(mockRepository.listarMatriculas()).thenReturn(mockedList);
        List<MatriculaDTO> result = matriculaServices.listaMatriculas();
        assertEquals(mockedList, result);
    }
}