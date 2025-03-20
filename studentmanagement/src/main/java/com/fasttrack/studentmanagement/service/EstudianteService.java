package com.fasttrack.studentmanagement.service;



import java.text.Normalizer;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasttrack.studentmanagement.exception.EstudianteNoEncontradoException;
import com.fasttrack.studentmanagement.modelo.Estudiante;
import com.fasttrack.studentmanagement.repository.EstudianteRepositoryImplement;

@Service
public class EstudianteService implements IestudianteServices {


    private final EstudianteRepositoryImplement repositoryImplement;


    public EstudianteService(EstudianteRepositoryImplement repositoryImplement) {
        this.repositoryImplement = repositoryImplement;
    }


    @Override
    public Estudiante estudianteById(Long id) {
       return  Optional.ofNullable(repositoryImplement.estudianteById(id))
                .orElseThrow(()->new EstudianteNoEncontradoException("El estudiante con id" + id+ "no existe"));
    }

    @Override
    public List<Estudiante> listarEstudiantes() {
        return repositoryImplement.listarEstudiantes();
    }

    @Override
    public Integer addEstudiante(Estudiante estudiante) {

        String nombre = normalizarTexto(estudiante.getNombre());
        String apellido = normalizarTexto(estudiante.getApellido());
        String pais = estudiante.getPais();
        String email = generarEmail(nombre, apellido, pais);
        Estudiante es = new Estudiante(nombre, apellido, email, estudiante.getPais());
        return repositoryImplement.addEstudiante(es);
    }


    @Override
    public Integer updateEstudiante(Estudiante estudiante) {
        
        Long id= estudiante.getId_estudiante();

       return  Optional.ofNullable(repositoryImplement.estudianteById(estudiante.getId_estudiante())).map(e->{
            
            e.setNombre(normalizarTexto(estudiante.getNombre()));
            e.setApellido(normalizarTexto(estudiante.getApellido()));
            e.setPais(estudiante.getPais());
            e.setEmail(estudiante.getEmail());
            e.setId_estudiante(estudiante.getId_estudiante());
            return repositoryImplement.updateEstudiante(e);
        }).orElseThrow(()->new RuntimeException("El estudiante no existe en la base de datos"));

       
    }

    @Override
    public Integer deleteEstudiante(Long id) {
        return Optional.ofNullable(repositoryImplement.estudianteById(id))
                .map(estudiante -> {
                    return repositoryImplement.deleteEstudiante(estudiante.getId_estudiante());
                })
                .orElseThrow(()->new EstudianteNoEncontradoException("El Estuadiante con + " +  " " +  id  + " " + "no existe"));

        }
    private void validacionEstudiante(Estudiante estudiante){

        if(!estudiante.getNombre().matches("[A-Z]+")|| estudiante.getNombre().length()<30){
            throw new RuntimeException("El nombre debe contener solo letras mayusculas y maximo 30 caracteres");
        } if(!estudiante.getApellido().matches("[A-Z]+")|| estudiante.getApellido().length()<30){
            throw new RuntimeException("El apellido debe contener solo letras mayusculas y maximo 30 caracteres");
        } if(estudiante.getPais().isBlank()){
            throw new RuntimeException("Debe seleccionar el pais de origen");
        }

    }

    private String generarEmail(String nombre,String apellido,String pais){

        String [] apellidos=apellido.split(" ");
        String [] nombres=nombre.split(" ");
        String email="";
        if(apellidos.length <= 2){
            email=email+apellidos[0] + ".";
        }if(nombres.length <= 2){
            email=email+nombres[0] + ".";
        }
       email=email+ "."+ "@FastTrack.com" + "." + pais.substring(0,2).toLowerCase();
        return generarEmailFinal(nombre,apellido,email);


    }

    private String generarEmailFinal(String nombre,String apellido,String email){
       
        String correo="";
        String [] mail=email.split("(?=\\.)");
        List<Estudiante> list= repositoryImplement.estudianteByName(nombre,apellido);
        if(list.isEmpty()){
            
                correo=  mail[0] + mail[1] + mail[2] + mail[3].substring(1, mail[3].length())+mail[4]+mail[5] ;
            
        } else {

            if(list.size()==1){

                if (mail[2].equalsIgnoreCase(".")) {

             
                    correo= mail[0] + mail[1] + mail[2].replace(mail[2],".1")+ mail[3].substring(1, mail[3].length())+mail[4]+mail[5] ;

            }

            }if(list.size()>1) {

                Integer id=(list.size()-1)+1;

                String value="."+id;
    
                correo= mail[0] + mail[1] + mail[2].replace(mail[2],value)+ mail[3].substring(1, mail[3].length())+mail[4]+mail[5] ;

            }

        }

    return  correo;
    }

    private String normalizarTexto(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[^\\p{ASCII}]", "");
        texto = texto.replaceAll("Ñ", "N").replaceAll("ñ", "n");
        return texto.toLowerCase();
    }





}
