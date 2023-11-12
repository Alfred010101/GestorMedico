/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class TableExample
{
 public static void main(String[] args) {
        // Datos de ejemplo para la tabla
        Object[][] data = {
                {"John", 25, "Engineer"},
                {"Alice", 30, "Doctor"},
                {"Bob", 28, "Teacher"},
                {"Eva", 35, "Scientist"},
                {"Michael", 29, "Artist"},
                {"Sophia", 27, "Writer"}
        };

        // Nombres de las columnas
        String[] columnNames = {"Nombre", "Edad", "Profesión"};

        // Crea un modelo de tabla personalizado con los datos y nombres de las columnas
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Crea una tabla con el modelo de tabla personalizado
        JTable table = new JTable(model);
        
        // Configura el ancho preferido de las columnas
        table.getColumnModel().getColumn(0).setPreferredWidth(150); // Nombre
        table.getColumnModel().getColumn(1).setPreferredWidth(50);  // Edad
        table.getColumnModel().getColumn(2).setPreferredWidth(200); // Profesión

        // Crea un JScrollPane para agregar la tabla y permitir el desplazamiento si es necesario
        JScrollPane scrollPane = new JScrollPane(table);

        // Crea un JFrame para mostrar la tabla
        JFrame frame = new JFrame("Ejemplo de Tabla");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER); // Agrega la tabla al centro del JFrame
        frame.setSize(500, 200); // Establece el tamaño del JFrame
        frame.setVisible(true);
    }
}