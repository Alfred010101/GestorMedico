
package interfaz;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alfredo
 */
public class MenuEstudiantes extends JPanel
{
    public MenuEstudiantes()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        this.setBackground(Color.WHITE);
        this.add(new JLabel("Menu Estudiantes"));
        this.add(new JButton("Test 3"));
    }
}