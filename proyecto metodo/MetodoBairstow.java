package com.umg.operaciones;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class MetodoBairstow {

    public DefaultTableModel calcularBairstow(double[] coeficientes, double r, double s, double tolerancia, int iterMax) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Iteración", "r", "s", "Δr", "Δs", "Error"});

        List<Double> raices = new ArrayList<>();
        int n = coeficientes.length - 1;
        double[] b = new double[n + 1];
        double[] c = new double[n + 1];
        int iter = 1;

        while (n >= 3) {
            double error = Double.MAX_VALUE;

            for (int i = 0; i < iterMax && error > tolerancia; i++) {
                // Calcular b (coeficientes del cociente)
                b[n] = coeficientes[n];
                b[n - 1] = coeficientes[n - 1] + r * b[n];

                for (int j = n - 2; j >= 0; j--) {
                    b[j] = coeficientes[j] + r * b[j + 1] + s * b[j + 2];
                }

                // Calcular c (coeficientes del derivado)
                c[n] = b[n];
                c[n - 1] = b[n - 1] + r * c[n];

                for (int j = n - 2; j >= 0; j--) {
                    c[j] = b[j] + r * c[j + 1] + s * c[j + 2];
                }

                // Determinante de la matriz Jacobiana
                double det = c[2] * c[2] - c[3] * c[1];
                double dr = (-b[1] * c[2] + b[0] * c[3]) / det;
                double ds = (-b[0] * c[2] + b[1] * c[1]) / det;

                r += dr;
                s += ds;
                error = Math.sqrt(dr * dr + ds * ds);

                modelo.addRow(new Object[]{iter, r, s, dr, ds, error});
                iter++;
            }

            // Calcular raíces del polinomio cuadrático
            double discriminante = r * r + 4 * s;
            if (discriminante >= 0) {
                double x1 = (-r + Math.sqrt(discriminante)) / 2;
                double x2 = (-r - Math.sqrt(discriminante)) / 2;
                raices.add(x1);
                raices.add(x2);
            } else {
                double real = -r / 2;
                double imag = Math.sqrt(-discriminante) / 2;
                raices.add(real);
                raices.add(imag);
            }

            // Reducir el polinomio
            coeficientes = new double[n - 1];
            System.arraycopy(b, 2, coeficientes, 0, n - 1);
            n -= 2;
        }

        // Si queda un polinomio de grado 1, obtener la raíz final
        if (n == 2) {
            raices.add(-coeficientes[1] / coeficientes[0]);
        }

        // Mostrar raíces
        for (int i = 0; i < raices.size(); i++) {
            modelo.addRow(new Object[]{"Raíz " + (i + 1), raices.get(i), "", "", "", ""});
        }

        return modelo;
    }
}
