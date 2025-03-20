package com.fasttrack.studentmanagement.Controller;


import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasttrack.studentmanagement.Common.Utils.Pais;
import com.fasttrack.studentmanagement.modelo.Estudiante;
import com.fasttrack.studentmanagement.service.EstudianteService;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;


@Component(value = "estudianteBean")
@ViewScoped
public class EstudianteBean implements Serializable {

    private List<Estudiante> listaEstudiantes;
    private Estudiante estudiante=new Estudiante();
   


    @Inject
    private EstudianteService estudianteService;


    @PostConstruct
public void init() {
    try {
        listaEstudiantes = estudianteService.listarEstudiantes();
        estudiante = new Estudiante();
    } catch (Exception e) {
        e.printStackTrace(); 
        listaEstudiantes = List.of(); 
    }
}

    public void addEstuandiante(){

        if(estudiante.getId_estudiante()!=null){
            estudianteService.updateEstudiante(estudiante);
        }else{
            estudianteService.addEstudiante(estudiante);
        }
       init();
        
    }

    public void deleteEstudiante(Long id){
        estudianteService.deleteEstudiante(id);
        init();
    }

    public void cargarEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }


    public List<Estudiante> getListaEstudiantes() {
        return estudianteService.listarEstudiantes();
    }

    public Estudiante estudianteById(Long id){
           return estudianteService.estudianteById(id);
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public List<Pais> getListaPaises() {
        return Arrays.asList(Pais.values());
    }

   

}
