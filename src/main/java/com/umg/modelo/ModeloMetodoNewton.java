package com.umg.modelo;
import com.umg.vista.VistaMetodoNewton;

public class ModeloMetodoNewton {
    VistaMetodoNewton vista;

    public ModeloMetodoNewton() {
    }

    public ModeloMetodoNewton(VistaMetodoNewton vista) {
        this.vista = vista;
    }

    public VistaMetodoNewton getVista() {
        return vista;
    }

    public void setVista(VistaMetodoNewton vista) {
        this.vista = vista;
    }
}
