
package interfaz;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alfredo
 */
public class MenuBuscar extends JPanel
{
    public MenuBuscar()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        this.setBackground(Color.WHITE);
        this.add(new JLabel("Menu Buscar"));
        this.add(new JButton("Test 4"));
    }
}