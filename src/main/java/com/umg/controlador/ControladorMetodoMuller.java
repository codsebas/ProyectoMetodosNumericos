package com.umg.controlador;

import com.umg.modelo.ModeloMetodoMuller;
import com.umg.operaciones.MetodoMuller;
import com.umg.operaciones.MetodoNewton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class ControladorMetodoMuller implements ActionListener, WindowListener {

    ModeloMetodoMuller modelo;
    MetodoMuller metodo;

    public ControladorMetodoMuller(ModeloMetodoMuller modelo) {
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(modelo.getVista().btnCalcular.getActionCommand())){
            if (modelo.getVista().txtFuncion.getText().isEmpty()
                    || modelo.getVista().txtX0.getText().isEmpty()
                    || modelo.getVista().txtX1.getText().isEmpty()
                    || modelo.getVista().txtX2.getText().isEmpty()
                    || modelo.getVista().txtTolerancia.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    String funcion = modelo.getVista().txtFuncion.getText();
                    double x0 = Double.parseDouble(modelo.getVista().txtX0.getText());
                    double x1 = Double.parseDouble(modelo.getVista().txtX1.getText());
                    double x2 = Double.parseDouble(modelo.getVista().txtX2.getText());
                    double tolerancia = Double.parseDouble(modelo.getVista().txtTolerancia.getText());

                    //modelo.getVista().tblBiseccion.setModel(metodo.calcularBiseccion(funcion, a, b, tolerancia));

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
