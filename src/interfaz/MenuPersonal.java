package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

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
        
        initPanelRegistrar();
        initPanelConsultar();
        initPanelModificar();
        
        panelAreaTrabajo.add(tabbedPane, BorderLayout.CENTER);
    }
    
    private void initPanelRegistrar()
    {
        /*JPanel registrar = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        registrar.setBorder(new EmptyBorder(0, 0, 0, 0));
        
        JPanel contenedor1 = new JPanel(new FlowLayout());
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 5, 5, 5);
        contenedor1.add(new JLabel("Clave"));
//        gbc.gridx = 1;
//        gbc.gridy = 0;
        contenedor1.add(new JTextField(12));
        registrar.add(contenedor1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        registrar.add(new JLabel("Nombre(s)"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        registrar.add(new JTextField(18), gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        registrar.add(new JLabel("Apellido Paterno"),gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        registrar.add(new JTextField(18), gbc);
        gbc.gridx = 3;
        gbc.gridy = 0;
        registrar.add(new JLabel("Apellido Materno"), gbc);
        gbc.gridx = 3;
        gbc.gridy = 2;
        registrar.add(new JTextField(18), gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        JPanel contenedor2 = new JPanel(new FlowLayout());
        //registrar.add(new JLabel("Estatus"), gbc);
        String[] opcEstatus = {"Base", "Temporal"};
//        gbc.gridx = 1;
//        gbc.gridy = 3;
        JComboBox estatus = new JComboBox(opcEstatus);
        contenedor2.add(new JLabel("Estatus"));
        contenedor2.add(estatus);
        registrar.add(contenedor2, gbc);
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        JPanel panelSexo = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Sexo");
        panelSexo.setBorder(titledBorder);
        JRadioButton radioButton1 = new JRadioButton("Hombre");
        JRadioButton radioButton2 = new JRadioButton("Mujer");
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        panelSexo.add(radioButton1);
        panelSexo.add(radioButton2);
        registrar.add(panelSexo, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 4;
        JPanel panelPadecimientos = new JPanel();
        titledBorder = BorderFactory.createTitledBorder("Padecimientos");
        panelPadecimientos.setBorder(titledBorder);
        JCheckBox desnutricion = new JCheckBox("Desnutricion");
        JCheckBox sobrepeso = new JCheckBox("Sobrepeso");
        JCheckBox alergias = new JCheckBox("Alergias");
        JCheckBox obesidad = new JCheckBox("Obesidad");
        JCheckBox diabetes = new JCheckBox("Diabetes");
        JCheckBox otras = new JCheckBox("Otras");

        JTextField otrasText = new JTextField(10);
        //textArea.setRows(5); // Establecer el número de filas
        //textArea.setColumns(30); // Establecer el número de columnas
        // Crear un JScrollPane para agregar el área de texto con barras de desplazamiento
        //JScrollPane scrollPane = new JScrollPane(textArea);

        panelPadecimientos.add(desnutricion);
        panelPadecimientos.add(sobrepeso);
        panelPadecimientos.add(alergias);
        panelPadecimientos.add(obesidad);
        panelPadecimientos.add(diabetes);
        panelPadecimientos.add(otras);
        panelPadecimientos.add(otrasText);
        //gbc.insets = new Insets(10, 5, 10, 5);
        registrar.add(panelPadecimientos, gbc);
        //gbc.insets = new Insets(0, 5, 0, 5);
        JPanel contenedor3 = new JPanel();
        contenedor3.setLayout(new BoxLayout(contenedor3, BoxLayout.Y_AXIS));
        JCheckBox padecimientoActual = new JCheckBox("Padecimiento Actual");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        //registrar.add(padecimientoActual, gbc);
        JTextArea text1 = new JTextArea(7, 35);
//        gbc.gridx = 0;
//        gbc.gridy = 6;
        JScrollPane scrollPane1 = new JScrollPane(text1);
        contenedor3.add(padecimientoActual);
        contenedor3.add(scrollPane1);
        registrar.add(contenedor3, gbc);
        
        JPanel contenedor4 = new JPanel();
        contenedor4.setLayout(new BoxLayout(contenedor4, BoxLayout.Y_AXIS));
        JCheckBox medicamento = new JCheckBox("Medicamento");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        JTextArea text2 = new JTextArea(7, 35);
//        gbc.gridx = 0;
//        gbc.gridy = 6;
        JScrollPane scrollPane2 = new JScrollPane(text2);
        contenedor4.add(medicamento);
        contenedor4.add(scrollPane2);
        registrar.add(contenedor4, gbc);
        
        JPanel contenedor5 = new JPanel();
        contenedor5.setLayout(new BoxLayout(contenedor5, BoxLayout.Y_AXIS));
        JCheckBox antecedentes = new JCheckBox("Antecedentes");
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        JTextArea text3 = new JTextArea(7, 35);
        JScrollPane scrollPane3 = new JScrollPane(text3);
        contenedor5.add(antecedentes);
        contenedor5.add(scrollPane3);
        registrar.add(contenedor5, gbc);
        
        JPanel contenedor6 = new JPanel();
        contenedor6.setLayout(new BoxLayout(contenedor6, BoxLayout.Y_AXIS));
        JCheckBox tratamiento = new JCheckBox("Tratamiento");
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        JTextArea text4 = new JTextArea(7, 35);
        JScrollPane scrollPane4 = new JScrollPane(text4);
        contenedor6.add(tratamiento);
        contenedor6.add(scrollPane4);
        registrar.add(contenedor6, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        JButton btn = new JButton("Cancelar");
        registrar.add(btn, gbc);
        gbc.gridx = 3;
        JButton btn2 = new JButton("Guardar");
        registrar.add(btn2, gbc);
//        JPanel pn = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        pn.add(registrar);*/
        Formulario f = new Formulario();
//        JButton btn = new JButton("Cancelar");
//        f.add(btn);
//        
//        JButton btn2 = new JButton("Guardar");
//        f.add(btn);
        JPanel contenedor2 = new JPanel();
        
        JButton btn = new JButton("Cancelar");
        contenedor2.add(btn);
        JButton btn2 = new JButton("Guardar");
        contenedor2.add(btn2);
        JPanel contenedor = new JPanel();
        contenedor.setLayout(new BoxLayout(contenedor,BoxLayout.Y_AXIS));
        contenedor.add(f);
        contenedor.add(contenedor2);
        tabbedPane.addTab("Registrar", null, contenedor);
        
        btn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               if(f.getNombre().getText().equalsIgnoreCase(""))
               {
                   f.getNombre().setText("Bienvenido");
               }else
               {
                   JOptionPane.showMessageDialog(null, f.getNombre().getText());
               }
            }
            
        });
    }
    
    private void initPanelConsultar()
    {
        JPanel consultar = new JPanel();
        consultar.add(new JLabel("Contenido del Panel 2"));
        tabbedPane.addTab("Consultar", null, consultar);
    }
    
    private void initPanelModificar()
    {
        JPanel modificar = new JPanel();
        modificar.add(new JLabel("Contenido del Panel 3"));
        tabbedPane.addTab("Modificar", null, modificar);
    }
}
