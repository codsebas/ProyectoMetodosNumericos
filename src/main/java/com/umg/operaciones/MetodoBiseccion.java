/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.operaciones;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sebas
 */
public class MetodoBiseccion {

    public DefaultTableModel calcularBiseccion(String funcion, double a, double b, double tolerancia) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Iteración", "a", "b", "f(a)", "f(b)", "Xr", "f(Xr)", "Tolerancia"});

        int iteracion = 1;
        double xr, fa, fb, fxr, error = Double.MAX_VALUE;
        String errorStr;
        do {
            xr = (a + b) / 2;
            fa = Math.round(Interprete.evaluate(funcion, a) * 10000.0) / 10000.0;
            fb = Math.round(Interprete.evaluate(funcion, b) * 10000.0) / 10000.0;
            fxr = Math.round(Interprete.evaluate(funcion, xr) * 10000.0) / 10000.0;
            
            errorStr = (iteracion == 1) ? "----------" : String.valueOf(error);
            modelo.addRow(new Object[]{iteracion, a, b, fa, fb, xr, fxr, errorStr});
            
            if (fa * fxr < 0) {
                b = Math.round(xr * 10000.0) / 10000.0;
            } else {
                a = Math.round(xr * 10000.0) / 10000.0;
            }
            
            error = Math.round(Math.abs(b - a) * 10000.0) / 10000.0;
            iteracion++;

        } while (error > tolerancia);

        return modelo;
    }
}
