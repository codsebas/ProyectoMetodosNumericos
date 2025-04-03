
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaInterpolacion {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Método de Interpolación");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10));

        JLabel lblMetodo = new JLabel("Seleccione el método de interpolación:");
        String[] metodos = {"Interpolación Lineal de Newton", "Interpolación de Lagrange"};
        JComboBox<String> comboMetodo = new JComboBox<>(metodos);

        JLabel lblX1 = new JLabel("x1:");
        JTextField txtX1 = new JTextField();
        JLabel lblY1 = new JLabel("y1:");
        JTextField txtY1 = new JTextField();

        JLabel lblX2 = new JLabel("x2/x0:");
        JTextField txtX2 = new JTextField();
        JLabel lblY2 = new JLabel("y2/y0:");
        JTextField txtY2 = new JTextField();

        JLabel lblX = new JLabel("Valor de x a interpolar:");
        JTextField txtX = new JTextField();

        JButton btnCalcular = new JButton("Calcular");
        JLabel lblResultado = new JLabel("Resultado: ");

        panel.add(lblMetodo);
        panel.add(comboMetodo);
        panel.add(lblX1);
        panel.add(txtX1);
        panel.add(lblY1);
        panel.add(txtY1);
        panel.add(lblX2);
        panel.add(txtX2);
        panel.add(lblY2);
        panel.add(txtY2);
        panel.add(lblX);
        panel.add(txtX);
        panel.add(btnCalcular);
        panel.add(lblResultado);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double x1 = Double.parseDouble(txtX1.getText());
                    double y1 = Double.parseDouble(txtY1.getText());
                    double x2 = Double.parseDouble(txtX2.getText());
                    double y2 = Double.parseDouble(txtY2.getText());
                    double x = Double.parseDouble(txtX.getText());

                    double resultado;
                    if (comboMetodo.getSelectedIndex() == 0) {
                        // Método de Newton
                        resultado = ((x - x1) / (x2 - x1)) * (y2 - y1) + y1;
                        lblResultado.setText("Resultado (Newton): " + resultado);
                    } else {
                        // Método de Lagrange
                        resultado = ((x - x2) / (x1 - x2)) * y2 + ((x - x1) / (x2 - x1)) * y1;
                        lblResultado.setText("Resultado (Lagrange): " + resultado);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
