/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author admin
 */
public class GridBagL extends JFrame
{
    public GridBagL()
    {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GridBagLayout Example");

        // Crear un panel y establecer GridBagLayout como su layout manager
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Primer componente: JLabel en la primera fila, primera columna
        JLabel label1 = new JLabel("Componente 1");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        panel.add(label1, gbc);

        // Segundo componente: JTextField en la primera fila, segunda columna
        JTextField textField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(textField, gbc);

        // Tercer componente: JButton en la segunda fila, primera columna
        JButton button = new JButton("Componente 3");
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Este componente ocupa 2 columnas
        panel.add(button, gbc);

        // Agregar el panel al JFrame
        getContentPane().add(panel);

        pack(); // Ajusta automáticamente el tamaño del JFrame según los componentes
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GridBagL();
        });
    }
}