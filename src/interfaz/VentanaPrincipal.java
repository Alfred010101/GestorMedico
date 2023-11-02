package interfaz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author alfredo
 */
public class VentanaPrincipal extends JFrame
{

    private JPanel panelPrincipal;
    private JPanel panelNorth;
    private JPanel panelWest;
    private JPanel panelCenter;
    private CardLayout cardLayout;

    private MenuInicio menuInicio;
    private MenuPersonal menuPersonal;
    private MenuEstudiantes menuEstudiantes;
    private MenuBuscar menuBuscar;

    private int mouseX, mouseY;

    private enum Menu
    {
        INICIO,
        PERSONAL,
        ESTUDIANTES,
        BUSCAR,
        AYUDA
    }
    private Menu menuActivo;

    final private JLabel[] opcMenu = new JLabel[5];
    final String imgMenu[] =
    {
        "inicio.png", "personal.png", "estudiantes.png", "buscar.png"
    };
    final String imgMenuActivo[] =
    {
        "inicio_Activo.png", "personal_Activo.png", "estudiantes_Activo.png", "buscar_Activo.png"
    };

    final String pathImagenes = "src/interfaz/imagenes/";

    private boolean maximized = true;

    public VentanaPrincipal()
    {
        initComponents();

        menuActivo = Menu.INICIO;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setUndecorated(true);
        this.add(panelPrincipal);
        this.setSize(1200, 700);
    }

    /**
     * Configura el panelPrincipal Y se agregan el resto de los paneles
     */
    private void initComponents()
    {
        panelPrincipal = new JPanel();
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBorder(new LineBorder(Color.GRAY, 2));

        panelNorth = new ImagenPanel(new Color(133, 193, 233));
        panelWest = new JPanel();
        panelCenter = new JPanel();

        cardLayout = new CardLayout();
        panelCenter.setLayout(cardLayout);

        initPanelNorth();
        initPanelWest();
        initPanelCenter();

        panelPrincipal.add(panelNorth, BorderLayout.NORTH);
        panelPrincipal.add(panelWest, BorderLayout.WEST);
        panelPrincipal.add(panelCenter, BorderLayout.CENTER);
    }

    /**
     * Configura el panelNorth Trabaja como la barra de titulo de un JFrame
     */
    private void initPanelNorth()
    {

        //panelNorth.setBackground(new Color(174, 214, 241));
        JLabel icono = new JLabel(new ImageIcon(pathImagenes + "logo.png"));
        JLabel titulo = new JLabel("Departamento de Servicios de Salud");
        JLabel minimizar = new JLabel(new ImageIcon(pathImagenes + "minimizar.png"));
        JLabel redimencionar = new JLabel(new ImageIcon(pathImagenes + "redimencionar.png"));
        JLabel closed = new JLabel(new ImageIcon(pathImagenes + "cerrar.png"));

        panelNorth.setLayout(new BoxLayout(panelNorth, BoxLayout.X_AXIS));

        minimizar.setToolTipText("Minimizar");
        closed.setToolTipText("Cerrar");

        panelNorth.add(icono);
        panelNorth.add(Box.createHorizontalGlue());
        panelNorth.add(titulo);
        panelNorth.add(Box.createHorizontalGlue());
        panelNorth.add(minimizar);
        panelNorth.add(redimencionar);
        panelNorth.add(closed);

        icono.setBorder(new EmptyBorder(0, 25, 0, 0));

        minimizar.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent evt)
            {
                minimizar.setIcon(new ImageIcon(pathImagenes + "minimizar_Hover.png"));
            }

            @Override
            public void mouseExited(MouseEvent evt)
            {
                minimizar.setIcon(new ImageIcon(pathImagenes + "minimizar.png"));
            }

