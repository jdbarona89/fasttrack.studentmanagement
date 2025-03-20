package com.fasttrack.studentmanagement;

import com.fasttrack.studentmanagement.exception.EstudianteNoEncontradoException;
import com.fasttrack.studentmanagement.exception.MateriaNoExiste;
import com.fasttrack.studentmanagement.modelo.Estudiante;
import com.fasttrack.studentmanagement.repository.EstudianteRepositoryImplement;
import com.fasttrack.studentmanagement.repository.MatriculaRepositoryImplement;
import com.fasttrack.studentmanagement.service.EstudianteService;
import com.fasttrack.studentmanagement.service.MatriculaServices;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

public class EstudianteServicesTest {



    @Mock
    private EstudianteRepositoryImplement mockRepository;

    @InjectMocks
    private EstudianteService estudianteService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testUpdateEstudainte() {
        Estudiante es= new Estudiante();
        es.setNombre("Juan David");
        es.setApellido("Bañona Zañala");
        es.setPais("Colombia");
        es.setPais("Venezuela");
        es.setEmail("juan.banona.@FastTrack.com.ve");
        es.setId_estudiante(5L);
        when(mockRepository.estudianteById(es.getId_estudiante())).thenReturn(es);
        when(mockRepository.updateEstudiante(es)).thenReturn(1);
        int res=estudianteService.updateEstudiante(es);
        Assert.assertEquals(1,res);
        verify(mockRepository, times(1)).updateEstudiante(es);

    }

    @Test
    public void testdeleteEstudainte() {
        Estudiante es= new Estudiante();
        es.setNombre("Juan David");
        es.setApellido("Bañona Zañala");
        es.setPais("Colombia");
        es.setPais("Venezuela");
        es.setEmail("juan.banona.@FastTrack.com.ve");
        es.setId_estudiante(5L);
        when(mockRepository.estudianteById(es.getId_estudiante())).thenReturn(es);
        when(mockRepository.deleteEstudiante(5L)).thenReturn(1);
        int res=estudianteService.deleteEstudiante(es.getId_estudiante());
        Assert.assertEquals(1,res);
        verify(mockRepository, times(1)).deleteEstudiante(es.getId_estudiante());

    }




    @Test
    public void testDeleteEstudianteNotExists() {
        Long id = 2L;
        when(mockRepository.estudianteById(2L)).thenReturn(null);
        Exception ex = assertThrows(EstudianteNoEncontradoException.class,()->{
            estudianteService.deleteEstudiante(2L);
        });
        assertEquals("El Estuadiante con + " +  " " +  id  + " " + "no existe",ex.getMessage());
        verify(mockRepository, never()).deleteEstudiante(2L);
    }

    @Test
    public void testaddEstudainte() {
        Estudiante es= new Estudiante();
        es.setNombre("Juan David");
        es.setApellido("Bañona Zañala");
        es.setPais("Colombia");
        es.setPais("Venezuela");
        //es.setEmail("juan.banona.@FastTrack.com.ve");
        es.setId_estudiante(5L);
        when(mockRepository.addEstudiante(es)).thenReturn(1);
        int res=estudianteService.addEstudiante(es);
       Assertions.assertAll(()->Assert.assertEquals(1,res),
        ()-> Assert.assertEquals("juan.banona.@FastTrack.com.ve",es.getEmail())
);
        verify(mockRepository, times(1)).updateEstudiante(es);
    }


}
