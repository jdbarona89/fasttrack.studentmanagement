package com.fasttrack.studentmanagement.Controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasttrack.studentmanagement.modelo.Estudiante;
import com.fasttrack.studentmanagement.modelo.Materia;
import com.fasttrack.studentmanagement.modelo.Matricula;
import com.fasttrack.studentmanagement.modelo.MatriculaDTO;
import com.fasttrack.studentmanagement.service.EstudianteService;
import com.fasttrack.studentmanagement.service.MateriaServices;
import com.fasttrack.studentmanagement.service.MatriculaServices;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;

@Component(value = "matriculaBean")
@ViewScoped
public class MatriculaBean implements Serializable {

    @Inject
    private MateriaServices materiaServices;

    @Inject
    private EstudianteService estudianteService;

    @Inject
    private MatriculaServices matriculaService;

    private List<Materia> listaMaterias;
    private Materia materia=new Materia();

    private List<Estudiante> listaEstudiantes;
    private Estudiante estudiante=new Estudiante();

    private List<MatriculaDTO> listaMatriculas;
    private Matricula matricula=new Matricula();

    private String filtroNombre; 
   

      @PostConstruct
public void init() {
    try {
        listaMaterias = materiaServices.listarMaterias();
        materia = new Materia();
        listaEstudiantes=estudianteService.listarEstudiantes();
        estudiante=new Estudiante();
        listaMatriculas=matriculaService.listaMatriculas();
        matricula=new Matricula();
    } catch (Exception e) {
        e.printStackTrace(); 
        listaMaterias = List.of(); 
    }

}

    public List<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(List<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(List<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public List<MatriculaDTO> getListaMatriculas() {
        return listaMatriculas;
    }

    public void setListaMatriculas(List<MatriculaDTO> listaMatriculas) {
        this.listaMatriculas = listaMatriculas;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public String getFiltroNombre() {
        return filtroNombre;
    }

    public void setFiltroNombre(String filtroNombre) {
        this.filtroNombre = filtroNombre;
    }

    public void deleteMatricula(Long id){
        matriculaService.deleteMatricula(id);
        init();
    }

    public void addMatricula(){
    matriculaService.addMatricula(matricula);
    init();
    }




}
