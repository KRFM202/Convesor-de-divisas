package gui;

import logica.ConversorTemperatura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazTemp {
    private JPanel Panel01;
    private JTextField txtValor;
    private JComboBox cbOpcion;
    private JButton convertirButton;
    private JTextField txtResultado;
    private JButton limpiarButton;
    private JButton menuPrincipalButton;
    private JButton salirButton;
    private static JFrame frame = new JFrame("Conversor de temperatura");

    public InterfazTemp() {

        ConversorTemperatura conversorTemperatura = new ConversorTemperatura();

        convertirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    double valor = Double.parseDouble(txtValor.getText());

                    String nombreTemp = "";

                    int opcion = cbOpcion.getSelectedIndex();

                    switch (opcion) {
                        case 0:
                            conversorTemperatura.convertirAKevin(valor);
                            nombreTemp = "° K";
                            break;
                        case 1:
                            conversorTemperatura.convertirAFahren(valor);
                            nombreTemp = "° F";
                            break;
                        case 2:
                            conversorTemperatura.pasarDeKelvin(valor);
                            nombreTemp = "° C";
                            break;
                        case 3:
                            conversorTemperatura.pasarDeFahren(valor);
                            nombreTemp = "° C";
                            break;
                    }

                    txtResultado.setText(String.valueOf(conversorTemperatura.getResultado()) + nombreTemp);

                } catch (RuntimeException Ex) {
                    JOptionPane.showMessageDialog(frame, "Error, solo se permite el ingreso de números");
                }
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultado.setText("");
                txtValor.setText("");
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
        frame.setContentPane(new InterfazTemp().Panel01);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 500);
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
