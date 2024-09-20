/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.teatro;

/**
 *
 * @author EXITOPC
 */
public class Nodossimple {

    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the nboletas
     */
    public int getNboletas() {
        return nboletas;
    }

    /**
     * @param nboletas the nboletas to set
     */
    public void setNboletas(int nboletas) {
        this.nboletas = nboletas;
    }

    /**
     * @return the siguiente
     */
    public Nodossimple getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Nodossimple siguiente) {
        this.siguiente = siguiente;
    }
    
    
    private String documento;    
    private String nombre;    
    private String genero;    
    private int nboletas;
    
    private Nodossimple siguiente;
    
    
}
