package com.umg.operaciones;

public class ProcesarFuncion {
/*    @Override

    public double evaluarFuncion(double x, String funcion) {

        double respuesta = 0;



        try {

            JEP jep = new JEP();

            jep.addStandardFunctions();

            jep.addStandardConstants();



            jep.addVariable("x", x);

            jep.parseExpression(funcion);



            respuesta = jep.getValue();



        } catch (Exception e) {

            System.out.println("Error" + e.getMessage());

        }



        return respuesta;

    }



    @Override

    public String evaluarDerivada(String funcion) {

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



            Node nodoFuncion = djep.parse(funcion);

            Node diff = djep.differentiate(nodoFuncion, "x");

            Node nodoDerivada = djep.simplify(diff);

            respuesta = djep.toString(nodoDerivada);



        } catch (ParseException e) {

            System.out.println("Error" + e.getErrorInfo());

        }



        return respuesta;

    }*/
}
