package com.FutMatch.jugador_ms.models;

import org.springframework.data.annotation.Id;
import java.util.Date;

public class Jugador {
    @Id
    private String nombre;
    private Date fechaNacimiento;
    private Integer convJugadas;
    private Integer id;

    public Jugador(Integer id, String nombre, Date fechaNacimiento, Integer convJugadas){
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.convJugadas = convJugadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getConvJugadas() {
        return convJugadas;
    }

    public void setConvJugadas(Integer convJugadas) {
        this.convJugadas = convJugadas;
    }

    public Integer getId() {
        return id;
    }

}
