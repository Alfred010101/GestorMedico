package interfaz;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author admin
 */
public class Formulario extends JPanel
{

    private JTextField cve;
    private JTextField nombre;
    private JTextField primerAp;
    private JTextField segundoAp;
    private char sexo;
    private JCheckBox desnutricion;
    private JCheckBox sobrepeso;
    private JCheckBox alergias;
    private JCheckBox obesidad;
    private JCheckBox diabetes;
    private JCheckBox otras;
    private JTextField otrasCual;

    private JComboBox estatus;
    private JComboBox carrera;

    private JCheckBox padecimientoActual;
    private JTextArea padecimientoCual;
    private JCheckBox antecedentes;
    private JTextArea antecedentesCual;
    private JCheckBox medicamento;
    private JTextArea medicamentoCual;
    private JCheckBox planTratamiento;
    private JTextArea planTratamientoCual;
    private JTextField fecha;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    final private boolean type;

    public Formulario(boolean type)
    {
        this.setLayout(new GridBagLayout());
        this.type = type;
        initComponets();
    }

    public Formulario(Color rgb, boolean type)
    {
        this.setLayout(new GridBagLayout());
        this.setBackground(rgb);
        this.type = type;
        initComponets();
    }

    /**
     * @return the cve
     */
    public JTextField getCve()
    {
        return cve;
    }

    /**
     * @return the primerAp
     */
    public JTextField getPrimerAp()
    {
        return primerAp;
    }

    /**
     * @return the nombre
     */
    public JTextField getNombre()
    {
        return nombre;
    }

    /**
     * @return the segundoAp
     */
    public JTextField getSegundoAp()
    {
        return segundoAp;
    }

    /**
     * @return the sexo
     */
    public char getSexo()
    {
        return sexo;
    }

    /**
     * @return the desnutricion
     */
    public JCheckBox getDesnutricion()
    {
        return desnutricion;
    }

    /**
     * @return the sobrepeso
     */
    public JCheckBox getSobrepeso()
    {
        return sobrepeso;
    }

    /**
     * @return the alergias
     */
    public JCheckBox getAlergias()
    {
        return alergias;
    }

    /**
     * @return the obesidad
     */
    public JCheckBox getObesidad()
    {
        return obesidad;
    }

    /**
     * @return the diabetes
     */
    public JCheckBox getDiabetes()
    {
        return diabetes;
    }

    /**
     * @return the otras
     */
    public JCheckBox getOtras()
    {
        return otras;
    }

    /**
     * @return the otrasCual
     */
    public JTextField getOtrasCual()
    {
        return otrasCual;
    }

    /**
     * @return the estatus
     */
    public JComboBox getEstatus()
    {
        return estatus;
    }

    /**
     * @return the carrera
     */
    public JComboBox getCarrera()
    {
        return carrera;
    }

    /**
     * @return the padecimientoActual
     */
    public JCheckBox getPadecimientoActual()
    {
        return padecimientoActual;
    }

    /**
     * @return the padecimientoCual
     */
    public JTextArea getPadecimientoCual()
    {
        return padecimientoCual;
    }

    /**
     * @return the antecedentes
     */
    public JCheckBox getAntecedentes()
    {
        return antecedentes;
    }

    /**
     * @return the antecedentesCual
     */
    public JTextArea getAntecedentesCual()
    {
        return antecedentesCual;
    }

    /**
     * @return the medicamento
     */
    public JCheckBox getMedicamento()
    {
        return medicamento;
    }

    /**
     * @return the medicamentoCual
     */
    public JTextArea getMedicamentoCual()
    {
        return medicamentoCual;
    }

    /**
     * @return the planTratamiento
     */
    public JCheckBox getPlanTratamiento()
    {
        return planTratamiento;
    }

    /**
     * @return the planTratamientoCual
     */
    public JTextArea getPlanTratamientoCual()
    {
        return planTratamientoCual;
    }

    /**
     * @return the fecha
     */
    public JTextField getFecha()
    {
        return fecha;
    }

