/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.operaciones;

import java.util.*;

/**
 *
 * @author sebas
 */
public class Interprete {
    public static double evaluate(String expression, double x) {
        expression = expression.replace("pi", String.valueOf(Math.PI)).replace("e", String.valueOf(Math.E));
        String[] tokens = expression.split(" ");
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();
        
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals("X")) {
                values.push(x);
            } else if (isNumeric(token)) {
                values.push(Double.parseDouble(token));
            } else if (token.equals("+")) {
                operators.push('+');
            } else if (token.equals("-")) {
                operators.push('-');
            } else if (token.equals("*")) {
                operators.push('*');
            } else if (token.equals("/")) {
                operators.push('/');
            } else if (token.contains("^")) {
                String[] parts = token.split("\\^");
                if (parts.length == 2) {
                    double base = parts[0].equals("X") ? x : (isNumeric(parts[0]) ? Double.parseDouble(parts[0]) : 0);
                    double exponent = parts[1].equals("X") ? x : (isNumeric(parts[1]) ? Double.parseDouble(parts[1]) : 0);
                    values.push(Math.pow(base, exponent));
                } else {
                    throw new IllegalArgumentException("Formato incorrecto en la expresión de exponente: " + token);
                }
            }
        }
        
        while (!operators.isEmpty()) {
            double b = values.pop();
            double a = values.pop();
            char op = operators.pop();
            values.push(applyOp(a, b, op));
        }
        
        return values.pop();
    }
    
    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private static double applyOp(double a, double b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
            default: throw new UnsupportedOperationException("Operador no soportado: " + op);
        }
    }
}
