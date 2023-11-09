/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author admin
 */
public class testWidth
{
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Custom TableCellRenderer Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel();
        
        JTable table = new JTable(model);

        model.addColumn("Clave");
        model.addColumn("Nombre");
        model.addColumn("Primer A");
        model.addColumn("Segundo A");
        model.addColumn("Sexo");
        model.addColumn("Estatus");
        model.addColumn("Desnutricion");
        model.addColumn("Sobrepeso");
        model.addColumn("Alergias");
        model.addColumn("Obesida");
        model.addColumn("Diabetes");
        model.addColumn("Otra");

        // Configurar el TableCellRenderer personalizado
        table.setDefaultRenderer(Object.class, (TableCellRenderer) new CustomTableCellRenderer());

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        // Ejemplo de datos en forma de matriz
        Object[][] matrixData = {
                {"001", "Juan", "Pérez", "Gómez", "Masculino", "Activo", "No", "No", "No", "No", "No", "Sí"},
            {
                "002", "Carlos", "García", "Hernández", "Masculino", "Inactivo", "No", "Sí", "No", "No", "No", "No"
            },
            {
                "003", "María la de la pata fria", "Rodríguez", "Pérez", "Femenino", "Activo", "No", "No", "Sí", "No", "No", "No"
            },
            {
                "004", "Javier", "Díaz", "Gómez", "Masculino", "Activo", "No", "No", "No", "Sí", "No", "No"
            },
            {
                "005", "Laura", "Fernández", "López", "Femenino", "Inactivo", "No", "No", "No", "No", "Sí", "No"
            },
            {
                "006", "Alejandro", "Martínez", "Sánchez", "Masculino", "Activo", "No", "Sí", "No", "No", "No", "No"
            },
            {
                "007", "Elena", "Gómez", "Torres", "Femenino", "Inactivo", "No", "No", "No", "Sí", "No", "No"
            },
            {
                "008", "Adrián", "Pérez", "García", "Masculino", "Activo", "No", "No", "No", "No", "No", "Sí"
            },
            {
                "009", "Isabel", "López", "Martín", "Femenino", "Activo", "No", "No", "Sí", "No", "No", "No"
            },
            {
                "010", "Daniel", "Fernández", "Gómez", "Masculino", "Inactivo", "Sí", "No", "No", "No", "No", "No"
            }
                
        };

        // Agregar datos de la matriz a la tabla
        for (Object[] rowData : matrixData) {
            model.addRow(rowData);
        }

        frame.setSize(800, 400);
        frame.setVisible(true);
    }

    // TableCellRenderer personalizado para evitar truncar el contenido
    static class CustomTableCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (rendererComponent instanceof JLabel) {
                JLabel label = (JLabel) rendererComponent;
                label.setToolTipText(String.valueOf(value)); // Mostrar el contenido completo en el tooltip
            }
            return rendererComponent;
        }
    }
}
