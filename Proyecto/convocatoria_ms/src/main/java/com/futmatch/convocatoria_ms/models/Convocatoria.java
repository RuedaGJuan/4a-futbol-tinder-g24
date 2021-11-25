package com.futmatch.convocatoria_ms.models;

import org.springframework.data.annotation.Id;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class Convocatoria{
    @Id
    private String id;
    private ArrayList<String> jugEquip1;
    private ArrayList<String> jugEquip2;
    private LocalDate fecha;
    private LocalTime hora;
    private String localidad;
    private ArrayList<String> posiciones;

    public Convocatoria(String id, ArrayList<String> jugEquip1, ArrayList<String> jugEquip2, LocalDate fecha, LocalTime hora, String localidad, ArrayList<String> posiciones) {
        this.id = id;
        this.jugEquip1 = jugEquip1;
        this.jugEquip2 = jugEquip2;
        this.fecha = fecha;
        this.hora = hora;
        this.localidad = localidad;
        this.posiciones = posiciones;
    }

    public String getId() {
        return id;
    }

    public ArrayList<String> getJugEquip1() {
        return jugEquip1;
    }

    public ArrayList<String> getJugEquip2() {
        return jugEquip2;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getLocalidad() {
        return localidad;
    }

    public ArrayList<String> getPosiciones() {
        return posiciones;
    }

    public void setJugEquip1(ArrayList<String> jugEquip1) {
        this.jugEquip1 = jugEquip1;
    }

    public void setJugEquip2(ArrayList<String> jugEquip2) {
        this.jugEquip2 = jugEquip2;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setPosiciones(ArrayList<String> posiciones) {
        this.posiciones = posiciones;
    }
}
