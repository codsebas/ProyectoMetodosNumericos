package com.umg.operaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        setTitle("Menú de Métodos Numéricos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        JButton btnSecante = new JButton("Método de la Secante");
        JButton btnReglaFalsa = new JButton("Método de la Regla Falsa");
        JButton btnBairstow = new JButton("Método de Bairstow");
        JButton btnInterpolacion = new JButton("Método de Interpolación");
        JButton btnSalir = new JButton("Salir");

        panel.add(btnSecante);
        panel.add(btnReglaFalsa);
        panel.add(btnBairstow);
        panel.add(btnInterpolacion);
        panel.add(btnSalir);

        add(panel);

        btnSecante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SecanteGUI secanteGUI = new SecanteGUI();
                secanteGUI.setVisible(true);
            }
        });

        btnReglaFalsa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PantallaReglaFalsa reglaFalsaGUI = new PantallaReglaFalsa();
                reglaFalsaGUI.setVisible(true);
            }
        });

        btnBairstow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BairstowGUI bairstowGUI = new BairstowGUI();
                bairstowGUI.setVisible(true);
            }
        });

        btnInterpolacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PantallaInterpolacion interpolacionGUI = new PantallaInterpolacion();
                interpolacionGUI.setVisible(true);
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuPrincipal().setVisible(true));
    }
}
