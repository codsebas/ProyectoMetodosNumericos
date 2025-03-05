/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.operaciones;

/**
 *
 * @author sebas
 */
public class Evaluador {
     public double evaluar(String expresion) {
        return calcular(expresion);
    }

    private double calcular(String expresion) {
        expresion = expresion.replace(" ", ""); // Eliminar espacios
        return evaluarInterno(expresion);
    }

    private double evaluarInterno(String exp) {
        if (exp.contains("+")) {
            String[] partes = exp.split("\\+");
            return evaluarInterno(partes[0]) + evaluarInterno(partes[1]);
        }
        if (exp.contains("-")) {
            String[] partes = exp.split("(?<=\\d)-(?=\\d)"); // Evita conflictos con negativos
            return evaluarInterno(partes[0]) - evaluarInterno(partes[1]);
        }
        if (exp.contains("*")) {
            String[] partes = exp.split("\\*");
            return evaluarInterno(partes[0]) * evaluarInterno(partes[1]);
        }
        if (exp.contains("/")) {
            String[] partes = exp.split("/");
            return evaluarInterno(partes[0]) / evaluarInterno(partes[1]);
        }
        if (exp.contains("^")) {
            String[] partes = exp.split("\\^");
            return Math.pow(evaluarInterno(partes[0]), evaluarInterno(partes[1]));
        }
        return Double.parseDouble(exp);
    }
}
