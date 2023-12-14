package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelGrafico {

    JFrame frame = new JFrame("SERVIDOR");
    JPanel panel = new JPanel();
    JLabel labelCodigoCorreto = new JLabel("Código correto:");
    JTextField inputFieldCodigoCorreto = new JTextField(10);

    JLabel labelCodigoRecebido = new JLabel("Código recebido:");
    JTextField inputFieldCodigoRecebido = new JTextField(10);


    public PainelGrafico() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 500);
        frame.setLocationRelativeTo(null);

        panel.setLayout(new GridLayout(6, 2));

        labelCodigoRecebido.setFont(new Font("Arial", Font.PLAIN, 30));
        inputFieldCodigoRecebido.setFont(new Font("Arial", Font.PLAIN, 30));

        labelCodigoCorreto.setFont(new Font("Arial", Font.PLAIN, 30));
        inputFieldCodigoCorreto.setFont(new Font("Arial", Font.PLAIN, 30));


        panel.add(labelCodigoCorreto);
        panel.add(inputFieldCodigoCorreto);
        panel.add(labelCodigoRecebido);
        panel.add(inputFieldCodigoRecebido);

        String buttonLabel = "Sair";

        JButton button = new JButton(buttonLabel);
        button.setFont(new Font("Arial", Font.PLAIN, 30));
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
