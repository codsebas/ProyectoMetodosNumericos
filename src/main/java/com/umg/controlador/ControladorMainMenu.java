/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.controlador;
import com.umg.modelo.ModeloMainMenu;
import com.umg.vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
*
 * @author sebas
 */
public class ControladorMainMenu implements ActionListener{
    
    ModeloMainMenu modelo;

    public ControladorMainMenu(ModeloMainMenu modelo) {
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(modelo.getVista().btnBiseccion.getActionCommand())){
            modelo.getVista().setVisible(false);
            VistaMetodoBiseccion metodo = new VistaMetodoBiseccion();
            metodo.setLocationRelativeTo(null);
            metodo.setVisible(true);
        } else if(e.getActionCommand().equals(modelo.getVista().btnSecante.getActionCommand())){
            modelo.getVista().setVisible(false);
            VistaMetodoSecante metodo = new VistaMetodoSecante();
            metodo.setLocationRelativeTo(null);
            metodo.setVisible(true);
        }
    }
}
