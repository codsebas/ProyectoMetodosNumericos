/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.controlador;
import com.umg.modelo.ModeloMetodoBiseccion;
import com.umg.operaciones.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class ControladorMetodoBiseccion implements ActionListener, WindowListener{
    ModeloMetodoBiseccion modelo;

    public ControladorMetodoBiseccion(ModeloMetodoBiseccion modelo) {
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(modelo.getVista().btnCalcular.getActionCommand())){
            if(modelo.getVista().txtFuncion.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Campo de función no puede estar vacío", "Campo requerido", JOptionPane.WARNING_MESSAGE);
            } else {
                InterpreteFunciones interprete = new InterpreteFunciones();
            }
        } else {
            
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
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
