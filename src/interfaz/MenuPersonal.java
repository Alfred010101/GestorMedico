package interfaz;

import ctrl.ManipulacionArchivos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
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
    private Formulario formularioRegistro;
    private final JLabel[] iconos = new JLabel[9];

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
        iconos[0] = new JLabel();
        iconos[1] = new JLabel();
        iconos[2] = new JLabel();
        iconos[3] = new JLabel();
        iconos[4] = new JLabel();
        iconos[5] = new JLabel();
        iconos[6] = new JLabel();
        iconos[7] = new JLabel();
        iconos[8] = new JLabel();
        String[] txt =
        {
            "Guardar", "Limpiar", "Buscar Registro", "Actualizar Registro", "Restablecer Registro", "Ordenar Ascendente", "Ordenar Descendente", "Ordenar Clave Ascendente", "Ordenar Clave Descendente"
        };
        String[] normal =
        {
            "guardar.png", "limpiar.png", "buscar_registro.png", "actualizar.png", "restablecer.png", "ordenar_a-z.png", "ordenar_z-a.png", "ordenar_1-9.png", "ordenar_9-1.png"
        };
        //String[] hover = {"guardar_Hover.png", "limpiar_Hover.png", "buscar_registro_Hover.png", "actualizar_Hover.png", "restablecer_Hover.png", "ordenar_a-z_Hover.png"};
        initHerramientas(txt, normal);

        iconos[0].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent evt)
            {
                iconos[0].setIcon(new ImageIcon(pathImagenes + normal[0]));
            }

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                iconos[0].setIcon(new ImageIcon(pathImagenes + "guardar_Hover.png"));
            }

            @Override
            public void mouseClicked(MouseEvent evt)
            {
                //JDialog customDialog = new JDialog(new JFrame(), "Ventana Emergente", true);
                VentanaEmergente customDialog = new VentanaEmergente(new JFrame(), "Buscar Registro");

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
                customDialog.setVisible(true);
            }
        });
        iconos[1].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent evt)
            {
                iconos[1].setIcon(new ImageIcon(pathImagenes + normal[1]));
            }

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                iconos[1].setIcon(new ImageIcon(pathImagenes + "limpiar_Hover.png"));
            }

            @Override
            public void mouseClicked(MouseEvent evt)
            {
                formularioRegistro.limpiarFormulario();
            }
        });
        iconos[2].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent evt)
            {
                iconos[2].setIcon(new ImageIcon(pathImagenes + normal[2]));
            }

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                iconos[2].setIcon(new ImageIcon(pathImagenes + "buscar_registro_Hover.png"));
            }

            @Override
            public void mouseClicked(MouseEvent evt)
            {
                //activarMenu(Menu.INICIO);
            }
        });
        iconos[3].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent evt)
            {
                iconos[3].setIcon(new ImageIcon(pathImagenes + normal[3]));
            }

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                iconos[3].setIcon(new ImageIcon(pathImagenes + "actualizar_Hover.png"));
            }

            @Override
            public void mouseClicked(MouseEvent evt)
            {
                //activarMenu(Menu.INICIO);
            }
        });
        iconos[4].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent evt)
            {
                iconos[4].setIcon(new ImageIcon(pathImagenes + normal[4]));
            }

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                iconos[4].setIcon(new ImageIcon(pathImagenes + "restablecer_Hover.png"));
            }

            @Override
            public void mouseClicked(MouseEvent evt)
            {
                //activarMenu(Menu.INICIO);
            }
        });
        iconos[5].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent evt)
            {
                iconos[5].setIcon(new ImageIcon(pathImagenes + normal[5]));
            }

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                iconos[5].setIcon(new ImageIcon(pathImagenes + "ordenar_a-z_Hover.png"));
            }

            @Override
            public void mouseClicked(MouseEvent evt)
            {
                //activarMenu(Menu.INICIO);
            }
        });
        iconos[6].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent evt)
            {
                iconos[6].setIcon(new ImageIcon(pathImagenes + normal[6]));
            }

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                iconos[6].setIcon(new ImageIcon(pathImagenes + "ordenar_z-a_Hover.png"));
            }

            @Override
            public void mouseClicked(MouseEvent evt)
            {
                //activarMenu(Menu.INICIO);
            }
        });
        iconos[7].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent evt)
            {
                iconos[7].setIcon(new ImageIcon(pathImagenes + normal[7]));
            }

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                iconos[7].setIcon(new ImageIcon(pathImagenes + "ordenar_1-9_Hover.png"));
            }

            @Override
            public void mouseClicked(MouseEvent evt)
            {
                //activarMenu(Menu.INICIO);
            }
        });
        iconos[8].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent evt)
            {
                iconos[8].setIcon(new ImageIcon(pathImagenes + normal[8]));
            }

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                iconos[8].setIcon(new ImageIcon(pathImagenes + "ordenar_9-1_Hover.png"));
            }

            @Override
            public void mouseClicked(MouseEvent evt)
            {
                //activarMenu(Menu.INICIO);
            }
        });

        habilitarHerraminetas(iconos[0], iconos[1]);
        panelHerramientas.add(iconos[0]);
        panelHerramientas.add(iconos[1]);
        panelHerramientas.add(iconos[2]);
        panelHerramientas.add(iconos[3]);
        panelHerramientas.add(iconos[4]);
        panelHerramientas.add(iconos[5]);
        panelHerramientas.add(iconos[6]);
        panelHerramientas.add(iconos[7]);
        panelHerramientas.add(iconos[8]);
    }

    private void initPanelSouth()
    {
        tabbedPane = new JTabbedPane();
        panelAreaTrabajo = new JPanel();
        panelAreaTrabajo.setBackground(Color.WHITE);
        panelAreaTrabajo.setBorder(new EmptyBorder(20, 0, 0, 0));
        panelAreaTrabajo.setLayout(new BorderLayout());
        //panelAreaTrabajo.setLayout(new FlowLayout());

        initPanelRegistrar();
        initPanelModificar();
        initPanelConsultar();
        initConsultaMedica();

        tabbedPane.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
                int selectedIndex = tabbedPane.getSelectedIndex();
                switch (selectedIndex)
                {
                    case 0:
                    case 3:
                        habilitarHerraminetas(iconos[0], iconos[1]);
                        break;
                    case 1:
                        habilitarHerraminetas(iconos[3], iconos[4]);

                        break;
                    case 2:
                        habilitarHerraminetas(iconos[2], iconos[5], iconos[6], iconos[7], iconos[8]);
                        break;
                }
            }
        });

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
        formularioRegistro = new Formulario(true);
        JPanel contenedor2 = new JPanel();

        JButton btnCancelar = new JButton("Cancelar");
        contenedor2.add(btnCancelar);
        JButton btnGuardar = new JButton("Guardar");
        contenedor2.add(btnGuardar);

        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
        contenedor.add(formularioRegistro);
        contenedor.add(contenedor2);
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
        contenedor3.setLayout(new BoxLayout(contenedor3, BoxLayout.Y_AXIS));
        contenedor3.add(formulario);
        contenedor3.add(contenedor2);
        conten.add(contenedor3);
        tabbedPane.addTab("Modificar Registros", null, conten);

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

    private void initPanelConsultar()
    {
        JPanel contenedor = new JPanel(new BorderLayout());

        /*Object[][] data =
        {
            {
                "001", "Ana Maria de la luz", "López", "Martínez", "Femenino", "Activo", "Sí", "No", "No", "No", "No", "No"
            },
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
        };*/
        
        Datos[] lista = (Datos[]) ManipulacionArchivos.cargaArch(contenedor, "personal.dat");

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Campo1"); // Nombre de la columna 1
        model.addColumn("Campo2"); // Nombre de la columna 2
        model.addColumn("Campo3"); // Nombre de la columna 2
        // Agregar más columnas según sea necesario

        // Llenar el modelo con los datos del arreglo
        for (Datos dato : lista) {
            if(dato instanceof Personal)
            {
                Object[] fila = {dato.getCve(), dato.getNom(), (((Personal) dato).getEstatus() == 1)?"Permante":"Tempora"};
                model.addRow(fila);
            } 
        }

        // Crear la tabla con el modelo de datos
        JTable table = new JTable(model);

        // Colocar la tabla en un JScrollPane si hay muchos datos
        JScrollPane scrollPane = new JScrollPane(table);
        
        // Nombres de las columnas
        String[] columnNames =
        {
            "Clave", "Nombre", "Primer A", "Segundo A", "Sexo", "Estatus", "Desnutricion", "Sobrepeso", "Alergias", "Obesida", "Diabetes", "Otra"
        };

        // Crea una nueva tabla con los datos y nombres de columnas
        //DefaultTableModel molde = new DefaultTableModel();
        //molde.setColumnIdentifiers(columnNames);
        //  molde.setDataVector(data, columnNames);
        //JTable table = new JTable(data, columnNames);
        /*DefaultTableModel model = new DefaultTableModel(lista, 13)
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false; // Desactivar la edición de las celdas
            }
        };*/
        //JTable table = new JTable(model);
        //table.setRowSelectionInterval(3, 3);
        //TableColumn column;

        // Crea un JScrollPane para agregar la tabla y permitir el desplazamiento si es necesario
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //table.setPreferredScrollableViewportSize(new Dimension(contenedor.getSize().width, contenedor.getSize().height));
      //  JScrollPane scrollPane = new JScrollPane(table);
        //table.setEnabled(false);
        //scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        //table.setEnabled(false);
        contenedor.add(scrollPane, BorderLayout.CENTER);
        tabbedPane.addTab("Consultar Registros", null, contenedor);
    }

    private void initConsultaMedica()
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
        contenedor3.setLayout(new BoxLayout(contenedor3, BoxLayout.Y_AXIS));
        contenedor3.add(formulario);
        contenedor3.add(contenedor2);
        conten.add(contenedor3);
        tabbedPane.addTab("Consulta Medica", null, conten);

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

    private void initHerramientas(String[] txt, String[] normal)
    {
        if (txt.length == normal.length && normal.length == iconos.length)
        {
            for (int i = 0; i < txt.length; i++)
            {
                ImageIcon img = new ImageIcon(pathImagenes + "" + normal[i]);
                iconos[i].setIcon(img);
                iconos[i].setBorder(new EmptyBorder(0, 0, 0, 5));
                iconos[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                iconos[i].setToolTipText(txt[i]);
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
                        (formularioRegistro.getRadioButton1().isSelected()) ? 'H':'M', 
                        formularioRegistro.getDesnutricion().isSelected(), formularioRegistro.getSobrepeso().isSelected(),
                        formularioRegistro.getAlergias().isSelected(), formularioRegistro.getObesidad().isSelected(), 
                        formularioRegistro.getDiabetes().isSelected(), formularioRegistro.getOtrasCual().getText());
                if(ctrl.ManipulacionArchivos.guardarReg(panelAreaTrabajo, personal, "personal.dat"))
                {
                    JOptionPane.showMessageDialog(panelAreaTrabajo, "Registro exitoso");
                }else
                {
                    JOptionPane.showMessageDialog(panelAreaTrabajo,"No se a podido guardar el Registo", "Error al guardar el registro", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        }
    }
}
