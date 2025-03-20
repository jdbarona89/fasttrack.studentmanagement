package com.fasttrack.studentmanagement.modelo;


public class Estudiante {

    private Long id_estudiante;
    private String nombre;
    private String apellido;
    private String pais;
    private String email;

    public Estudiante(Long id_estudiante, String nombre, String apellido, String pais, String email) {
        this.id_estudiante = id_estudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
        this.email = email;
    }

    public Estudiante(String nombre, String apellido, String email,String pais) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.pais = pais;
        
    }

    public Estudiante(Long id_estudiante) {
        this.id_estudiante = id_estudiante;

    }

    public Estudiante() {


    }

    public Estudiante(String apellido, String nombre) {
        this.apellido = apellido;
        this.nombre = nombre;
    }




    public Long getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(Long id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id_estudiante=" + id_estudiante +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", pais='" + pais + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
