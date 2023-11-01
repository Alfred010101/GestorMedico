package interfaz;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
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

    private JTextField nombre = new JTextField(18);
    public Formulario()
    {
        this.setLayout(new GridBagLayout());
        initComponets();
    }

    public Formulario(Color rgb)
    {
        this.setLayout(new GridBagLayout());
        this.setBackground(rgb);
        initComponets();
    }

    private void initComponets()
    {
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
        contenedor1.add(new JTextField(12));
        this.add(contenedor1, gbc);

        gbc.gridx = 1;
        this.add(new JTextField(18), gbc);
        gbc.gridx = 2;
        this.add(getNombre(), gbc);
        gbc.gridx = 3;
        this.add(new JTextField(18), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        String[] opcEstatus =
        {
            "Base", "Temporal"
        };
        JPanel contenedor2 = new JPanel(new FlowLayout());
        JComboBox estatus = new JComboBox(opcEstatus);
        contenedor2.add(new JLabel("Estatus"));
        contenedor2.add(estatus);
        this.add(contenedor2, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Sexo");
        JPanel panelSexo = new JPanel();
        panelSexo.setBorder(titledBorder);
        JRadioButton radioButton1 = new JRadioButton("Hombre");
        JRadioButton radioButton2 = new JRadioButton("Mujer");
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        panelSexo.add(radioButton1);
        panelSexo.add(radioButton2);
        this.add(panelSexo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
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
        panelPadecimientos.add(desnutricion);
        panelPadecimientos.add(sobrepeso);
        panelPadecimientos.add(alergias);
        panelPadecimientos.add(obesidad);
        panelPadecimientos.add(diabetes);
        panelPadecimientos.add(otras);
        panelPadecimientos.add(otrasText);
        this.add(panelPadecimientos, gbc);

        JPanel contenedor3 = new JPanel();
        contenedor3.setLayout(new BoxLayout(contenedor3, BoxLayout.Y_AXIS));
        JCheckBox padecimientoActual = new JCheckBox("Padecimiento Actual");
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JTextArea text1 = new JTextArea(7, 35);
        JScrollPane scrollPane1 = new JScrollPane(text1);
        contenedor3.add(padecimientoActual);
        contenedor3.add(scrollPane1);
        this.add(contenedor3, gbc);

        JPanel contenedor4 = new JPanel();
        contenedor4.setLayout(new BoxLayout(contenedor4, BoxLayout.Y_AXIS));
        JCheckBox medicamento = new JCheckBox("Medicamento");
        gbc.gridy = 5;
        JTextArea text2 = new JTextArea(7, 35);
        JScrollPane scrollPane2 = new JScrollPane(text2);
        contenedor4.add(medicamento);
        contenedor4.add(scrollPane2);
        this.add(contenedor4, gbc);

        JPanel contenedor5 = new JPanel();
        contenedor5.setLayout(new BoxLayout(contenedor5, BoxLayout.Y_AXIS));
        JCheckBox antecedentes = new JCheckBox("Antecedentes");
        gbc.gridx = 2;
        JTextArea text3 = new JTextArea(7, 35);
        JScrollPane scrollPane3 = new JScrollPane(text3);
        contenedor5.add(antecedentes);
        contenedor5.add(scrollPane3);
        this.add(contenedor5, gbc);

        JPanel contenedor6 = new JPanel();
        contenedor6.setLayout(new BoxLayout(contenedor6, BoxLayout.Y_AXIS));
        JCheckBox tratamiento = new JCheckBox("Tratamiento");
        gbc.gridy = 4;
        JTextArea text4 = new JTextArea(7, 35);
        JScrollPane scrollPane4 = new JScrollPane(text4);
        contenedor6.add(tratamiento);
        contenedor6.add(scrollPane4);
        this.add(contenedor6, gbc);

        JPanel contenedor7 = new JPanel();
        //contenedor6.setLayout(new BoxLayout(contenedor6, BoxLayout.Y_AXIS));
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        JButton btn = new JButton("Cancelar");
        contenedor7.add(btn, gbc);
        gbc.gridx = 3;
        JButton btn2 = new JButton("Guardar");
        contenedor7.add(btn2, gbc);
        //this.add(contenedor7, gbc);
    }

    /**
     * @return the nombre
     */
    public JTextField getNombre()
    {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(JTextField nombre)
    {
        this.nombre = nombre;
    }

}
