package com.fasttrack.studentmanagement.exception;


public class MateriaNoExiste extends RuntimeException {

    private String mesanje;

    public MateriaNoExiste(String message) {
        super(message);
    }

}
