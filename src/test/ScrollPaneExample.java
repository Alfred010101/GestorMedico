/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 *
 * @author admin
 */
public class ScrollPaneExample {
//    public static void main(String[] args) {
//        // Crear un JFrame
//        JFrame frame = new JFrame("Scroll Pane Example");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(300, 200);
//
//        // Crear un JPanel con BoxLayout vertical
//        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//
//        // Agregar componentes al JPanel (hacia abajo)
//        for (int i = 0; i < 20; i++) {
//            JButton button = new JButton("Botón " + (i + 1));
//            panel.add(button);
//        }
//
//        // Crear un JScrollPane y agregar el JPanel al JScrollPane
//        JScrollPane scrollPane = new JScrollPane(panel);
//
//        // Configurar las políticas de desplazamiento
//        //scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//
//        // Agregar el JScrollPane al JFrame
//        frame.getContentPane().add(scrollPane);
//
//        // Hacer visible el JFrame
//        frame.setVisible(true);
//    }
//     public static void main(String[] args) {
//        // Crear un JFrame
//        JFrame frame = new JFrame("TabbedPane with ScrollPane Example");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400, 300);
//
//        // Crear un JTabbedPane
//        JTabbedPane tabbedPane = new JTabbedPane();
//
//        // Crear un JPanel para la primera pestaña con un JTextArea dentro de un JScrollPane
//        JPanel panel1 = new JPanel();
//        JTextArea textArea = new JTextArea(10, 30);
//        JScrollPane scrollPane = new JScrollPane(textArea);
//        panel1.add(scrollPane);
//
//        // Agregar la primera pestaña al JTabbedPane
//        tabbedPane.addTab("Pestaña 1", null, panel1, "Contenido de la pestaña 1");
//
//        // Crear un JPanel para la segunda pestaña (sin JScrollPane)
//        JPanel panel2 = new JPanel();
//        panel2.add(new JLabel("Contenido de la pestaña 2"));
//
//        // Agregar la segunda pestaña al JTabbedPane
//        tabbedPane.addTab("Pestaña 2", null, panel2, "Contenido de la pestaña 2");
//
//        // Agregar el JTabbedPane al JFrame
//        frame.getContentPane().add(tabbedPane);
//
//        // Hacer visible el JFrame
//        frame.setVisible(true);
//    }
    public static void main(String[] args) {
        // Crear un JFrame
        JFrame frame = new JFrame("TabbedPane with ScrollPane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Crear un JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Crear un JPanel para la primera pestaña con un BoxLayout orientado verticalmente y un JScrollPane
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        JScrollPane scrollPane1 = new JScrollPane(panel1);

        // Agregar componentes al JPanel de la primera pestaña
        for (int i = 1; i <= 20; i++) {
            panel1.add(new JLabel("Componente " + i));
        }

        // Agregar el JScrollPane a la primera pestaña del JTabbedPane
        tabbedPane.addTab("Pestaña 1", null, scrollPane1, "Contenido de la pestaña 1");

        // Crear un JPanel para la segunda pestaña con un BoxLayout orientado verticalmente y un JScrollPane
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        JScrollPane scrollPane2 = new JScrollPane(panel2);

        // Agregar componentes al JPanel de la segunda pestaña
        for (int i = 1; i <= 30; i++) {
            panel2.add(new JButton("Botón " + i));
        }

        // Agregar el JScrollPane a la segunda pestaña del JTabbedPane
        tabbedPane.addTab("Pestaña 2", null, scrollPane2, "Contenido de la pestaña 2");

        // Agregar el JTabbedPane al JFrame
        frame.getContentPane().add(tabbedPane);

        // Hacer visible el JFrame
        frame.setVisible(true);
    }
}