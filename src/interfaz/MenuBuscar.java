
package interfaz;

import ctrl.ManipulacionArchivos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import poo.Alumnos;
import poo.Datos;
import poo.HistorialClinico;
import poo.Personal;

/**
 *
 * @author alfredo
 */
public class MenuBuscar extends JPanel implements EstadoInicial
{
    
    private DefaultTableModel model;
    HistorialClinico[][] historial;
    
    public MenuBuscar()
    {
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(20, 20, 20, 20));
        initComponents();
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

        filtrar((Datos[]) ManipulacionArchivos.carga(null, "datos.dat"));
        historial = (HistorialClinico[][]) ctrl.ManipulacionArchivos.cargaArch("historial.dat", true);
        JTable tabla = new JTable(model);
                
        tabla.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1)
                {
                    int filaSeleccionada = tabla.getSelectedRow();
                    if (filaSeleccionada != -1 && historial[filaSeleccionada] != null)
                    {
                        VentanaHistorial ventanaEmergente = new VentanaHistorial((String)tabla.getValueAt(filaSeleccionada, 1), historial[filaSeleccionada]);
                        ventanaEmergente.setVisible(true);
                    }else
                    {
                        JOptionPane.showMessageDialog(null, "El registro seleccionado no tiene consultas medicas", "No hay consultas medicas", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        JScrollPane scrollTabla = new JScrollPane(tabla);
        this.add(scrollTabla, BorderLayout.CENTER);
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

    @Override
    public void restablecerEstadoInicial()
    {
        historial = (HistorialClinico[][]) ctrl.ManipulacionArchivos.cargaArch("historial.dat", true);
        filtrar((Datos[]) ManipulacionArchivos.carga(null, "datos.dat"));        
    }
}