            @Override
            public void mouseClicked(MouseEvent e)
            {
                setExtendedState(JFrame.ICONIFIED);
            }
        });

        redimencionar.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent evt)
            {
                String i = (maximized) ? "redimencionar_Hover.png" : "redimencionar2_Hover.png";
                redimencionar.setIcon(new ImageIcon(pathImagenes + i));
            }

            @Override
            public void mouseExited(MouseEvent evt)
            {
                String i = (maximized) ? "redimencionar.png" : "redimencionar2.png";
                redimencionar.setIcon(new ImageIcon(pathImagenes + i));
            }

            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (maximized)
                {
                    setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizar la ventana
                    redimencionar.setToolTipText("Restaurar");
                } else
                {
                    setExtendedState(JFrame.NORMAL); // Restaurar la ventana al tamaño original
                    redimencionar.setToolTipText("Maximizar");
                }
                mouseExited(e);
                maximized = !maximized; // Alternar el estado
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
                System.exit(0);
            }
        });

        panelNorth.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                // Captura las coordenadas del mouse cuando se presiona
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        panelNorth.addMouseMotionListener(new MouseAdapter()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                // Calcula las nuevas coordenadas del mouse
                int x = e.getXOnScreen() - mouseX;
                int y = e.getYOnScreen() - mouseY;
                // Mueve la ventana a las nuevas coordenadas
                setLocation(x, y);
            }
        });
    }

    /**
     * Configura el panelWest Trabaja como la barra de menu
     */
    private void initPanelWest()
    {
        panelWest.setBackground(new Color(236, 236, 236));
        panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.Y_AXIS));

        opcMenu[Menu.INICIO.ordinal()] = new JLabel(new ImageIcon(pathImagenes + imgMenuActivo[0]));
        opcMenu[Menu.PERSONAL.ordinal()] = new JLabel(new ImageIcon(pathImagenes + imgMenu[1]));
        opcMenu[Menu.ESTUDIANTES.ordinal()] = new JLabel(new ImageIcon(pathImagenes + imgMenu[2]));
        opcMenu[Menu.BUSCAR.ordinal()] = new JLabel(new ImageIcon(pathImagenes + imgMenu[3]));
        opcMenu[Menu.AYUDA.ordinal()] = new JLabel(new ImageIcon(pathImagenes + "ayuda.png"));

        opcMenu[Menu.INICIO.ordinal()].setToolTipText("Inicio");
        opcMenu[Menu.PERSONAL.ordinal()].setToolTipText("Personal");
        opcMenu[Menu.ESTUDIANTES.ordinal()].setToolTipText("Estudiantes");
        opcMenu[Menu.BUSCAR.ordinal()].setToolTipText("Buscar");
        opcMenu[Menu.AYUDA.ordinal()].setToolTipText("Ayuda");
        opcMenu[Menu.AYUDA.ordinal()].setCursor(new Cursor(Cursor.HAND_CURSOR));

        panelWest.add(opcMenu[0]);
        panelWest.add(opcMenu[1]);
        panelWest.add(opcMenu[2]);
        panelWest.add(opcMenu[3]);
        panelWest.add(Box.createVerticalGlue());
        panelWest.add(opcMenu[4]);

        opcMenu[Menu.INICIO.ordinal()].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent evt)
            {
                if (menuActivo != Menu.INICIO)
                {
                    opcMenu[Menu.INICIO.ordinal()].setIcon(new ImageIcon(pathImagenes + imgMenu[0]));
                }
            }

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                if (menuActivo != Menu.INICIO)
                {
                    opcMenu[Menu.INICIO.ordinal()].setIcon(new ImageIcon(pathImagenes + "inicio_Hover.png"));
                }
            }

            @Override
            public void mouseClicked(MouseEvent evt)
            {
                activarMenu(Menu.INICIO);
            }
        });

        opcMenu[Menu.PERSONAL.ordinal()].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent evt)
            {
                if (menuActivo != Menu.PERSONAL)
                {
                    opcMenu[Menu.PERSONAL.ordinal()].setIcon(new ImageIcon(pathImagenes + imgMenu[1]));
                }
            }

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                if (menuActivo != Menu.PERSONAL)
                {
                    opcMenu[Menu.PERSONAL.ordinal()].setIcon(new ImageIcon(pathImagenes + "personal_Hover.png"));
                }
            }

            @Override
            public void mouseClicked(MouseEvent evt)
            {
                activarMenu(Menu.PERSONAL);
            }
        });

        opcMenu[Menu.ESTUDIANTES.ordinal()].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent evt)
            {
                if (menuActivo != Menu.ESTUDIANTES)
                {
                    opcMenu[Menu.ESTUDIANTES.ordinal()].setIcon(new ImageIcon(pathImagenes + imgMenu[2]));
                }
            }

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                if (menuActivo != Menu.ESTUDIANTES)
                {
                    opcMenu[Menu.ESTUDIANTES.ordinal()].setIcon(new ImageIcon(pathImagenes + "estudiantes_Hover.png"));
                }
            }

            @Override
            public void mouseClicked(MouseEvent evt)
            {
                activarMenu(Menu.ESTUDIANTES);
            }
        });

        opcMenu[Menu.BUSCAR.ordinal()].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent evt)
            {
                if (menuActivo != Menu.BUSCAR)
                {
                    opcMenu[Menu.BUSCAR.ordinal()].setIcon(new ImageIcon(pathImagenes + imgMenu[3]));
                }
            }

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                if (menuActivo != Menu.BUSCAR)
                {
                    opcMenu[Menu.BUSCAR.ordinal()].setIcon(new ImageIcon(pathImagenes + "buscar_Hover.png"));
                }
            }

            @Override
            public void mouseClicked(MouseEvent evt)
            {
                activarMenu(Menu.BUSCAR);
            }

        });

        opcMenu[Menu.AYUDA.ordinal()].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent evt)
            {
                opcMenu[Menu.AYUDA.ordinal()].setIcon(new ImageIcon(pathImagenes + "ayuda.png"));
            }

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                opcMenu[Menu.AYUDA.ordinal()].setIcon(new ImageIcon(pathImagenes + "ayuda_Hover.png"));
            }

            @Override
            public void mousePressed(MouseEvent evt)
            {
                try
                {
                    String rutaRelativa = "src/Manual/C_+_+.pdf";
                    File archivo = new File(rutaRelativa);
                    URI uri = archivo.toURI();
                    Desktop.getDesktop().browse(uri);
                } catch (IOException e)
                {
                }

            }
        });
    }

    /**
     * En el panelCenter se muestra la vista de cada opcion de menu
     */
    private void initPanelCenter()
    {
        menuInicio = new MenuInicio();
        menuPersonal = new MenuPersonal();
        menuEstudiantes = new MenuEstudiantes();
        menuBuscar = new MenuBuscar();

        panelCenter.add(menuInicio, "Panel 0");
        panelCenter.add(menuPersonal, "Panel 1");
        panelCenter.add(menuEstudiantes, "Panel 2");
        panelCenter.add(menuBuscar, "Panel 3");
    }

    private void activarMenu(Menu menuIr)
    {
        if (menuIr != menuActivo)
        {
            opcMenu[menuActivo.ordinal()].setIcon(new ImageIcon(pathImagenes + imgMenu[menuActivo.ordinal()]));
            opcMenu[menuIr.ordinal()].setIcon(new ImageIcon(pathImagenes + imgMenuActivo[menuIr.ordinal()]));
            menuActivo = menuIr;
            cardLayout.show(panelCenter, "Panel " + menuActivo.ordinal());
        }
    }
}
