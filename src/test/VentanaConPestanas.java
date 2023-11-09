/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author admin
 */public class VentanaConPestanas {
    private static final String PRIMERA_PESTAÑA = "Primera Pestaña";
    private static final String SEGUNDA_PESTAÑA = "Segunda Pestaña";

    private static final Map<String, String> estadoInicial = new HashMap<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana con Pestañas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Primera Pestaña
        JPanel primeraPestanaPanel = new JPanel();
        JTextField textFieldPestana1 = new JTextField(20);
        primeraPestanaPanel.add(textFieldPestana1);
        tabbedPane.addTab(PRIMERA_PESTAÑA, primeraPestanaPanel);
        guardarEstadoInicial(PRIMERA_PESTAÑA, textFieldPestana1);

        // Segunda Pestaña
        JPanel segundaPestanaPanel = new JPanel();
        JTextField textFieldPestana2 = new JTextField(20);
        segundaPestanaPanel.add(textFieldPestana2);
        tabbedPane.addTab(SEGUNDA_PESTAÑA, segundaPestanaPanel);
        guardarEstadoInicial(SEGUNDA_PESTAÑA, textFieldPestana2);

        // Agregar el JTabbedPane al frame
        frame.add(tabbedPane);

        // Configuración del frame
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private static void guardarEstadoInicial(String pestana, JTextField textField) {
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                estadoInicial.put(pestana, textField.getText());
            }
        });
    }

    private static void restaurarEstadoInicial(String pestana, JTextField textField) {
        String estadoGuardado = estadoInicial.get(pestana);
        if (estadoGuardado != null) {
            textField.setText(estadoGuardado);
        } else {
            textField.setText("");
        }
    }
}