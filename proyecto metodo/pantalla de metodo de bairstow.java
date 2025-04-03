package com.umg.operaciones;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BairstowGUI extends JFrame {
    private JTextField coefField, rField, sField, tolField, iterField;
    private JTable table;
    private DefaultTableModel model;
    
    public BairstowGUI() {
        setTitle("Método de Bairstow");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(new JLabel("Coeficientes (separados por comas):"));
        coefField = new JTextField();
        panel.add(coefField);
        
        panel.add(new JLabel("Valor inicial de r:"));
        rField = new JTextField("1.0");
        panel.add(rField);
        
        panel.add(new JLabel("Valor inicial de s:"));
        sField = new JTextField("1.0");
        panel.add(sField);
        
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
                calcularBairstow();
            }
        });
    }
    
    private void calcularBairstow() {
        try {
            String[] coefStr = coefField.getText().split(",");
            double[] coeficientes = new double[coefStr.length];
            for (int i = 0; i < coefStr.length; i++) {
                coeficientes[i] = Double.parseDouble(coefStr[i].trim());
            }
            
            double r = Double.parseDouble(rField.getText());
            double s = Double.parseDouble(sField.getText());
            double tolerancia = Double.parseDouble(tolField.getText());
            int iterMax = Integer.parseInt(iterField.getText());
            
            MetodoBairstow metodo = new MetodoBairstow();
            DefaultTableModel resultado = metodo.calcularBairstow(coeficientes, r, s, tolerancia, iterMax);
            table.setModel(resultado);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos ingresados.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BairstowGUI().setVisible(true));
    }
}
