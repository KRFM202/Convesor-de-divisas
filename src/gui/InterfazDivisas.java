package gui;

import logica.ConversorMonedas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazDivisas {

    private JPanel Panel01;
    private JTextField tfCantidad;
    private JComboBox cbCambio;
    private JButton convertirButton;
    private JButton limpiarButton;
    private JTextField tfResultado;
    private JButton menuPrincipalButton;
    private JButton salirButton;
    private JLabel conversiónLabel;
    private JLabel eligeLaOpciónDeLabel;
    private JLabel ingresaLaCantidadQueLabel;

    static JFrame frame = new JFrame("Conversor de divisas");

    public InterfazDivisas() {
        ConversorMonedas dolarEuro = new ConversorMonedas(0.92);
        ConversorMonedas dolarPeso = new ConversorMonedas(17.11);
        ConversorMonedas dolarLibra = new ConversorMonedas(0.79);
        ConversorMonedas dolarYen = new ConversorMonedas(145.17);
        ConversorMonedas dolarWon = new ConversorMonedas(1339.33);

        convertirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double resultado = 0;
                String nombreMoneda = "";
                try {
                    double cantidad = Double.parseDouble(tfCantidad.getText());

                    int opcion = cbCambio.getSelectedIndex();
                    switch (opcion) {
                        case 0 -> {
                            resultado = dolarEuro.convertirADivisaExtranjera(cantidad);
                            nombreMoneda = "EUR";
                        }
                        case 1 -> {
                            resultado = dolarPeso.convertirADivisaExtranjera(cantidad);
                            nombreMoneda = "MXN";
                        }
                        case 2 -> {
                            resultado = dolarLibra.convertirADivisaExtranjera(cantidad);
                            nombreMoneda = "GBP";
                        }
                        case 3 -> {
                            resultado = dolarYen.convertirADivisaExtranjera(cantidad);
                            nombreMoneda = "JPY";
                        }
                        case 4 -> {
                            resultado = dolarWon.convertirADivisaExtranjera(cantidad);
                            nombreMoneda = "KRW";
                        }
                        case 5 -> {
                            resultado = dolarEuro.convertirADivisaBase(cantidad);
                            nombreMoneda = "USD";
                        }
                        case 6 -> {
                            resultado = dolarPeso.convertirADivisaBase(cantidad);
                            nombreMoneda = "USD";
                        }
                        case 7 -> {
                            resultado = dolarLibra.convertirADivisaBase(cantidad);
                            nombreMoneda = "USD";
                        }
                        case 8 -> {
                            resultado = dolarYen.convertirADivisaBase(cantidad);
                            nombreMoneda = "USD";
                        }
                        case 9 -> {
                            resultado = dolarWon.convertirADivisaBase(cantidad);
                            nombreMoneda = "USD";
                        }
                    }
                    tfResultado.setText(resultado + " " + nombreMoneda);

                } catch (RuntimeException exception) {
                    JOptionPane.showMessageDialog(frame, "Error, solo se puede ingresar número y sin dejar espacios " +
                            "en blanco.");
                }
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfCantidad.setText("");
                tfResultado.setText("");
            }
        });
        menuPrincipalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                InterfazPrincipal.main(new String[0]);
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
    }

    public static void main(String[] args) {
        frame.setContentPane(new InterfazDivisas().Panel01);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(700, 500);
        frame.setResizable(false);
        // Obtener el tamaño de la pantalla
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        // Calcular las coordenadas para centrar el JFrame
        int x = (screenWidth - frame.getWidth()) / 2;
        int y = (screenHeight - frame.getHeight()) / 2;
        // Establecer la posición centrada
        frame.setLocation(x, y);
        frame.setVisible(true);
    }
}
