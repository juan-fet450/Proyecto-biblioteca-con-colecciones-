/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Juan Osorio
 */
public class Conductor {
    
    private String nombre;
    private String telefono;
    private String cedula;

    public Conductor(String nombre, String telefono, String cedula) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Conductor{" + "nombre=" + nombre + ", telefono=" + telefono + ", cedula=" + cedula + '}';
    }
    
    
}
