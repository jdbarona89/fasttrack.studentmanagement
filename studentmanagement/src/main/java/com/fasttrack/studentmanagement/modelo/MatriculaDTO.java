package com.fasttrack.studentmanagement.modelo;

import java.time.LocalDateTime;


public class MatriculaDTO extends Matricula {
    private String nombre_estudiante;
    private String nombre_materia;
    private String apellido_estudiante;


    public MatriculaDTO(Long id_matricula, Long id_estudiante, String nombre_estudiante,String apellido_estudiante,
                        Long id_materia, String nombre_materia, LocalDateTime fecha_matricula) {
        
       super(id_matricula, id_estudiante, id_materia, fecha_matricula);
       this.nombre_estudiante = nombre_estudiante;
       this.nombre_materia = nombre_materia;
       this.apellido_estudiante=apellido_estudiante;
      
    }

   



    public String getNombre_estudiante() {
        return nombre_estudiante;
    }

    public void setNombre_estudiante(String nombre_estudiante) {
        this.nombre_estudiante = nombre_estudiante;
    }

    public String getNombre_materia() {
        return nombre_materia;
    }

    public void setNombre_materia(String nombre_materia) {
        this.nombre_materia = nombre_materia;
    }

    
    public String getApellido_estudiante() {
        return apellido_estudiante;
    }


    public void setApellido_estudiante(String apellido_estudiante) {
        this.apellido_estudiante = apellido_estudiante;
    }

    @Override
    public String toString() {
        return "MatriculaDTO{" +
                "id_matricula=" + getId() +
                ", id_estudiante=" + getId_estudiante() +
                ", nombre_estudiante='" + nombre_estudiante + '\'' +
                ", id_materia=" + getId_materia() +
                ", nombre_materia='" + nombre_materia + '\'' +
                ", fecha_matricula=" + getFecha_matricula() +
                '}';
    }








}
