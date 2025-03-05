/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.operaciones;

/**
 *
 * @author sebas
 */
public class FuncionParser {
    public double evaluar(String expresion, double x) {
        expresion = expresion.replace("x", "(" + x + ")");
        expresion = expresion.replace("pi", String.valueOf(Math.PI));
        expresion = expresion.replace("e", String.valueOf(Math.E));

        return evaluarExpresion(expresion);
    }

    private double evaluarExpresion(String expresion) {
        // Implementación de un simple evaluador de expresiones
        try {
            return new Evaluador().evaluar(expresion);
        } catch (Exception e) {
            throw new IllegalArgumentException("Expresión no válida");
        }
    }
}
