/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.modelo;
import com.umg.vista.VistaMetodoBiseccion;
/**
 *
 * @author sebas
 */
public class ModeloMetodoBiseccion {
    VistaMetodoBiseccion vista;

    public ModeloMetodoBiseccion() {
    }

    public ModeloMetodoBiseccion(VistaMetodoBiseccion vista) {
        this.vista = vista;
    }

    public VistaMetodoBiseccion getVista() {
        return vista;
    }

    public void setVista(VistaMetodoBiseccion vista) {
        this.vista = vista;
    }
    
}
