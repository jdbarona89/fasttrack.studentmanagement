package com.fasttrack.studentmanagement.Controller;



import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasttrack.studentmanagement.modelo.Materia;
import com.fasttrack.studentmanagement.service.MateriaServices;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;

@Component(value = "materiaBean")
@ViewScoped
public class MateriaBean implements Serializable {

private List<Materia> listaMaterias;
private Materia materia=new Materia();
   

    @Inject
    private MateriaServices materiaServices;


    @PostConstruct
public void init() {
    try {
        listaMaterias = materiaServices.listarMaterias();
        materia = new Materia();
    } catch (Exception e) {
        e.printStackTrace(); 
        listaMaterias = List.of(); 
    }
}

    public void addMateria(){

        if(materia.getId_materia()!=null){
            materiaServices.updateMateria(materia);
        }else{
            materiaServices.addMateria(materia);
        }
       init();
    }

      public void cargarMateria(Materia materia) {
        this.materia= materia;
    }

    public void deleteMateria(Long id){
        materiaServices.deleteMateria(id);
        init();
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

    public MateriaServices getMateriaServices() {
        return materiaServices;
    }

    public void setMateriaServices(MateriaServices materiaServices) {
        this.materiaServices = materiaServices;
    }

    
   






}
