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
public class MetodoSecante {

    public DefaultTableModel calcularSecante(String funcion, double a, double b, double tolerancia) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Iteración", "x0", "x1", "f(x0)", "f(x1)", "x2", "f(x2)", "Tolerancia"});

        int iteracion = 1;
        double x0 = a;  // puedes usar a y b como valores iniciales
        double x1 = b;
        double f0, f1, x2 = 0, f2, error = Double.MAX_VALUE;
        String errorStr;

        do {
            f0 = Math.round(Interprete.evaluate(funcion, x0) * 10000.0) / 10000.0;
            f1 = Math.round(Interprete.evaluate(funcion, x1) * 10000.0) / 10000.0;

            // Validar que no haya división por cero
            if (f1 - f0 == 0) {
                break; // o lanza una excepción si prefieres
            }

            x2 = x1 - f1 * (x1 - x0) / (f1 - f0);
            x2 = Math.round(x2 * 10000.0) / 10000.0;
            f2 = Math.round(Interprete.evaluate(funcion, x2) * 10000.0) / 10000.0;

            errorStr = (iteracion == 1) ? "----------" : String.valueOf(error);
            modelo.addRow(new Object[]{iteracion, x0, x1, f0, f1, x2, f2, errorStr});

            error = Math.round(Math.abs(x2 - x1) * 10000.0) / 10000.0;

            x0 = x1;
            x1 = x2;
            iteracion++;

        } while (error > tolerancia);

        return modelo;

    }
}
