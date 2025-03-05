
import java.util.Scanner;

public class Interpolation {

    // Método para interpolación lineal de Newton
    public static double newtonLinearInterpolation(double x1, double y1, double x2, double y2, double x) {
        return ((x - x1) / (x2 - x1)) * (y2 - y1) + y1;
    }

    // Método para interpolación de Lagrange de primer grado
    public static double lagrangeInterpolation(double x0, double y0, double x1, double y1, double x) {
        return ((x - x1) / (x0 - x1)) * y0 + ((x - x0) / (x1 - x0)) * y1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el método de interpolación: ");
        System.out.println("1. Interpolación Lineal de Newton");
        System.out.println("2. Interpolación de Lagrange de primer grado");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Ingrese los valores de x1, y1, x2, y2 y el valor de x a interpolar:");
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            double x2 = scanner.nextDouble();
            double y2 = scanner.nextDouble();
            double x = scanner.nextDouble();

            double result = newtonLinearInterpolation(x1, y1, x2, y2, x);
            System.out.println("Valor interpolado usando Newton: " + result);
        } else if (choice == 2) {
            System.out.println("Ingrese los valores de x0, y0, x1, y1 y el valor de x a interpolar:");
            double x0 = scanner.nextDouble();
            double y0 = scanner.nextDouble();
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            double x = scanner.nextDouble();

            double result = lagrangeInterpolation(x0, y0, x1, y1, x);
            System.out.println("Valor interpolado usando Lagrange: " + result);
        } else {
            System.out.println("Opción no válida");
        }

        scanner.close();
    }
}
