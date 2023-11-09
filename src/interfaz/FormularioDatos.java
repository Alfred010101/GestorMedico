package interfaz;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.KeyboardFocusManager;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author admin
 */
public class FormularioDatos extends JPanel
{
    private JTextField cve;
    private JTextField nombre;
    private JTextField primerAp;
    private JTextField segundoAp;
    
    private ButtonGroup group;
    private JRadioButton rbtMasculino;
    private JRadioButton rbtFemenino;
    
    private JComboBox estatus;
    private JComboBox viveCon;
    
    private JCheckBox desnutricion;
    private JCheckBox sobrepeso;
    private JCheckBox alergias;
    private JCheckBox obesidad;
    private JCheckBox diabetes;
    private JCheckBox otras;
    private JTextField otrasCual;
    
    private boolean tipoUsuario;
    
    final String pathImagenes = "src/interfaz/imagenes/";
    
    /**
     * Constructor para el formulario de registro
     * @param tipoUsuario indica si es Personal (V) o Alumnos (F)
     */
    public FormularioDatos(boolean tipoUsuario)
    {
        this.setLayout(new GridBagLayout());
        this.tipoUsuario = tipoUsuario;
        initComponets();
    }

    public FormularioDatos(Color rgb, boolean tipoUsuario)
    {
        this.setLayout(new GridBagLayout());
        this.setBackground(rgb);
        this.tipoUsuario = tipoUsuario;
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
     * @return the nombre
     */
    public JTextField getNombre()
    {
        return nombre;
    }

    /**
     * @return the primerAp
     */
    public JTextField getPrimerAp()
    {
        return primerAp;
    }

    /**
     * @return the segundoAp
     */
    public JTextField getSegundoAp()
    {
        return segundoAp;
    }

    /**
     * @return the group
     */
    public ButtonGroup getGroup()
    {
        return group;
    }

    /**
     * @return the rbtMasculino
     */
    public JRadioButton getRbtMasculino()
    {
        return rbtMasculino;
    }

    /**
     * @return the rbtFemenino
     */
    public JRadioButton getRbtFemenino()
    {
        return rbtFemenino;
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
    public JComboBox getViveCon()
    {
        return viveCon;
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
     * @return the type
     */
    public boolean isType()
    {
        return tipoUsuario;
    }

    /**
     * @param type the type to set
     */
    public void setType(boolean type)
    {
        this.tipoUsuario = type;
    }
    
     private void initComponets()
    {
        cve = new JTextField(12);
        nombre = new JTextField(18);
        primerAp = new JTextField(18);
        segundoAp = new JTextField(18);
        desnutricion = new JCheckBox("Desnutricion");
        sobrepeso = new JCheckBox("Sobrepeso");
        alergias = new JCheckBox("Alergias");
        obesidad = new JCheckBox("Obesidad");
        diabetes = new JCheckBox("Diabetes");
        otras = new JCheckBox("Otro");
        otrasCual = new JTextField(18);
        
        getOtrasCual().setEnabled(false);

        String[] opcEstatus;
        if (isType())
        {
            opcEstatus = new String[]
            {
                "", "Base", "Temporal"
            };
        } else
        {
            opcEstatus = new String[]
            {
                 "", "Ing. en Software", "Ing. en Produccion Industrical", "Ing. en Plasticos", "Ing. Mecanica", "Lic. en Seguridad Ciudadana"
            };
        }
        String[] opcVive= new String[]
        {
              "", "Mamá", "Papá", "Ambos"
        };

        viveCon = new JComboBox(opcVive);
        estatus = new JComboBox(opcEstatus);
        
        JPanel contenedor1 = new JPanel();
        contenedor1.setBorder(BorderFactory.createTitledBorder("Sexo"));
        group = new ButtonGroup();
        rbtMasculino = new JRadioButton("Masculino");
        rbtFemenino = new JRadioButton("Femenino");
        group.add(rbtMasculino);
        group.add(rbtFemenino);
        contenedor1.add(rbtMasculino);
        contenedor1.add(rbtFemenino);
        
        JPanel contenedor3 = new JPanel();
        JPanel contenedor4 = new JPanel();
        contenedor3.add(desnutricion);
        contenedor3.add(sobrepeso);
        contenedor3.add(alergias);        
        contenedor3.add(obesidad);
        contenedor4.add(diabetes);
        contenedor4.add(otras);
        contenedor4.add(otrasCual);
        JPanel contenedor2 = new JPanel(new GridLayout(2, 1));
        contenedor2.setBorder(BorderFactory.createTitledBorder("Padeciminetos"));
        contenedor2.add(contenedor3);
        contenedor2.add(contenedor4);
        
        
        this.add(new JLabel(new ImageIcon(pathImagenes+"avatar.png")), 
                new GridBagConstraints(2, 0, 1, 2, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(10, 5, 5, 5), 0, 0));
        this.add(new JLabel("Clave"), 
                new GridBagConstraints(0, 1, 2, 1, 0, 0, GridBagConstraints.SOUTH, GridBagConstraints.CENTER, new Insets(5, 5, 5, 5), 0, 0));
        this.add(cve, 
                new GridBagConstraints(0, 2, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(5, 5, 5, 5), 0, 0));
        this.add(new JLabel((tipoUsuario) ? "Estatus" : "Carrera"), 
                new GridBagConstraints(3, 1, 1, 1, 0, 0, GridBagConstraints.SOUTH, GridBagConstraints.CENTER, new Insets(5, 5, 5, 5), 0, 0));
        this.add(estatus, 
                new GridBagConstraints(3, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(5, 5, 5, 5), 0, 0));
        this.add(new JLabel("Nombre(s)"),
                new GridBagConstraints(0, 3, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(20, 5, 5, 5), 0, 0));
        this.add(nombre,
                new GridBagConstraints(0, 4, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(5, 5, 5, 5), 0, 0));
        this.add(new JLabel("Apellido Paterno"),
                new GridBagConstraints(2, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(20, 5, 5, 5), 0, 0));
        this.add(primerAp,
                new GridBagConstraints(2, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(5, 5, 5, 5), 0, 0));
        this.add(new JLabel("Apellido Materno"), 
                new GridBagConstraints(3, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(20, 5, 5, 5), 0, 0));
        this.add(segundoAp, 
                new GridBagConstraints(3, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(5, 5, 5, 5), 0, 0));
        if(!isType())
        {
            this.add(new JLabel("Vive con"), 
                new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.EAST, new Insets(20, 5, 5, 5), 0, 0));
            this.add(viveCon, 
                new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(20, 5, 5, 5), 0, 0));
        }
        this.add(contenedor1,
                new GridBagConstraints(0, 7, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(5, 5, 5, 5), 0, 0));
        this.add(contenedor2,
                new GridBagConstraints(2, 6, 2, 2, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(20, 5, 5, 5), 0, 0));

        getCve().addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                ctrl.Validaciones.validaAlfanumerico(e, 15, getCve().getText());
                //char c = e.getKeyChar();
                //System.out.println("Tecla Typed: " + c);
            }

            @Override
            public void keyPressed(KeyEvent e)
            {
                enterKeyPressed(e, getCve().getText(), getNombre());
            }
        });
        getNombre().addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                ctrl.Validaciones.validaAlfabeticos(e, 30, getNombre().getText());
            }

            @Override
            public void keyPressed(KeyEvent e)
            {
                enterKeyPressed(e, getNombre().getText(), getPrimerAp());
            }
        });
        getPrimerAp().addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                ctrl.Validaciones.validaAlfabeticos(e, 30, getPrimerAp().getText());
            }

            @Override
            public void keyPressed(KeyEvent e)
            {
                enterKeyPressed(e, getPrimerAp().getText(), getSegundoAp());
            }
        });
        getSegundoAp().addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                ctrl.Validaciones.validaAlfabeticos(e, 30, getSegundoAp().getText());
            }

            @Override
            public void keyPressed(KeyEvent e)
            {
                enterKeyPressed(e, getSegundoAp().getText(), getRbtMasculino());
            }
        });
        getRbtMasculino().addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && getRbtMasculino().isSelected())
                {
                    enterKeyPressed(e, getRbtMasculino().getText(), getEstatus());
                }
            }
        });
        getRbtFemenino().addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && getRbtFemenino().isSelected())
                {
                    enterKeyPressed(e, getRbtFemenino().getText(), getEstatus());
                }
            }
        });
        getEstatus().addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && getEstatus().getSelectedIndex() != 0)
                {
                    if (isType())
                    {
                        //enterKeyPressed(e, " ", getFecha());
                    } else
                    {
                        enterKeyPressed(e, " ", getViveCon());
                    }
                }
            }
        });
        getViveCon().addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && getEstatus().getSelectedIndex() != 0)
                {
                    //enterKeyPressed(e, " ", getFecha());
                }
            }
        });

        getOtras().addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                ctrl.CtrlInterfaz.itemStateChanged(getOtrasCual(), e);
            }
        });
        getOtrasCual().addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                ctrl.Validaciones.vanTxt(e);
            }
            
            @Override
            public void keyPressed(KeyEvent e)
            {
                //enterKeyPressed(e, otrasCual.getText(), padecimientoActual);
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (e.isShiftDown()) {
                        KeyboardFocusManager.getCurrentKeyboardFocusManager().focusPreviousComponent();
                        //ctrl.CtrlInterfaz.cambia(antecedentes);                        
                    } else {
                        e.consume();
                        KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
                        //ctrl.CtrlInterfaz.cambia(btnCan);
                    }
                }
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

    public boolean validarFormulario()
    {
        if (!ctrl.Validaciones.validarInputCve(this.getCve().getText()))
        {
            JOptionPane.showMessageDialog(null, "La clave no es valida, verifique y vuelva a intentar");
            ctrl.CtrlInterfaz.selecciona(getCve());
            return false;
        }
        if (!ctrl.Validaciones.validarInputNombre(this.getNombre().getText()))
        {
            JOptionPane.showMessageDialog(null, "El nombre no es valido,  verifique y vuelva a intentar");
            ctrl.CtrlInterfaz.selecciona(getNombre());
            return false;
        }
        if (!ctrl.Validaciones.validarInputNombre(this.getPrimerAp().getText()))
        {
            JOptionPane.showMessageDialog(null, "El apellido paterno no es valido, verifique y vuelva a intentar");
            ctrl.CtrlInterfaz.selecciona(getPrimerAp());
            return false;
        }
        if (!ctrl.Validaciones.validarInputNombre(this.getSegundoAp().getText()))
        {
            JOptionPane.showMessageDialog(null, "El apellido materno no es valido, verifique y vuelva a intentar");
            ctrl.CtrlInterfaz.selecciona(getSegundoAp());
            return false;
        }
        
        Date fecha;
        SimpleDateFormat formato1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formato2 = new SimpleDateFormat("dd-MM-yyyy");
        formato1.setLenient(false);
        formato2.setLenient(false);

//        try
//        {
//            fecha = formato1.parse(this.getFecha().getText());
//        } catch (ParseException ex1)
//        {
//            try
//            {
//                fecha = formato2.parse(this.getFecha().getText());
//            } catch (ParseException ex2)
//            {
//                JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto");
//                ctrl.CtrlInterfaz.selecciona(this.getFecha());
//                return false;
//            }
//        }
        return true;
    }
    
    public boolean camposVacios()
    {
        if (this.getCve().getText().trim().isEmpty())
        {
            ctrl.CtrlInterfaz.selecciona(getCve());
            return true;
        }
        if (this.getNombre().getText().trim().isEmpty())
        {
            ctrl.CtrlInterfaz.selecciona(getNombre());
            return true;
        }
        if (this.getPrimerAp().getText().trim().isEmpty())
        {
            ctrl.CtrlInterfaz.selecciona(getPrimerAp());
            return true;
        }
        if (this.getSegundoAp().getText().trim().isEmpty())
        {
            ctrl.CtrlInterfaz.selecciona(getSegundoAp());
            return true;
        }
        if (!this.getRbtMasculino().isSelected() && !this.getRbtFemenino().isSelected())
        {
            ctrl.CtrlInterfaz.cambia(getRbtMasculino());
            return true;
        }
        if (this.isType() && this.getEstatus().getSelectedIndex() == 0)
        {
            ctrl.CtrlInterfaz.cambia(getEstatus());
            return true;
        } else
        {
            if (this.getEstatus().getSelectedIndex() == 0)
            {
                ctrl.CtrlInterfaz.cambia(getEstatus());
                return true;
            }
        }
        if (!this.isType() && this.getViveCon().getSelectedIndex() == 0)
        {
            ctrl.CtrlInterfaz.cambia(getViveCon());
            return true;
        }
//        if(this.getFecha().getText().trim().isEmpty())
//        {
//            ctrl.CtrlInterfaz.selecciona(getFecha());
//            return true;
//        }
        if(this.getOtras().isSelected() && this.getOtrasCual().getText().trim().isEmpty())
        {
            ctrl.CtrlInterfaz.selecciona(getOtrasCual());
            return true;
        }
//        if(this.getPadecimientoActual().isSelected() && this.getPadecimientoCual().getText().trim().isEmpty())
//        {
//            ctrl.CtrlInterfaz.selecciona(padecimientoCual);
//            return true;
//        }
//        if(this.getPlanTratamiento().isSelected() && this.getPlanTratamientoCual().getText().trim().isEmpty())
//        {
//            ctrl.CtrlInterfaz.selecciona(planTratamientoCual);
//            return true;
//        }
//        if(this.getMedicamento().isSelected() && this.getMedicamentoCual().getText().trim().isEmpty())
//        {
//            ctrl.CtrlInterfaz.selecciona(medicamentoCual);
//            return true;
//        }
//        if(this.getAntecedentes().isSelected() && this.getAntecedentesCual().getText().trim().isEmpty())
//        {
//            ctrl.CtrlInterfaz.selecciona(antecedentesCual);
//            return true;
//        }
        return false;
    }
    
    public void limpiarFormulario()
    {
        ctrl.CtrlInterfaz.limpiarComponentes(null, getCve(), getNombre(), getPrimerAp(), getSegundoAp(), getEstatus(), getViveCon(), getGroup(), getDesnutricion(), getSobrepeso(), getAlergias(), getObesidad(), getDiabetes(), getOtras(), getOtrasCual());
    }

    public void habilitarComponentes(boolean enable)
    {
        getCve().setEnabled(false);
        getNombre().setEnabled(false);
        getPrimerAp().setEnabled(false);
        getSegundoAp().setEnabled(false);
        getEstatus().setEnabled(enable);
        if (!isType())
        {
            getViveCon().setEditable(enable);
        }
        getRbtMasculino().setEnabled(enable);
        getRbtFemenino().setEnabled(enable);
       // getFecha().setEnabled(enable);
        getDesnutricion().setEnabled(enable);
        getSobrepeso().setEnabled(enable);
        getAlergias().setEnabled(enable);
        getObesidad().setEnabled(enable);
        getDiabetes().setEnabled(enable);
        getOtras().setEnabled(enable);
        getOtrasCual().setEnabled(enable);
    }
}
