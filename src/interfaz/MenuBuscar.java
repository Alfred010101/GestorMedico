
package interfaz;

import ctrl.ManipulacionArchivos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import poo.Alumnos;
import poo.Datos;
import poo.Personal;

/**
 *
 * @author alfredo
 */
public class MenuBuscar extends JPanel
{
    
    private DefaultTableModel model;
            
    public MenuBuscar()
    {
        initComponents();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    
    private void initComponents()
    {
        String[] columnNames = new String[]
            {
                "Clave", "Nombre(s)", "Apellido Paterno", "Apellido Materno", "Sexo", "Estatus", "Carrera", "Vive Con", "Desnutricion", "Sobrepeso", "Alergias", "Obesida", "Diabetes", "Otra"
            };
        model = new DefaultTableModel()
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        model.setColumnIdentifiers(columnNames);

        filtrar((Datos[]) ManipulacionArchivos.cargaArch(null, "datos.dat"));
        JTable tabla = new JTable(model);
                
        tabla.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1)
                {
                    int filaSeleccionada = tabla.getSelectedRow();
                    if (filaSeleccionada != -1)
                    {
                        VentanaHistorial ventanaEmergente = new VentanaHistorial((String)tabla.getValueAt(filaSeleccionada, 1), null);
                        ventanaEmergente.setVisible(true);
                        // Obtener los datos de la fila seleccionada
                        Object valorColumna1 = tabla.getValueAt(filaSeleccionada, 0);
                        Object valorColumna2 = tabla.getValueAt(filaSeleccionada, 1);
                        // Hacer algo con los valores obtenidos
                        System.out.println("Doble clic en la fila: " + filaSeleccionada);
                        System.out.println("Valor en la Columna1: " + valorColumna1);
                        System.out.println("Valor en la Columna2: " + valorColumna2);
                    }
                }
            }
        });

        JScrollPane scrollTabla = new JScrollPane(tabla);
        this.add(scrollTabla);
    }
    
    private void filtrar(Datos[] registros)
    {
        Object[] fila = null;
        model.setRowCount(0);
        if (registros != null)
        {
            for (Datos dato : registros)
            {
                
                if (dato instanceof Personal)
                {
                    fila = new Object[]
                    {
                        dato.getCve(), dato.getNom(), dato.getPrimerAp(), dato.getSegundoAp(),
                        dato.getSexo(), FormularioDatos.ESTATUS[((Personal) dato).getEstatus()],"----","----",
                        dato.isDesnutriccion() ? "Si" : "No", dato.isSobrepeso() ? "Si" : "No", dato.isAlergias() ? "Si" : "No",
                        dato.isObecidad() ? "Si" : "No", dato.isDiabetes() ? "Si" : "No", dato.getOtras()
                    };

                } else if (dato instanceof Alumnos)
                {
                    fila = new Object[]
                    {
                        dato.getCve(), dato.getNom(), dato.getPrimerAp(), dato.getSegundoAp(),
                        dato.getSexo(), "----", FormularioDatos.CARRERAS[((Alumnos) dato).getCarrera()], FormularioDatos.VIVECON[((Alumnos) dato).getViveCon()],
                        dato.isDesnutriccion() ? "Si" : "No", dato.isSobrepeso() ? "Si" : "No", dato.isAlergias() ? "Si" : "No",
                        dato.isObecidad() ? "Si" : "No", dato.isDiabetes() ? "Si" : "No", dato.getOtras()
                    };
                    
                }
                
                model.addRow(fila);
            }
        }
    }
}