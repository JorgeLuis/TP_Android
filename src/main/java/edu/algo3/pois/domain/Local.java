package edu.algo3.pois.domain;

import java.util.ArrayList;

/**
 * Created by Laboratorio on 01/11/2016.
 */
public class Local extends Poi {
    private String categoria;

    public ArrayList<String> getPalabrasClaves() {
        return palabrasClaves;
    }

    private ArrayList<String> palabrasClaves= new ArrayList<String>();

    public Local(int id) {
        super(id);
        super.setTipo("local");
    }

    public String getCategoria () {
        return categoria;
    }

    public void setCategoria (String categoria) {
        this. categoria = categoria;
    }


    public void agregarPalabrasClaves(String clave) {
        palabrasClaves.add(clave);
    }
}
