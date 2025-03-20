package com.fasttrack.studentmanagement.modelo;


public class Materia {

private Long id_materia;
private String nombre;
private Integer creditos;

    public Materia( Long id_materia, String nombre,Integer creditos) {
        this.creditos = creditos;
        this.id_materia = id_materia;
        this.nombre = nombre;
    }

    public Materia() {
    }

    public Materia(Long id_materia) {
        this.id_materia = id_materia;
    }


    public Long getIdMateria() {
        return id_materia;
    }

    public void getIdMateria(Long id_materia) {
        this.id_materia = id_materia;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return "MateriaDAO{" +
                "idMateria=" + id_materia +
                ", nombre='" + nombre + '\'' +
                ", creditos=" + creditos +
                '}';
    }




    public Long getId_materia() {
        return id_materia;
    }




    public void setId_materia(Long id_materia) {
        this.id_materia = id_materia;
    }
}
