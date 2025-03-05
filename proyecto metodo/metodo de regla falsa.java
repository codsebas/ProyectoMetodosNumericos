package com.umg.operaciones;

import javax.swing.table.DefaultTableModel;

public class MetodoReglaFalsa {

    public DefaultTableModel calcularReglaFalsa(String funcion, double a, double b, double tolerancia) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Iteración", "a", "b", "f(a)", "f(b)", "Xr", "f(Xr)", "Tolerancia"});

        int iteracion = 1;
        double xr, fa, fb, fxr, error = Double.MAX_VALUE;
        String errorStr;

        do {
            // Evaluar f(a) y f(b)
            fa = Math.round(Interprete.evaluate(funcion, a) * 10000.0) / 10000.0;
            fb = Math.round(Interprete.evaluate(funcion, b) * 10000.0) / 10000.0;

            // Aplicar fórmula de la Regla Falsa
            xr = (a * fb - b * fa) / (fb - fa);
            fxr = Math.round(Interprete.evaluate(funcion, xr) * 10000.0) / 10000.0;

            errorStr = (iteracion == 1) ? "----------" : String.valueOf(error);
            modelo.addRow(new Object[]{iteracion, a, b, fa, fb, xr, fxr, errorStr});

            // Verificar en qué subintervalo se encuentra la raíz
            if (fa * fxr < 0) {
                b = xr;
            } else {
                a = xr;
            }

            // Calcular error
            error = Math.round(Math.abs(b - a) * 10000.0) / 10000.0;
            iteracion++;

        } while (error > tolerancia);

        return modelo;
    }
}

