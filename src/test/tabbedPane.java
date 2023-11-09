/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author admin
 */
public class tabbedPane extends JFrame
{
    
    public tabbedPane(){
        setTitle("Ejemplo de JTabbedPane");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Utiliza FlowLayout para el contenedor de las pestañas
        JPanel tabContainer = new JPanel(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Contenido del Panel 1"));
        tabbedPane.addTab("Pestaña 1", null, panel1, "Primer panel");

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Contenido del Panel 2"));
        tabbedPane.addTab("Pestaña 2", null, panel2, "Segundo panel");

        JPanel panel3 = new JPanel();
        JButton button = new JButton("Haz clic");
        panel3.add(button);
        tabbedPane.addTab("Pestaña 3", null, panel3, "Tercer panel");

        tabContainer.add(tabbedPane);
        
        getContentPane().add(tabContainer, BorderLayout.CENTER);

        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new tabbedPane();
    }
}
