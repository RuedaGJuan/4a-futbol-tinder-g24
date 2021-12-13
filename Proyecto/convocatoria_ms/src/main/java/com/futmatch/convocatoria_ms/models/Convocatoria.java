package com.futmatch.convocatoria_ms.models;

import org.springframework.data.annotation.Id;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class Convocatoria{
    @Id
    private String id;
    private ArrayList<Integer> jugEquip1;
    private ArrayList<Integer> jugEquip2;
    private String fecha;
    private String hora;
    private String localidad;


    public Convocatoria(String id, ArrayList<Integer> jugEquip1, ArrayList<Integer> jugEquip2, String fecha,
                        String hora, String localidad) {
        this.id = id;
        this.jugEquip1 = jugEquip1;
        this.jugEquip2 = jugEquip2;
        this.fecha = fecha;
        this.hora = hora;
        this.localidad = localidad;

    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Integer> getJugEquip1() {
        return jugEquip1;
    }

    public void setJugEquip1(ArrayList<Integer> jugEquip1) {
        this.jugEquip1 = jugEquip1;
    }

    public ArrayList<Integer> getJugEquip2() {
        return jugEquip2;
    }

    public void setJugEquip2(ArrayList<Integer> jugEquip2) {
        this.jugEquip2 = jugEquip2;
    }


    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}
