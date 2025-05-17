/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.operaciones;

import java.util.*;
import org.nfunk.jep.JEP;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

/**
 *
 * @author sebas
 */
public class Interprete {
    public static double evaluatec(String expression, double x) {
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

    public static double evaluate(String expression, double x) {
        double respuesta = 0;

        try {
            JEP jep = new JEP();
            jep.addStandardFunctions();
            jep.addStandardConstants();

            jep.addVariable("x", x);
            jep.parseExpression(expression);

            respuesta = jep.getValue();

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

        return respuesta;
    }

    public static String evaluateDerivada(String expression) {
        String respuesta = "";

        try {
            DJep djep = new DJep();
            djep.addStandardFunctions();
            djep.addStandardConstants();
            djep.addComplex();
            djep.setAllowUndeclared(true);
            djep.setAllowAssignment(true);
            djep.setImplicitMul(true);
            djep.addStandardDiffRules();

            Node nodoFuncion = djep.parse(expression);
            Node diff = djep.differentiate(nodoFuncion, "x");
            Node nodoDerivada = djep.simplify(diff);
            respuesta = djep.toString(nodoDerivada);

        } catch (ParseException e) {
            System.out.println("Error" + e.getErrorInfo());
        }

        return respuesta;
    }
}
