package com.fasttrack.studentmanagement.Common.Utils;


    public enum Pais {
        Argentina("Argentina"),
        Bolivia("Bolivia"),
        Brasil("Brasil"),
        Canadá("Canadá"),
        Chile("Chile"),
        Colombia("Colombia"),
        Costa_Rica("Costa Rica"),
        Cuba("Cuba"),
        Ecuador("Ecuador"),
        El_Salvador("El Salvador"),
        España("España"),
        Estados_Unidos("Estados Unidos"),
        Guatemala("Guatemala"),
        Honduras("Honduras"),
        México("México"),
        Nicaragua("Nicaragua"),
        Panamá("Panamá"),
        Paraguay("Paraguay"),
        Perú("Perú"),
        Venezuela("Venezuela");

        private final String nombre;

        Pais(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }
    }


