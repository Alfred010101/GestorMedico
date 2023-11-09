/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.awt.AWTKeyStroke;
import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.awt.KeyboardFocusManager;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 *
 * @author admin
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTextField Tab Control");
        JTextField textField1 = new JTextField(20);
        JTextField textField2 = new JTextField(20);
        JTextField textField3 = new JTextField(20);
        JTextField textField4 = new JTextField(15);

        JPanel panel = new JPanel();
        panel.add(textField1);
         panel.add(textField4);
        panel.add(textField2);
        panel.add(textField3);
       
        
        // Deshabilitar las teclas de travesía de foco predeterminadas
        /*textField1.setFocusTraversalKeysEnabled(false);
        textField2.setFocusTraversalKeysEnabled(false);
        textField3.setFocusTraversalKeysEnabled(false);
        textField4.setFocusTraversalKeysEnabled(false);

        // Configurar las teclas de travesía de foco personalizadas
        Set<AWTKeyStroke> forwardKeys = new HashSet<>(1);
        forwardKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0));
        Set<AWTKeyStroke> backwardKeys = new HashSet<>(1);
        backwardKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, InputEvent.SHIFT_DOWN_MASK));

        textField1.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, forwardKeys);
        textField1.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, backwardKeys);

        textField2.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, forwardKeys);
        textField2.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, backwardKeys);

        textField3.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, forwardKeys);
        textField3.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, backwardKeys);

        textField4.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, forwardKeys);
        textField4.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, backwardKeys);

        textField1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    textField3.requestFocusInWindow();
                    e.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        textField3.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    textField4.requestFocusInWindow();
                    e.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        textField4.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    textField3.requestFocusInWindow();
                    e.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });*/

        
        /*FocusTraversalPolicy policy = new FocusTraversalPolicy() {
            @Override
            public Component getComponentAfter(Container aContainer, Component aComponent) {
                System.out.println("SSSS");
                if (aComponent.equals(textField1)) {
                    return textField3;
                } else if (aComponent.equals(textField2)) {
                    return textField4;
                } else if (aComponent.equals(textField3)) {
                    return textField4;
                } else if (aComponent.equals(textField4)) {
                    return textField1;
                }
                return textField1; // Establece textField1 como el siguiente componente por defecto
            }

            @Override
            public Component getComponentBefore(Container aContainer, Component aComponent) {
                if (aComponent.equals(textField1)) {
                    return textField4;
                } else if (aComponent.equals(textField2)) {
                    return textField1;
                } else if (aComponent.equals(textField3)) {
                    return textField1;
                } else if (aComponent.equals(textField4)) {
                    return textField3;
                }
                return textField4; // Establece textField4 como el componente anterior por defecto
            }

            @Override
            public Component getFirstComponent(Container aContainer) {
                return textField1; // Establece textField1 como el primer componente por defecto
            }

            @Override
            public Component getLastComponent(Container aContainer) {
                return textField4; // Establece textField4 como el último componente por defecto
            }

            @Override
            public Component getDefaultComponent(Container aContainer) {
                return textField1; // Establece textField1 como el componente predeterminado
            }
        };
        
        panel.setFocusTraversalPolicy(policy);*/

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
