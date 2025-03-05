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
    
   private FuncionParser parser;

    public MetodoBiseccion() {
        this.parser = new FuncionParser();
    }

    public DefaultTableModel calcularBiseccion(String funcion, double a, double b, double tolerancia) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Iteración", "a", "b", "f(a)", "f(b)", "Xr", "f(Xr)", "Tolerancia"});

        int iteracion = 0;
        double xr, fa, fb, fxr, error = Double.MAX_VALUE;

        do {
            xr = (a + b) / 2;
            fa = parser.evaluar(funcion, a);
            fb = parser.evaluar(funcion, b);
            fxr = parser.evaluar(funcion, xr);

            modelo.addRow(new Object[]{iteracion, a, b, fa, fb, xr, fxr, error});

            if (fa * fxr < 0) {
                b = xr;
            } else {
                a = xr;
            }

            error = Math.abs(b - a);
            iteracion++;

        } while (error > tolerancia);

        return modelo;
    }
}
