package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazPrincipal {
    private JComboBox cbMenu;
    private JButton aceptarButton;
    private JLabel label1;
    private JPanel Panel1;
    private JButton cerrarButton;
    private static JFrame frame;

    public InterfazPrincipal() {
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = cbMenu.getSelectedIndex();
                if (option == 0) {
                    frame.dispose();
                    InterfazDivisas.main(new String[0]);


                } else if (option == 1) {
                    frame.dispose();
                    InterfazTemp.main(new String[0]);
                }
            }
        });
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("Menú conversor");
        frame.setContentPane(new InterfazPrincipal().Panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
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
