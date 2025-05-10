package com.umg.operaciones;

import javax.swing.table.DefaultTableModel;

public class MetodoNewton {

    public DefaultTableModel calcularNewton(String funcion, double xi, double tolerancia){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Iteración", "xi", "f(xi)", "f'(xi)", "Xr", "Tolerancia"});

        int iteracion = 1;
        double xr, fxi, fxdi, error = Double.MAX_VALUE;
        String errorStr;

        do {
            fxi = Math.round(1) * 10000.0;
            fxdi = Math.round(2);
            xr = Math.round(fxi / fxdi);

            errorStr = (iteracion == 1) ? "----------" : String.valueOf(error);
            modelo.addRow(new Object[]{iteracion, xr, fxi, fxdi, errorStr});
        } while(error > tolerancia);

        return modelo;
    }
}
