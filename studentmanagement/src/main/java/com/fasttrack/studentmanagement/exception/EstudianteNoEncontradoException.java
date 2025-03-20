package com.fasttrack.studentmanagement.exception;

public class EstudianteNoEncontradoException extends  RuntimeException{

    private String mensaje;

    public EstudianteNoEncontradoException(String message) {
        super(message);

    }
}
