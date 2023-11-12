/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import ctrl.ManipulacionArchivos;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import poo.Datos;
import poo.HistorialClinico;

/**
 *
 * @author admin
 */
public class VentanaHistorial extends JDialog
{

    JPanel panelNorth;
    JPanel panelWest;
    JPanel panelCenter;
    FormularioMedico form;
    HistorialClinico[] historial;
    private DefaultTableModel model;
    
    public VentanaHistorial(String titulo, HistorialClinico[] historial)
    {
        super(new JFrame(), titulo, true);
        this.historial = historial;
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setIconImage(null);
        initComponets();
    }
    
    private void initComponets()
    {
        initPanelCenter();
        initPanelNorth();
        initPanelWest();
        initPanelCenter();
    }  
    
    private void initPanelNorth()
    {
        panelNorth = new JPanel();
        this.add(panelNorth, BorderLayout.NORTH);
    }
    private void initPanelWest()
    {
        panelWest = new JPanel();
        model = new DefaultTableModel()
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        model.setColumnIdentifiers(new String[]{"Fecha"});
        Object[] fila;
        for (HistorialClinico historial1 : historial)
        {
            fila = new Object[]{historial1.getFecha()};
            model.addRow(fila);
        }
        
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
                        
                    }
                }
            }
        });

        JScrollPane scrollTabla = new JScrollPane(tabla);
        panelWest.add(scrollTabla);
        this.add(panelWest, BorderLayout.WEST);
    }
    
    private void initPanelCenter()
    {
        panelCenter = new JPanel();
        form = new FormularioMedico();
        panelCenter.add(form);
        this.add(panelCenter, BorderLayout.CENTER);
    }
}
