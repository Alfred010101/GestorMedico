package interfaz;

import ctrl.ManipulacionArchivos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import poo.Datos;
import poo.Personal;

/**
 *
 * @author alfredo
 */
public class MenuPersonal extends JPanel
{

    private JPanel panelHerramientas;
    private JPanel panelAreaTrabajo;
    private JTabbedPane tabbedPane;
    
    final String pathImagenes = "src/interfaz/imagenes/";
    
    private final JLabel[] iconos = new JLabel[9];
    private final JLabel separador = new JLabel(new ImageIcon(pathImagenes + "separador.png"));
    private JComboBox padecimientos;
    
    private enum Herramienta
    {
        BUSCAR,
        GUARDAR,
        LIMPIAR,
        ACTUALIZAR,
        RESTABLEZER,
        ORDENAR,
        AMBOS,
        HOMBRE,
        MUJER,
        PADECIMIENTO
    }
    
    private FormularioDatos formularioRegistro;
    private JPanel contenedorTabla;
    private JTable tabla;
    private DefaultTableModel model;
    private Datos[] tablaMostrar;
    private boolean tipoOrdenamiento = true;
    private boolean tipoUsuaurio;
    
    public MenuPersonal(boolean tipoUsuario)
    {
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.tipoUsuaurio = tipoUsuario;
        initPanelNorth();
        initPanelSouth();

        this.add(panelHerramientas, BorderLayout.NORTH);
        this.add(panelAreaTrabajo, BorderLayout.CENTER);
    }

