package interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author admin
 */
public class FormularioMedico extends JPanel
{
    private JCheckBox padecimientoActual;
    private JTextArea padecimientoCual;
    private JCheckBox antecedentes;
    private JTextArea antecedentesCual;
    private JCheckBox medicamento;
    private JTextArea medicamentoCual;
    private JCheckBox planTratamiento;
    private JTextArea planTratamientoCual;
    private JTextField fecha;

    public FormularioMedico()
    {
        this.setLayout(new GridBagLayout());
        initComponets();
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
        fecha = new JTextField(7);
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
        
        this.add( new JLabel("Fecha"), 
                new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.CENTER, new Insets(15, 5, 5, 5), 0, 0));
        this.add( fecha, 
                new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.CENTER, new Insets(15, 5, 5, 5), 0, 0));
        this.add( padecimientoActual, 
                new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.CENTER, new Insets(15, 15, 5, 5), 0, 0));
        this.add(padecimientoCual, 
                new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.SOUTH, GridBagConstraints.CENTER, new Insets(5, 15, 5, 5), 0, 0));
        this.add(planTratamiento, 
                new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.CENTER, new Insets(15, 15, 5, 5), 0, 0));
        this.add(planTratamientoCual, 
                new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.SOUTH, GridBagConstraints.CENTER, new Insets(5, 15, 5, 15), 0, 0));
        
        this.add(medicamento, 
                new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.CENTER, new Insets(15, 15, 5, 5), 0, 0));
        this.add(medicamentoCual, 
                new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(5, 15, 15, 5), 0, 0));
        this.add(antecedentes, 
                new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.CENTER, new Insets(15, 15, 5, 5), 0, 0));
        this.add(antecedentesCual, 
                new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.SOUTH, GridBagConstraints.CENTER, new Insets(5, 15, 15, 15), 0, 0));
        
        
    }
}
