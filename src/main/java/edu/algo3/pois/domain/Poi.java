package edu.algo3.pois.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Laboratorio on 01/11/2016.
 */
public class Poi  implements Serializable {


    private int id;
    private String nombre;
    private String direccion;
    private String barrio;
    private int numero;
    private ArrayList<String> diasAtencion;
    private String claves;
    private String tipo;

    public Poi(String tipo, String direccion, String nombre) {
        this.tipo = tipo;
        this.direccion = direccion;
        this.nombre = nombre;
    }


    public Poi (int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getClaves() {
        return claves;
    }

    public void setClaves(String claves) {
        this.claves = claves;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<String> getDiasAtencion() {
        return diasAtencion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    private String categoria;


    public void setDiasAtencion(ArrayList<String> diasAtencion) {
        this.diasAtencion = diasAtencion;
    }
}
