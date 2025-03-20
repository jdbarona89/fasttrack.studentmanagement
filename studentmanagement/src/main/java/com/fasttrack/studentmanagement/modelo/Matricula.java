package com.fasttrack.studentmanagement.modelo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Matricula {

    private Long id_matricula;
    private Long id_estudiante;
    private Long id_materia;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fecha_matricula;

    public Matricula( Long id_matricula, Long id_estudiante, Long id_materia,LocalDateTime fecha_matricula) {
        this.id_matricula = id_matricula;
        this.id_estudiante = id_estudiante;
        this.id_materia = id_materia;
        this.fecha_matricula = fecha_matricula;
    }

    public Matricula( Long id_estudiante, Long id_materia,LocalDateTime fecha_matricula) {
        this.fecha_matricula = fecha_matricula;
        this.id_estudiante = id_estudiante;
        this.id_materia = id_materia;
    }

    public Matricula() {
    }

    public Matricula(Long id_materia) {
        this.id_materia = id_materia;
    }



    public Long getId() {
        return id_matricula;
    }

    public void setId(Long id_matricula) {
        this.id_matricula = id_matricula;
    }

    public Long getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(Long id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public Long getId_materia() {
        return id_materia;
    }

    public void setId_materia(Long id_materia) {
        this.id_materia = id_materia;
    }

    public LocalDateTime getFecha_matricula() {
        return fecha_matricula;
    }

    public void setFecha_matricula(LocalDateTime fecha_matricula) {
        this.fecha_matricula = fecha_matricula;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matricula{");
        sb.append("id_matricula=").append(id_matricula);
        sb.append(", id_estudiante=").append(id_estudiante);
        sb.append(", id_materia=").append(id_materia);
        sb.append(", fecha_matricula=").append(fecha_matricula);
        sb.append('}');
        return sb.toString();
    }



}
