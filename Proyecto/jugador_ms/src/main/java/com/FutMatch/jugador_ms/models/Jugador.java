package com.FutMatch.jugador_ms.models;

import org.springframework.data.annotation.Id;

public class Jugador {

    @Id
    private String nombre;
    private Integer edad;
    private Integer convJugadas;


    public Jugador(String nombre, Integer edad, Integer convJugadas){
        this.nombre = nombre;
        this.edad = edad;
        this.convJugadas = convJugadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getConvJugadas() {
        return convJugadas;
    }

    public void setConvJugadas(Integer convJugadas) {
        this.convJugadas = convJugadas;
    }
}
