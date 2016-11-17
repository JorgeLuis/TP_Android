package edu.algo3.pois.domain;

import java.util.ArrayList;

/**
 * Created by Laboratorio on 01/11/2016.
 */
public class Banco extends Poi {
    private ArrayList<String> servicios = new ArrayList<String>();

    public Banco(int id) {
        super(id);

        super.setTipo("banco");
    }

    public ArrayList<String> getServicio() {
        return servicios;
    }

    public void setServicio(ArrayList<String> servicio) {
        this.servicios = servicio;
    }




    public void agregarServicio (String unServicio) {
        servicios.add (unServicio);
    }
}
