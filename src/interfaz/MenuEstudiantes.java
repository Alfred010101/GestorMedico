
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
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author alfredo
 */
public class MenuEstudiantes extends JPanel
{
    private JPanel panelHerramientas;
    private JPanel panelAreaTrabajo;
    private JTabbedPane tabbedPane = new JTabbedPane();
    final String pathImagenes = "src/interfaz/imagenes/";

    public MenuEstudiantes()
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
        JPanel contenedor2 = new JPanel();
        JButton btnCancelar = new JButton("Cancelar");
        JButton btnGuardar = new JButton("Guardar");
        contenedor2.add(btnGuardar);
        contenedor2.add(btnCancelar);
        FormularioDatos formulario = new FormularioDatos(false, btnGuardar);
        
        
        
        
        //contenedor.setLayout(new BoxLayout(contenedor,BoxLayout.Y_AXIS));
        
        //JScrollPane contenedor = new JScrollPane(formulario);
        //contenedor.add(formulario);
        //contenedor.add(contenedor2);
        tabbedPane.addTab("Registrar", null, new JScrollPane(formulario));
        
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
        JPanel consultar = new JPanel();
        consultar.add(new JLabel("Contenido del Panel 2"));
        tabbedPane.addTab("Consultar", null, consultar);
    }
    
    private void initPanelModificar()
    {
        JPanel conten = new JPanel();
        conten.setLayout(new BoxLayout(conten, BoxLayout.X_AXIS));
        JPanel contenedor = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Formulario formulario = new Formulario(false);
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        contenedor.add(new JLabel("Clave"), gbc);
        gbc.gridx = 1;
        contenedor.add(new JTextField(10), gbc);
        gbc.gridy = 1;
        contenedor.add(new JButton("Buscar"), gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
        conten.add(contenedor);
        conten.add(separator);
        
        JPanel contenedor2 = new JPanel();
        JButton btnCancelar = new JButton("Cancelar");
        contenedor2.add(btnCancelar);
        JButton btnGuardar = new JButton("Guardar");
        contenedor2.add(btnGuardar);
        
        JPanel contenedor3 = new JPanel();
        contenedor3.setLayout(new BoxLayout(contenedor3,BoxLayout.Y_AXIS));
        contenedor3.add(formulario);
        contenedor3.add(contenedor2);
        conten.add(contenedor3);
        tabbedPane.addTab("Modificar", null, conten);
    }
}