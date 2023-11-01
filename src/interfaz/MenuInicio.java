
package interfaz;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alfredo
 */
public class MenuInicio extends JPanel
{
    public MenuInicio()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        this.setBackground(Color.WHITE);
        this.add(new JLabel("Menu Inicio"));
        this.add(new JButton("Test 1"));
    }    
}