    private void initPanelNorth()
    {
        panelHerramientas = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelHerramientas.setBackground(new Color(174, 214, 241));
        for (int i = 0; i < iconos.length; i++)
        {
            iconos[i] = new JLabel();
        }
        
        padecimientos = new JComboBox(new String[] {"","Desnutricion", "Sobrepeso", "Alergias", "Obesidad", "Diabetes", "Otra"});
        String[] txt =
        {
            "Buscar Registro", "Guardar Registro", "Limpiar Formulario", "Actualizar Registro", "Restablecer Registro", "Ordenar Frecuencia Descendente", "Mostar Ambos", "Mostrar Hombres", "mostrar Mujeres"
        };
        String[] nomIcon =
        {
            "buscar_registro.png", "guardar.png", "limpiar.png", "actualizar.png", "restablecer.png", "ordenar.png", "ambos.png", "hombre.png", "mujer.png"
        };
        //String[] hover = {"guardar_Hover.png", "limpiar_Hover.png", "buscar_registro_Hover.png", "actualizar_Hover.png", "restablecer_Hover.png", "ordenar_a-z_Hover.png"};
        
        initHerramientas(txt, nomIcon);
        habilitarHerraminetas(iconos[1], iconos[2]);
        separador.setVisible(false);
        padecimientos.setVisible(false);
        panelHerramientas.add(padecimientos);
        
        /**
         * Configuara cada herramienta de la barra de herramientas
         */
        iconos[Herramienta.BUSCAR.ordinal()].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent evt)
            {
                iconos[0].setIcon(new ImageIcon(pathImagenes + nomIcon[0]));
            }
            @Override
            public void mouseEntered(MouseEvent evt)
            {
                iconos[0].setIcon(new ImageIcon(pathImagenes + "buscar_registro_Hover.png"));
            }
            @Override
            public void mouseClicked(MouseEvent evt)
            {
                if(iconos[0].isEnabled())
                {
                    int[] index = buscarNombre(JOptionPane.showInputDialog("Ingrese nombre"));
                    if(index != null)
                    {
                        tabla.setRowSelectionInterval(index[0], index[0]);
                    }else
                    {
                        JOptionPane.showMessageDialog(null,"El dato ingresado no se ha encontrado en los registro");
                    }
                }
            }
        });
        
        iconos[Herramienta.GUARDAR.ordinal()].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent evt)
            {
                iconos[1].setIcon(new ImageIcon(pathImagenes + nomIcon[1]));
            }
            @Override
            public void mouseEntered(MouseEvent evt)
            {
                iconos[1].setIcon(new ImageIcon(pathImagenes + "guardar_Hover.png"));
            }
            @Override
            public void mouseClicked(MouseEvent evt)
            {
                //JDialog customDialog = new JDialog(new JFrame(), "Ventana Emergente", true);
               /* VentanaEmergente customDialog = new VentanaEmergente(new JFrame(), "Buscar Registro");

                customDialog.setSize(500, 200);
                customDialog.setLocationRelativeTo(null);
                customDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                JPanel conDia = new JPanel();
                // Agregar contenido al JDialog
                JLabel label = new JLabel("Contenido de la ventana emergente");
                conDia.setBorder(new LineBorder(Color.GRAY, 1));
                conDia.add(label);

                conDia.add(new JButton("Linux"));
                customDialog.add(conDia);

                // Mostrar el JDialog
                customDialog.setVisible(true);*/
                guardarNuevoRegistro();
            }
        });
        iconos[Herramienta.LIMPIAR.ordinal()].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent evt)
            {
                iconos[2].setIcon(new ImageIcon(pathImagenes + nomIcon[2]));
            }
            @Override
            public void mouseEntered(MouseEvent evt)
            {
                iconos[2].setIcon(new ImageIcon(pathImagenes + "limpiar_Hover.png"));
            }
            @Override
            public void mouseClicked(MouseEvent evt)
            {
                if(iconos[2].isEnabled())
                {
                    formularioRegistro.limpiarFormulario();                    
                }
            }
        });
        
        iconos[Herramienta.ACTUALIZAR.ordinal()].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent evt)
            {
                iconos[3].setIcon(new ImageIcon(pathImagenes + nomIcon[3]));
            }
            @Override
            public void mouseEntered(MouseEvent evt)
            {
                iconos[3].setIcon(new ImageIcon(pathImagenes + "actualizar_Hover.png"));
            }
            @Override
            public void mouseClicked(MouseEvent evt)
            {
                if(iconos[3].isEnabled())
                {
                    formularioRegistro.limpiarFormulario();                    
                }
            }
        });
        
        iconos[Herramienta.RESTABLEZER.ordinal()].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent evt)
            {
                iconos[4].setIcon(new ImageIcon(pathImagenes + nomIcon[4]));
            }
            @Override
            public void mouseEntered(MouseEvent evt)
            {
                iconos[4].setIcon(new ImageIcon(pathImagenes + "restablecer_Hover.png"));
            }
            @Override
            public void mouseClicked(MouseEvent evt)
            {
                if(iconos[4].isEnabled())
                {
                    formularioRegistro.limpiarFormulario();                    
                }
            }
        });
        
        iconos[Herramienta.ORDENAR.ordinal()].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent evt)
            {
                iconos[5].setIcon(new ImageIcon(pathImagenes + nomIcon[5]));
            }
            @Override
            public void mouseEntered(MouseEvent evt)
            {
                iconos[5].setIcon(new ImageIcon(pathImagenes + "ordenar_Hover.png"));
            }
            @Override
            public void mouseClicked(MouseEvent evt)
            {
                if(iconos[5].isEnabled() && tablaMostrar != null)
                {
                    Datos tmp;
                    for (int i = 0; i < tablaMostrar.length; i++)
                    {
                        for (int j = 0; j < tablaMostrar.length - 1; j++)
                        {
                            if(tipoOrdenamiento && tablaMostrar[j].getNom().compareTo(tablaMostrar[j + 1].getNom()) > 0)
                            {
                                tmp = tablaMostrar[j];
                                tablaMostrar[j] = tablaMostrar[j +1];
                                tablaMostrar[j + 1] =  tmp;
                            }else if(!tipoOrdenamiento && tablaMostrar[j].getNom().compareTo(tablaMostrar[j + 1].getNom()) < 0)
                            {
                                tmp = tablaMostrar[j];
                                tablaMostrar[j] = tablaMostrar[j +1];
                                tablaMostrar[j + 1] =  tmp;
                            }
                        }
                    }
                    tipoOrdenamiento = (!tipoOrdenamiento);
                    model.setRowCount(0);
                    llenarTabla(tablaMostrar);
                }
            }
        });
        
        iconos[Herramienta.AMBOS.ordinal()].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent evt)
            {
                iconos[6].setIcon(new ImageIcon(pathImagenes + nomIcon[6]));
            }
            @Override
            public void mouseEntered(MouseEvent evt)
            {
                iconos[6].setIcon(new ImageIcon(pathImagenes + "ambos_Hover.png"));
            }
            @Override
            public void mouseClicked(MouseEvent evt)
            {
                //activarMenu(Menu.INICIO);
            }
        });
        
        iconos[Herramienta.HOMBRE.ordinal()].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent evt)
            {
                iconos[7].setIcon(new ImageIcon(pathImagenes + nomIcon[7]));
            }
            @Override
            public void mouseEntered(MouseEvent evt)
            {
                iconos[7].setIcon(new ImageIcon(pathImagenes + "hombre_Hover.png"));
            }
            @Override
            public void mouseClicked(MouseEvent evt)
            {
                //activarMenu(Menu.INICIO);
            }
        });
        
        iconos[Herramienta.MUJER.ordinal()].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent evt)
            {
                iconos[8].setIcon(new ImageIcon(pathImagenes + nomIcon[8]));
            }
            @Override
            public void mouseEntered(MouseEvent evt)
            {
                iconos[8].setIcon(new ImageIcon(pathImagenes + "mujer_Hover.png"));
            }
            @Override
            public void mouseClicked(MouseEvent evt)
            {
                if(iconos[8].isEnabled())
                    JOptionPane.showMessageDialog(null, "Hola");
            }
        });
    }

    private void initPanelSouth()
    {
        panelAreaTrabajo = new JPanel();
        panelAreaTrabajo.setBackground(Color.WHITE);
        panelAreaTrabajo.setBorder(new EmptyBorder(20, 0, 0, 0));
        panelAreaTrabajo.setLayout(new BorderLayout());
        tabbedPane = new JTabbedPane();
        
        initPanelRegistrar();
        initPanelModificar();
        initPanelConsultar();
        initConsultaMedica();

        tabbedPane.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
                int selectedIndex = tabbedPane.getSelectedIndex();
                padecimientos.setVisible(false);
                separador.setVisible(false);
                switch (selectedIndex)
                {
                    case 0:
                        habilitarHerraminetas(iconos[1], iconos[2]);
                        break;
                    case 1:
                        habilitarHerraminetas(iconos[0], iconos[3], iconos[4]);
                        break;
                    case 2:
                        habilitarHerraminetas(iconos[0], iconos[5], iconos[6], iconos[7], iconos[8]);
                        separador.setVisible(true);
                        padecimientos.setVisible(true);
                       // contenedorTabla.removeAll();
                        Datos[] lista = (Datos[]) ManipulacionArchivos.cargaArch(contenedorTabla, "personal.dat", false);        
                        ctrl.CtrlInterfaz.habilita( (lista != null), iconos[0], iconos[5], iconos[6], iconos[7], iconos[8]);
                        if(lista != null)
                        {
                            ctrl.CtrlInterfaz.habilita(true, iconos[0], iconos[5], iconos[6], iconos[7], iconos[8]);
                            model.setRowCount(0);
                            contenedorTabla.add(llenarTabla(lista), BorderLayout.CENTER);
                        }
                        break;
                    case 3:
                        habilitarHerraminetas(iconos[0], iconos[1], iconos[2]);
                }
            }
        });

        /**
         * Configuracion de los atajos de teclado para moverse por las pestañas
         * Ctrl + 1 => Nuevo Registro : Ctrl + 2  => Modificar Registro 
         * Ctrl + 3 => Consultar Registros : Ctrl + 4 => Nueva Consulta Medica.
         */
        KeyStroke keyCtrl1 = KeyStroke.getKeyStroke(KeyEvent.VK_1, KeyEvent.CTRL_DOWN_MASK);
        KeyStroke keyCtrl2 = KeyStroke.getKeyStroke(KeyEvent.VK_2, KeyEvent.CTRL_DOWN_MASK);
        KeyStroke keyCtrl3 = KeyStroke.getKeyStroke(KeyEvent.VK_3, KeyEvent.CTRL_DOWN_MASK);
        KeyStroke keyCtrl4 = KeyStroke.getKeyStroke(KeyEvent.VK_4, KeyEvent.CTRL_DOWN_MASK);

        Action actionCtrl1 = new AbstractAction("Pestaña_1")
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tabbedPane.setSelectedIndex(0);
            }
        };
        Action actionCtrl2 = new AbstractAction("Pestaña_2")
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tabbedPane.setSelectedIndex(1);
            }
        };
        Action actionCtrl3 = new AbstractAction("Pestaña_3")
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tabbedPane.setSelectedIndex(2);
            }
        };
        Action actionCtrl4 = new AbstractAction("Pestaña_4")
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tabbedPane.setSelectedIndex(3);
            }
        };

        tabbedPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyCtrl1, "Pestaña_1");
        tabbedPane.getActionMap().put("Pestaña_1", actionCtrl1);
        tabbedPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyCtrl2, "Pestaña_2");
        tabbedPane.getActionMap().put("Pestaña_2", actionCtrl2);
        tabbedPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyCtrl3, "Pestaña_3");
        tabbedPane.getActionMap().put("Pestaña_3", actionCtrl3);
        tabbedPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyCtrl4, "Pestaña_4");
        tabbedPane.getActionMap().put("Pestaña_4", actionCtrl4);

        panelAreaTrabajo.add(tabbedPane, BorderLayout.CENTER);
    }

    private void initPanelRegistrar()
    {
        JPanel contenedor = new JPanel();
        JPanel contenedor1 = new JPanel();
        JPanel contenedor2 = new JPanel();
        formularioRegistro = new FormularioDatos(tipoUsuaurio);
        //contenedor.setLayout(new FlowLayout(FlowLayout.CENTER));
        //contenedor1.setBackground(Color.WHITE);
        contenedor1.add(formularioRegistro);

        JButton btnCancelar = new JButton("Cancelar");
        JButton btnGuardar = new JButton("Guardar Registro");
        //contenedor2.setBackground(Color.WHITE);
        contenedor2.add(btnCancelar);
        contenedor2.add(btnGuardar);

        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
        //contenedor.setBackground(Color.WHITE);
        contenedor.add(contenedor1);
        //contenedor.add(Box.createHorizontalGlue());
        contenedor.add(contenedor2);
        //contenedor.add(Box.createHorizontalGlue());
        tabbedPane.addTab("Nuevo Registro", null, contenedor);

        btnGuardar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                guardarNuevoRegistro();
            }
        }
        );
        btnCancelar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                formularioRegistro.limpiarFormulario();
            }
        });
    }

    private void initPanelModificar()
    {
        JPanel contenedor = new JPanel();
        JPanel contenedor1 = new JPanel();
        JPanel contenedor2 = new JPanel();
        formularioRegistro = new FormularioDatos(tipoUsuaurio);
        //contenedor.setLayout(new FlowLayout(FlowLayout.CENTER));
        //contenedor1.setBackground(Color.WHITE);
        contenedor1.add(formularioRegistro);

        JButton btnGuardar = new JButton("Actualizar Registro");
        //contenedor2.setBackground(Color.WHITE);
        contenedor2.add(btnGuardar);

        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
        //contenedor.setBackground(Color.WHITE);
        contenedor.add(contenedor1);
        //contenedor.add(Box.createHorizontalGlue());
        contenedor.add(contenedor2);
        //contenedor.add(Box.createHorizontalGlue());
        tabbedPane.addTab("Nuevo Registro", null, contenedor);

        btnGuardar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                guardarNuevoRegistro();
            }
        }
        );
    }

    private void initPanelConsultar()
    {
        String[] columnNames =
        {
            "Clave", "Nombre", "Primer A", "Segundo A", "Sexo", "Estatus", "Desnutricion", "Sobrepeso", "Alergias", "Obesida", "Diabetes", "Otra"
        };
        contenedorTabla = new JPanel(new BorderLayout());        
        model = new DefaultTableModel()
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        model.setColumnIdentifiers(columnNames);
        tabbedPane.addTab("Consultar Registros", null, contenedorTabla);
    }

    private void initConsultaMedica()
    {
        JPanel contenedor = new JPanel();
        JPanel contenedor1 = new JPanel();
        JPanel contenedor2 = new JPanel();
        JPanel contenedor3 = new JPanel();
        formularioRegistro = new FormularioDatos(tipoUsuaurio);
        FormularioMedico formularioMedico = new FormularioMedico();
        //contenedor.setLayout(new FlowLayout(FlowLayout.CENTER));
        //contenedor1.setBackground(Color.WHITE);
        formularioMedico.setBorder(BorderFactory.createTitledBorder(""));
        contenedor1.add(formularioRegistro);
        contenedor2.add(formularioMedico);
        
        JButton btnGuardar = new JButton("Guardar Consulta Medica");
        //contenedor2.setBackground(Color.WHITE);
        contenedor3.add(btnGuardar);

        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
        //contenedor.setBackground(Color.WHITE);
        contenedor.add(contenedor1);
        //contenedor.add(Box.createHorizontalGlue());
        contenedor.add(contenedor2);
        contenedor.add(contenedor3);
        //contenedor.add(Box.createHorizontalGlue());
        tabbedPane.addTab("Nuevo Registro", null, new JScrollPane(contenedor));

        btnGuardar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                guardarNuevoRegistro();
            }
        }
        );
        /*JPanel conten = new JPanel();
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
        contenedor3.setLayout(new BoxLayout(contenedor3, BoxLayout.Y_AXIS));
        contenedor3.add(formulario);
        contenedor3.add(contenedor2);
        conten.add(contenedor3);
        tabbedPane.addTab("Nueva Consulta Medica", null, conten);

        btnBuscar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                formulario.habilitarComponentes(true);
                btnGuardar.setEnabled(true);
                btnCancelar.setEnabled(true);
            }
        });*/
    }

    /**
     * inicializa los iconos de la barra de herramientas
     * @param txt se asigna como setToolTipText
     * @param nomIcon contiene el nombre del icono de la herramienta 
     */
    private void initHerramientas(String[] txt, String[] nomIcon)
    {
        if (txt.length == nomIcon.length && nomIcon.length == iconos.length)
        {
            ImageIcon img;
            for (int i = 0; i < txt.length; i++)
            {
                img = new ImageIcon(pathImagenes + "" + nomIcon[i]);
                iconos[i].setIcon(img);
                iconos[i].setBorder(new EmptyBorder(0, 0, 0, 5));
                iconos[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                iconos[i].setToolTipText(txt[i]);
                if (i == 6)
                    panelHerramientas.add(separador);
                panelHerramientas.add(iconos[i]);
            }
        }
    }

    private void habilitarHerraminetas(JLabel... s)
    {
        if (s.length <= iconos.length)
        {
            for (JLabel icono : iconos)
            {
                for (JLabel item : s)
                {
                    if (icono == item)
                    {
                        icono.setVisible(true);
                        break;
                    }
                    icono.setVisible(false);
                }
            }
        }
    }

    private void guardarNuevoRegistro()
    {
        if (formularioRegistro.camposVacios())
        {
            JOptionPane.showMessageDialog(null, "Todos los campos requeridos deben ser llenados, verifique si a activado algun checkbox que requiera mas informacion este no puede quedar vacio");
        } else
        {
            if (formularioRegistro.validarFormulario())
            {
                
                Datos personal = new Personal(formularioRegistro.getEstatus().getSelectedIndex(),
                        formularioRegistro.getCve().getText(), formularioRegistro.getNombre().getText(),
                        formularioRegistro.getPrimerAp().getText(),formularioRegistro.getSegundoAp().getText(), 
                        (formularioRegistro.getRbtMasculino().isSelected()) ? 'H':'M', 
                        formularioRegistro.getDesnutricion().isSelected(), formularioRegistro.getSobrepeso().isSelected(),
                        formularioRegistro.getAlergias().isSelected(), formularioRegistro.getObesidad().isSelected(), 
                        formularioRegistro.getDiabetes().isSelected(), formularioRegistro.getOtrasCual().getText());
                if(ctrl.ManipulacionArchivos.guardarReg(panelAreaTrabajo, personal, "personal.dat"))
                {
                    JOptionPane.showMessageDialog(panelAreaTrabajo, "Registro exitoso");
                    //formularioRegistro.limpiarFormulario();
                }else
                {
                    JOptionPane.showMessageDialog(panelAreaTrabajo,"No se a podido guardar el Registo", "Error al guardar el registro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    private JScrollPane llenarTabla(Datos[] lista)
    {
        tablaMostrar = lista;
        for (Datos dato : lista) {
            if(dato instanceof Personal)
            {
                Object[] fila = {dato.getCve(), dato.getNom(), dato.getPrimerAp(), dato.getSegundoAp(), 
                    dato.getSexo(), (((Personal) dato).getEstatus() == 1)?"Permante":"Tempora", 
                    dato.isDesnutriccion() ? "Si": "No", dato.isSobrepeso()? "Si": "No", dato.isAlergias()? "Si": "No",
                    dato.isObecidad()? "Si": "No", dato.isDiabetes() ? "Si": "No", dato.getOtras()};
                model.addRow(fila);
            } 
        }
        tabla = new JTable(model);
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
                    // Obtener la fila seleccionada
                    int filaSeleccionada = tabla.getSelectedRow();
                    
                    // Hacer algo con la fila seleccionada
                    if (filaSeleccionada != -1) {
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
        return new JScrollPane(tabla);
    }
    
    private int[] buscarNombre(String nombre)
    {
        int[] arryB = null;
        if(tablaMostrar != null)
        {
            for (int i = 0; i < tablaMostrar.length; i++)
            {
                if (tablaMostrar[i].getNom().equalsIgnoreCase(nombre))
                {
                    if(arryB == null)
                    {
                        arryB = new int[1];
                        arryB[0] = i; 
                    }else
                    {
                        int[] tmpArray = new int[arryB.length];
                        System.arraycopy(arryB, 0, tmpArray, 0, arryB.length);
                        tmpArray[arryB.length] = 1;
                        arryB = tmpArray;
                    }
                    System.out.println(i);
                }
            }
        }
        return arryB;
    }
    
    private void filtrar(char genero)
    {
//        Datos[] tmp;
//        for (int i = 0; i < tablaMostrar.length; i++)
//        {
//            if(tablaMostrar[i].getSexo() == genero)
//            {
//                if(tmp == null)
//                    {
//                        tmp = new Datos[1];
//                        tmp[0] = tablaMostrar[i]; 
//                    }else
//                    {
//                        Datos[] tmpArray = new Datos[tmp.length];
//                        System.arraycopy(tmp, 0, tmpArray, 0, tmp.length);
//                        tmpArray[tmp.length] = tablaMostrar[i];
//                        tmp = tmpArray;
//                    }
//            }
//        }
    }
            
}
