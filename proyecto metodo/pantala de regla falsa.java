package com.umg.operaciones;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaReglaFalsa {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Método de la Regla Falsa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Crear panel principal
        JPanel panel = new JPanel(new BorderLayout());

        // Crear panel superior para las entradas
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel lblFuncion = new JLabel("Función (en términos de x):");
        JTextField txtFuncion = new JTextField();

        JLabel lblA = new JLabel("Límite a:");
        JTextField txtA = new JTextField();

        JLabel lblB = new JLabel("Límite b:");
        JTextField txtB = new JTextField();

        JLabel lblTolerancia = new JLabel("Tolerancia:");
        JTextField txtTolerancia = new JTextField();

        JButton btnCalcular = new JButton("Calcular");

        inputPanel.add(lblFuncion);
        inputPanel.add(txtFuncion);
        inputPanel.add(lblA);
        inputPanel.add(txtA);
        inputPanel.add(lblB);
        inputPanel.add(txtB);
        inputPanel.add(lblTolerancia);
        inputPanel.add(txtTolerancia);
        inputPanel.add(new JLabel());
        inputPanel.add(btnCalcular);

        panel.add(inputPanel, BorderLayout.NORTH);

        // Crear tabla para mostrar resultados
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new Object[]{"Iteración", "a", "b", "f(a)", "f(b)", "Xr", "f(Xr)", "Tolerancia"});
        JTable table = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Agregar acción al botón
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String funcion = txtFuncion.getText();
                double a = Double.parseDouble(txtA.getText());
                double b = Double.parseDouble(txtB.getText());
                double tolerancia = Double.parseDouble(txtTolerancia.getText());

                MetodoReglaFalsa metodo = new MetodoReglaFalsa();
                DefaultTableModel resultadoModelo = metodo.calcularReglaFalsa(funcion, a, b, tolerancia);

                // Limpiar y actualizar la tabla
                modeloTabla.setRowCount(0);
                for (int i = 0; i < resultadoModelo.getRowCount(); i++) {
                    modeloTabla.addRow(new Object[]{
                        resultadoModelo.getValueAt(i, 0),
                        resultadoModelo.getValueAt(i, 1),
                        resultadoModelo.getValueAt(i, 2),
                        resultadoModelo.getValueAt(i, 3),
                        resultadoModelo.getValueAt(i, 4),
                        resultadoModelo.getValueAt(i, 5),
                        resultadoModelo.getValueAt(i, 6),
                        resultadoModelo.getValueAt(i, 7)
                    });
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
