package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author alfredo
 */
public class MenuPersonal extends JPanel
{

    private JPanel panelHerramientas;
    private JPanel panelAreaTrabajo;
    private JTabbedPane tabbedPane = new JTabbedPane();
    final String pathImagenes = "src/interfaz/imagenes/";

    public MenuPersonal()
    {
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(20, 20, 20, 20));

        initPanelNorth();
        initPanelSouth();

        this.add(panelHerramientas, BorderLayout.NORTH);
        this.add(panelAreaTrabajo, BorderLayout.CENTER);
    }

    private void initPanelNorth()
    {
        panelHerramientas = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelHerramientas.setBackground(new Color(174, 214, 241));
        
        JLabel guardar = new JLabel(new ImageIcon(pathImagenes + "guardar.png"));
        guardar.setBorder(new EmptyBorder(0, 5, 0, 5));
        guardar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        guardar.setToolTipText("Guardar");               
        
        JLabel limpiar = new JLabel(new ImageIcon(pathImagenes + "limpiar.png"));
        limpiar.setBorder(new EmptyBorder(0, 5, 0, 5));
        limpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        limpiar.setToolTipText("Limpiar"); 
        
        
        panelHerramientas.add(guardar);
        panelHerramientas.add(limpiar);
    }
    
    private void initPanelSouth()
    {
        panelAreaTrabajo = new JPanel();
        panelAreaTrabajo.setBackground(Color.WHITE);
        panelAreaTrabajo.setBorder(new EmptyBorder(20, 0, 0, 0));
        panelAreaTrabajo.setLayout(new BorderLayout());
        //panelAreaTrabajo.setLayout(new FlowLayout());
        
        initPanelRegistrar();
        initPanelConsultar();
        initPanelModificar();
        
        tabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int selectedIndex = tabbedPane.getSelectedIndex();
                //JOptionPane.showMessageDialog(null, "Se cambió a la pestaña " + selectedIndex);
            }
        });
        panelAreaTrabajo.add(tabbedPane, BorderLayout.CENTER);
    }
    
    private void initPanelRegistrar()
    {
        JPanel contenedor = new JPanel();
        Formulario formulario = new Formulario(true);
        JPanel contenedor2 = new JPanel();
        
        JButton btnCancelar = new JButton("Cancelar");
        contenedor2.add(btnCancelar);
        JButton btnGuardar = new JButton("Guardar");
        contenedor2.add(btnGuardar);
        
        contenedor.setLayout(new BoxLayout(contenedor,BoxLayout.Y_AXIS));
        contenedor.add(formulario);
        contenedor.add(contenedor2);
        tabbedPane.addTab("Registrar", null, contenedor);
        
        btnGuardar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               if(formulario.getNombre().getText().equalsIgnoreCase(""))
               {
                   formulario.getNombre().setText("Bienvenido");
               }else
               {
                   JOptionPane.showMessageDialog(null, formulario.getNombre().getText());
               }
            }
            
        });
    }
    
    private void initPanelConsultar()
    {
        JPanel contenedor = new JPanel(new BorderLayout());
        
        Object[][] data = {
//                {"John", 25, "Engineer"},
//                {"Alice", 30, "Doctor"},
//                {"Bob", 28, "Teacher"},
                {"Clave","Nombre", "Primer A", "Segundo A", "Estatus", "Sexo", "Fecha", "Desnutricion", "Sobrepeso", "Alergias", "Obesida","Diabetes", "Otra", "Padecimineto Actual", "Plan de tratamineto", "Medicamneto", "Antecedentes","Antecedentes","Antecedentes", "Antecedentes"}
        };

        // Nombres de las columnas
        String[] columnNames = {"Clave","Nombre", "Primer A", "Segundo A", "Estatus", "Sexo", "Fecha", "Desnutricion", "Sobrepeso", "Alergias", "Obesida","Diabetes", "Otra", "Padecimineto Actual", "Plan de tratamineto", "Medicamneto", "Antecedentes","Antecedentes","Antecedentes", "Antecedentes"};

        // Crea una nueva tabla con los datos y nombres de columnas
        JTable table = new JTable(data, columnNames);
        
        // Crea un JScrollPane para agregar la tabla y permitir el desplazamiento si es necesario
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //table.setPreferredScrollableViewportSize(new Dimension(contenedor.getSize().width, contenedor.getSize().height));
        JScrollPane scrollPane = new JScrollPane(table);
        table.setEnabled(false);
        //scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        

        //table.setEnabled(false);
        contenedor.add(scrollPane, BorderLayout.CENTER);
        tabbedPane.addTab("Consultar", null, contenedor);
    }
    
    private void initPanelModificar()
    {
        JPanel conten = new JPanel();
        conten.setLayout(new BoxLayout(conten, BoxLayout.X_AXIS));
        JPanel contenedor = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Formulario formulario = new Formulario(true);
        formulario.habilitarComponentes(false);
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        contenedor.add(new JLabel("Clave"), gbc);
        gbc.gridx = 1;
        contenedor.add(new JTextField(10), gbc);
        gbc.gridy = 1;
        JButton btnBuscar = new JButton("Buscar");
        contenedor.add(btnBuscar, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
        conten.add(contenedor);
        conten.add(separator);
        
        JPanel contenedor2 = new JPanel();
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setEnabled(false);
        contenedor2.add(btnCancelar);
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setEnabled(false);
        contenedor2.add(btnGuardar);
        
        JPanel contenedor3 = new JPanel();
        contenedor3.setLayout(new BoxLayout(contenedor3,BoxLayout.Y_AXIS));
        contenedor3.add(formulario);
        contenedor3.add(contenedor2);
        conten.add(contenedor3);
        tabbedPane.addTab("Modificar", null, conten);
        
        btnBuscar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                formulario.habilitarComponentes(true);
                btnGuardar.setEnabled(true);
                btnCancelar.setEnabled(true);
            }
        });
    }
}
