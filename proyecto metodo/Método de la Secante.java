package com.umg.operaciones;

import javax.swing.table.DefaultTableModel;

public class MetodoSecante {

    public DefaultTableModel calcularSecante(String funcion, double x0, double x1, double tolerancia, int maxIteraciones) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Iteración", "x0", "x1", "f(x0)", "f(x1)", "x2", "f(x2)", "Error"});

        int iteracion = 1;
        double x2, fx0, fx1, fx2, error = Double.MAX_VALUE;
        String errorStr;

        do {
            fx0 = Math.round(Interprete.evaluate(funcion, x0) * 10000.0) / 10000.0;
            fx1 = Math.round(Interprete.evaluate(funcion, x1) * 10000.0) / 10000.0;

            // Aplicamos la fórmula de la secante
            x2 = x1 - ((fx1 * (x1 - x0)) / (fx1 - fx0));
            fx2 = Math.round(Interprete.evaluate(funcion, x2) * 10000.0) / 10000.0;

            errorStr = (iteracion == 1) ? "----------" : String.valueOf(error);
            modelo.addRow(new Object[]{iteracion, x0, x1, fx0, fx1, x2, fx2, errorStr});

            // Calcular el error
            error = Math.round(Math.abs(x2 - x1) * 10000.0) / 10000.0;

            // Desplazar los valores para la siguiente iteración
            x0 = x1;
            x1 = x2;
            iteracion++;

        } while (error > tolerancia && iteracion <= maxIteraciones);

        return modelo;
    }
}
