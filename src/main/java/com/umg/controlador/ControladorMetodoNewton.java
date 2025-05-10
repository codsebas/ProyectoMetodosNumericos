package com.umg.controlador;
import com.umg.modelo.ModeloMetodoNewton;
import com.umg.operaciones.MetodoNewton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;


public class ControladorMetodoNewton implements ActionListener, WindowListener {

    ModeloMetodoNewton modelo;
    MetodoNewton metodo;

    public ControladorMetodoNewton(ModeloMetodoNewton modelo) {
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(modelo.getVista().btnCalcular.getActionCommand())){
            if (modelo.getVista().txtFuncion.getText().isEmpty()
                    || modelo.getVista().txtXi.getText().isEmpty()
                    || modelo.getVista().txtTolerancia.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    String funcion = modelo.getVista().txtFuncion.getText();
                    double Xi = Double.parseDouble(modelo.getVista().txtXi.getText());
                    double tolerancia = Double.parseDouble(modelo.getVista().txtTolerancia.getText());

                    modelo.getVista().tblBiseccion.setModel(metodo.calcularNewton(funcion, Xi, tolerancia));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Entrada no válida", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.modelo.getVista().txtXi.setText("0.001");
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
