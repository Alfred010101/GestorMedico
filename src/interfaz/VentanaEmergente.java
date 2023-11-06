/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author admin
 */
public class VentanaEmergente extends JDialog
{

    private int mouseX, mouseY;
    final String pathImagenes = "src/interfaz/imagenes/";

    public VentanaEmergente(JFrame parentFrame, String subT)
    {
        super(parentFrame, subT, true);
        setLayout(new BorderLayout());

        ImagenPanel panelNorth = new ImagenPanel(new Color(133, 193, 233));
        JLabel closed = new JLabel(new ImageIcon(pathImagenes + "cerrar.png"));
        panelNorth.setBorder(new LineBorder(Color.GRAY, 2));
        panelNorth.setLayout(new BoxLayout(panelNorth, BoxLayout.X_AXIS));
        closed.setToolTipText("Cerrar");
        setUndecorated(true);
        panelNorth.add(Box.createHorizontalGlue());
        panelNorth.add(new JLabel(subT));
        panelNorth.add(Box.createHorizontalGlue());
        panelNorth.add(closed);
        add(panelNorth, BorderLayout.NORTH);

        panelNorth.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        panelNorth.addMouseMotionListener(new MouseAdapter()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                int x = e.getXOnScreen() - mouseX;
                int y = e.getYOnScreen() - mouseY;
                setLocation(x, y);
            }
        });
        
        closed.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent evt)
            {
                closed.setIcon(new ImageIcon(pathImagenes + "cerrar_Hover.png"));
            }

            @Override
            public void mouseExited(MouseEvent evt)
            {
                closed.setIcon(new ImageIcon(pathImagenes + "cerrar.png"));
            }

            @Override
            public void mouseClicked(MouseEvent e)
            {
                dispose();
            }
        });
    }
}
