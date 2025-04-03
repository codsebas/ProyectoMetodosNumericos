package com.umg.operaciones;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecanteGUI extends JFrame {

    private JTextField funcionField, x0Field, x1Field, tolField, iterField;
    private JTable table;
    private DefaultTableModel model;

    public SecanteGUI() {
        setTitle("Método de la Secante");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(new JLabel("Función f(x):"));
        funcionField = new JTextField();
        panel.add(funcionField);

        panel.add(new JLabel("Valor inicial x0:"));
        x0Field = new JTextField("1.0");
        panel.add(x0Field);

        panel.add(new JLabel("Valor inicial x1:"));
        x1Field = new JTextField("2.0");
        panel.add(x1Field);

        panel.add(new JLabel("Tolerancia:"));
        tolField = new JTextField("0.0001");
        panel.add(tolField);

        panel.add(new JLabel("Iteraciones máximas:"));
        iterField = new JTextField("100");
        panel.add(iterField);

        JButton calcularBtn = new JButton("Calcular");
        panel.add(calcularBtn);

        add(panel, BorderLayout.NORTH);

        model = new DefaultTableModel();
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        calcularBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularSecante();
            }
        });
    }

    private void calcularSecante() {
        try {
            String funcion = funcionField.getText();
            double x0 = Double.parseDouble(x0Field.getText());
            double x1 = Double.parseDouble(x1Field.getText());
            double tolerancia = Double.parseDouble(tolField.getText());
            int iterMax = Integer.parseInt(iterField.getText());

            MetodoSecante metodo = new MetodoSecante();
            DefaultTableModel resultado = metodo.calcularSecante(funcion, x0, x1, tolerancia, iterMax);
            table.setModel(resultado);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos ingresados.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SecanteGUI().setVisible(true));
    }
}
