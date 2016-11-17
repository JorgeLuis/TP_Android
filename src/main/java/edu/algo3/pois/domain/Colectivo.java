package edu.algo3.pois.domain;

/**
 * Created by Laboratorio on 01/11/2016.
 */
public class Colectivo extends Poi {
    private String nombre;
    private int cantParadas;

    public Colectivo(int id) {
        super(id);
        super.setTipo("colectivo");
    }


    public int getCantParadas() {
        return cantParadas;
    }

    public void setCantParadas(int cantParadas) {
        this.cantParadas = cantParadas;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre (String nombre) {
        this. nombre = nombre;
    }




    }