    private void initComponets()
    {
        cve = new JTextField(12);
        nombre = new JTextField(18);
        primerAp = new JTextField(18);
        segundoAp = new JTextField(18);
        sexo = 'H';
        desnutricion = new JCheckBox("Desnutricion");
        sobrepeso = new JCheckBox("Sobrepeso");
        alergias = new JCheckBox("Alergias");
        obesidad = new JCheckBox("Obesidad");
        diabetes = new JCheckBox("Diabetes");
        otras = new JCheckBox("Otras");
        otrasCual = new JTextField(18);
        otrasCual.setEnabled(false);
        
        padecimientoActual = new JCheckBox("Padecimineto Actual");
        padecimientoCual = new JTextArea(7, 35);
        padecimientoCual.setEnabled(false);
        antecedentes = new JCheckBox("Antecedentes");
        antecedentesCual = new JTextArea(7, 35);
        antecedentesCual.setEnabled(false);
        medicamento = new JCheckBox("Medicamento");
        medicamentoCual = new JTextArea(7, 35);
        medicamentoCual.setEnabled(false);
        planTratamiento = new JCheckBox("Plan de tratamiento");
        planTratamientoCual = new JTextArea(7, 35);
        planTratamientoCual.setEnabled(false);
        fecha = new JTextField(6);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(new JLabel("Nombre(s)"), gbc);
        gbc.gridx = 2;
        this.add(new JLabel("Apellido Paterno"), gbc);
        gbc.gridx = 3;
        this.add(new JLabel("Apellido Materno"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JPanel contenedor1 = new JPanel(new FlowLayout());
        contenedor1.add(new JLabel("Clave"));
        contenedor1.add(cve);
        this.add(contenedor1, gbc);

        gbc.gridx = 1;
        this.add(nombre, gbc);
        gbc.gridx = 2;
        this.add(primerAp, gbc);
        gbc.gridx = 3;
        this.add(segundoAp, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Sexo");
        JPanel panelSexo = new JPanel();
        panelSexo.setBorder(titledBorder);
        radioButton1 = new JRadioButton("Hombre");
        radioButton2 = new JRadioButton("Mujer");
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        panelSexo.add(radioButton1);
        panelSexo.add(radioButton2);
        this.add(panelSexo, gbc);

        gbc.gridx = 2;
        String[] opcEstatus;
        if (type)
        {
            opcEstatus = new String[]
            {
                "", "Base", "Temporal"
            };
            carrera = new JComboBox(opcEstatus);
        } else
        {
            opcEstatus = new String[]
            {
                "", "Mamá", "Papá", "Ambos"
            };
            String[] opcCarrera = new String[]
            {
                "", "Carrera 1", "Carrera 2", "Carrera 3", "Carrera 4"
            };
            JPanel contenerdor = new JPanel();
            carrera = new JComboBox(opcCarrera);
            contenerdor.add(new JLabel("Carrera"));
            contenerdor.add(carrera);
            this.add(contenerdor, gbc);
            gbc.gridx = 1;
        }

        JPanel contenedor2 = new JPanel(new FlowLayout());
        estatus = new JComboBox(opcEstatus);
        contenedor2.add(new JLabel((type) ? "Estatus" : "Vive Con"));
        contenedor2.add(estatus);
        this.add(contenedor2, gbc);

        gbc.gridx = 3;
        JPanel contenedor = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contenedor.add(new JLabel("Fecha"));
        contenedor.add(fecha);
        this.add(contenedor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        JPanel panelPadecimientos = new JPanel();
        titledBorder = BorderFactory.createTitledBorder("Padecimientos");
        panelPadecimientos.setBorder(titledBorder);

        panelPadecimientos.add(desnutricion);
        panelPadecimientos.add(sobrepeso);
        panelPadecimientos.add(alergias);
        panelPadecimientos.add(obesidad);
        panelPadecimientos.add(diabetes);
        panelPadecimientos.add(otras);
        panelPadecimientos.add(otrasCual);
        this.add(panelPadecimientos, gbc);

        JPanel contenedor3 = new JPanel();
        contenedor3.setLayout(new BoxLayout(contenedor3, BoxLayout.Y_AXIS));
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JScrollPane scrollPane1 = new JScrollPane(padecimientoCual);
        contenedor3.add(padecimientoActual);
        contenedor3.add(scrollPane1);
        this.add(contenedor3, gbc);

        JPanel contenedor4 = new JPanel();
        contenedor4.setLayout(new BoxLayout(contenedor4, BoxLayout.Y_AXIS));

        gbc.gridy = 5;
        JScrollPane scrollPane2 = new JScrollPane(medicamentoCual);
        contenedor4.add(medicamento);
        contenedor4.add(scrollPane2);
        this.add(contenedor4, gbc);

        JPanel contenedor5 = new JPanel();
        contenedor5.setLayout(new BoxLayout(contenedor5, BoxLayout.Y_AXIS));
        gbc.gridx = 2;
        JScrollPane scrollPane3 = new JScrollPane(antecedentesCual);
        contenedor5.add(antecedentes);
        contenedor5.add(scrollPane3);
        this.add(contenedor5, gbc);

        JPanel contenedor6 = new JPanel();
        contenedor6.setLayout(new BoxLayout(contenedor6, BoxLayout.Y_AXIS));
        gbc.gridy = 4;
        JScrollPane scrollPane4 = new JScrollPane(planTratamientoCual);
        contenedor6.add(planTratamiento);
        contenedor6.add(scrollPane4);
        this.add(contenedor6, gbc);

        cve.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                ctrl.Validaciones.validaAlfanumerico(e, 15, cve.getText());
                //char c = e.getKeyChar();
                //System.out.println("Tecla Typed: " + c);
            }

            @Override
            public void keyPressed(KeyEvent e)
            {
                enterKeyPressed(e, cve.getText(), nombre);
            }
        });
        nombre.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                ctrl.Validaciones.validaAlfabeticos(e, 30, nombre.getText());
            }

            @Override
            public void keyPressed(KeyEvent e)
            {
                enterKeyPressed(e, nombre.getText(), primerAp);
            }
        });
        primerAp.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                ctrl.Validaciones.validaAlfabeticos(e, 30, primerAp.getText());
            }

            @Override
            public void keyPressed(KeyEvent e)
            {
                enterKeyPressed(e, primerAp.getText(), segundoAp);
            }
        });
        segundoAp.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                ctrl.Validaciones.validaAlfabeticos(e, 30, segundoAp.getText());
            }

            @Override
            public void keyPressed(KeyEvent e)
            {
                enterKeyPressed(e, segundoAp.getText(), radioButton1);
            }
        });
        radioButton1.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && radioButton1.isSelected())
                {
                    enterKeyPressed(e, radioButton1.getText(), estatus);
                }
            }
        });
        radioButton2.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && radioButton2.isSelected())
                {
                    enterKeyPressed(e, radioButton2.getText(), estatus);
                }
            }
        });
        estatus.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && estatus.getSelectedIndex() != 0)
                {
                    if (type)
                    {
                        enterKeyPressed(e, " ", fecha);
                    } else
                    {
                        enterKeyPressed(e, " ", carrera);
                    }
                }
            }
        });
        carrera.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && estatus.getSelectedIndex() != 0)
                {
                    enterKeyPressed(e, " ", fecha);
                }
            }
        });
        fecha.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                ctrl.Validaciones.validarFecha(e, fecha.getText(), 10);
            }
            
            @Override
            public void keyPressed(KeyEvent e)
            {
                enterKeyPressed(e, fecha.getText(), desnutricion);
            }
        });
        
        otras.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                ctrl.CtrlInterfaz.itemStateChanged(otrasCual, e);
            }
        });
        otrasCual.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                enterKeyPressed(e, otrasCual.getText(), padecimientoActual);
            }
        });
        padecimientoActual.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                ctrl.CtrlInterfaz.itemStateChanged(padecimientoCual, e);
            }
        });
        planTratamiento.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                ctrl.CtrlInterfaz.itemStateChanged(planTratamientoCual, e);
            }
        });
        medicamento.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                ctrl.CtrlInterfaz.itemStateChanged(medicamentoCual, e);
            }
        });
        antecedentes.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                ctrl.CtrlInterfaz.itemStateChanged(antecedentesCual, e);
            }
        });
    }

    private void enterKeyPressed(KeyEvent e, String s, Object obj)
    {
        if (!s.isEmpty())
        {
            ctrl.Validaciones.enter(this, e, obj);
        }
    }

    public void habilitarComponentes(boolean enable)
    {
        cve.setEnabled(false);
        nombre.setEnabled(false);
        primerAp.setEnabled(false);
        segundoAp.setEnabled(false);
        estatus.setEnabled(enable);
        if (!type)
        {
            carrera.setEditable(enable);
        }
        radioButton1.setEnabled(enable);
        radioButton2.setEnabled(enable);
        fecha.setEnabled(enable);
        desnutricion.setEnabled(enable);
        sobrepeso.setEnabled(enable);
        alergias.setEnabled(enable);
        obesidad.setEnabled(enable);
        diabetes.setEnabled(enable);
        otras.setEnabled(enable);
        otrasCual.setEnabled(enable);
        padecimientoActual.setEnabled(enable);
        padecimientoCual.setEnabled(enable);
        medicamento.setEnabled(enable);
        medicamentoCual.setEnabled(enable);
        planTratamiento.setEnabled(enable);
        planTratamientoCual.setEnabled(enable);
        antecedentes.setEnabled(enable);
        antecedentesCual.setEnabled(enable);
    }
}
