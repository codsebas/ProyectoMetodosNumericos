/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.controlador;

import com.umg.modelo.ModeloMetodoSecante;
import com.umg.operaciones.MetodoSecante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class ControladorMetodoSecante implements ActionListener, WindowListener {

    ModeloMetodoSecante modelo;
    MetodoSecante metodo = new MetodoSecante();

    public ControladorMetodoSecante(ModeloMetodoSecante modelo) {
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(modelo.getVista().btnCalcular.getActionCommand())) {
            if (modelo.getVista().txtFuncion.getText().isEmpty()
                    || modelo.getVista().txtIntervalo.getText().isEmpty()
                    || modelo.getVista().txtTolerancia.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    String funcion = modelo.getVista().txtFuncion.getText();
                    String[] intervalo = modelo.getVista().txtIntervalo.getText().split(",");
                    double a = Double.parseDouble(intervalo[0]);
                    double b = Double.parseDouble(intervalo[1]);
                    double tolerancia = Double.parseDouble(modelo.getVista().txtTolerancia.getText());

                    modelo.getVista().tblSecante.setModel(metodo.calcularSecante(funcion, a, b, tolerancia));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Entrada no válida", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.modelo.getVista().txtTolerancia.setText("0.001");
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
