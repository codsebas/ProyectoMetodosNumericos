/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.modelo;

import com.umg.vista.MainMenu;

/**
 *
 * @author sebas
 */
public class ModeloMainMenu {
    private MainMenu vista;

    public ModeloMainMenu() {
    }

    public ModeloMainMenu(MainMenu vista) {
        this.vista = vista;
    }

    public MainMenu getVista() {
        return vista;
    }

    public void setVista(MainMenu vista) {
        this.vista = vista;
    }
}
