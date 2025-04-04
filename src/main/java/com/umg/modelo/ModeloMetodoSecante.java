/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.modelo;
import com.umg.vista.VistaMetodoSecante;
/**
 *
 * @author sebas
 */
public class ModeloMetodoSecante {
    VistaMetodoSecante vista;

    public ModeloMetodoSecante() {
    }

    public ModeloMetodoSecante(VistaMetodoSecante vista) {
        this.vista = vista;
    }

    public VistaMetodoSecante getVista() {
        return vista;
    }

    public void setVista(VistaMetodoSecante vista) {
        this.vista = vista;
    }
    
}
