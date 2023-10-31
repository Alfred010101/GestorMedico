
package interfaz;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author admin
 */

class ImagenPanel extends JPanel
{
    final private Image image;

    public ImagenPanel(String imagePath)
    {
        this.image = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
