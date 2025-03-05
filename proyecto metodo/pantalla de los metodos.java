package com.umg.operaciones;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazMetodos extends JFrame {

    private JComboBox<String> metodoComboBox;
    private JTextField funcionField, aField, bField, toleranciaField;
    private JButton calcularButton;
    private JTable resultadoTable;
    private DefaultTableModel modeloTabla;

    public InterfazMetodos() {
        setTitle("Métodos Numéricos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel Superior
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new GridLayout(3, 2, 5, 5));

        panelSuperior.add(new JLabel("Seleccione el método:"));
        metodoComboBox = new JComboBox<>(new String[]{
                "Bisección",
                "Regla Falsa",
                "Secante",
                "Interpolación",
                "Bairstow"
        });
        panelSuperior.add(metodoComboBox);

        panelSuperior.add(new JLabel("Función o Coeficientes:"));
        funcionField = new JTextField();
        panelSuperior.add(funcionField);

        panelSuperior.add(new JLabel("Intervalo / Valores iniciales (a, b):"));
        aField = new JTextField();
        bField = new JTextField();
        JPanel intervalPanel = new JPanel(new GridLayout(1, 2));
        intervalPanel.add(aField);
        intervalPanel.add(bField);
        panelSuperior.add(intervalPanel);

        panelSuperior.add(new JLabel("Tolerancia:"));
        toleranciaField = new JTextField("0.0001");
        panelSuperior.add(toleranciaField);

        add(panelSuperior, BorderLayout.NORTH);

        // Botón Calcular
        calcularButton = new JButton("Calcular");
        add(calcularButton, BorderLayout.CENTER);

        // Tabla de Resultados
        modeloTabla = new DefaultTableModel();
        resultadoTable = new JTable(modeloTabla);
        add(new JScrollPane(resultadoTable), BorderLayout.SOUTH);

        // Acción del botón
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarMetodo();
            }
        });
    }

    private void ejecutarMetodo() {
        String metodo = (String) metodoComboBox.getSelectedItem();
        String funcion = funcionField.getText();
        double a = Double.parseDouble(aField.getText());
        double b = Double.parseDouble(bField.getText());
        double tolerancia = Double.parseDouble(toleranciaField.getText());

        DefaultTableModel resultado = null;

        switch (metodo) {
            case "Bisección":
                resultado = new MetodoBiseccion().calcularBiseccion(funcion, a, b, tolerancia);
                break;
            case "Regla Falsa":
                resultado = new MetodoReglaFalsa().calcularReglaFalsa(funcion, a, b, tolerancia);
                break;
            case "Secante":
                resultado = new MetodoSecante().calcularSecante(funcion, a, b, tolerancia);
                break;
            case "Interpolación":
                resultado = new MetodoInterpolacion().calcularInterpolacion(funcion, a, b, tolerancia);
                break;
            case "Bairstow":
                double[] coeficientes = parsearCoeficientes(funcion);
                resultado = new MetodoBairstow().calcularBairstow(coeficientes, a, b, tolerancia, 100);
                break;
        }

        resultadoTable.setModel(resultado);
    }

    private double[] parsearCoeficientes(String coefStr) {
        String[] partes = coefStr.split(",");
        double[] coeficientes = new double[partes.length];
        for (int i = 0; i < partes.length; i++) {
            coeficientes[i] = Double.parseDouble(partes[i].trim());
        }
        return coeficientes;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfazMetodos interfaz = new InterfazMetodos();
            interfaz.setVisible(true);
        });
    }
}
