/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.modelo;
import com.umg.vista.VistaMetodoMuller;
/**
 *
 * @author sebas
 */
public class ModeloMetodoMuller {
    VistaMetodoMuller vista;

    public ModeloMetodoMuller() {
    }

    public ModeloMetodoMuller(VistaMetodoMuller vista) {
        this.vista = vista;
    }

    public VistaMetodoMuller getVista() {
        return vista;
    }

    public void setVista(VistaMetodoMuller vista) {
        this.vista = vista;
    }
}
