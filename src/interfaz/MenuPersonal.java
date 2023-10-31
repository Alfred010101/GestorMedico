
package interfaz;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author admin
 */
public class MenuPersonal extends JPanel
{
    public MenuPersonal()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        this.setBackground(Color.WHITE);
        this.add(new JLabel("Menu Personal"));
        this.add(new JButton("Test 2"));
    }   
}
    