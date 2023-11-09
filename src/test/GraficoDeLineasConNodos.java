/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author admin
 */
public class GraficoDeLineasConNodos extends JFrame {

    private int[] datosX = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90};  // Datos para el eje X
    private int[] datosY = {20, 45, 30, 70, 90, 75, 60, 80, 95, 70};  // Datos para el eje Y

    public GraficoDeLineasConNodos() {
        super("Gráfico de Líneas con Nodos");

        LineChartWithNodes lineChart = new LineChartWithNodes(datosX, datosY);
        add(lineChart, BorderLayout.CENTER);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GraficoDeLineasConNodos());
    }
}

class LineChartWithNodes extends JPanel {
    private int[] datosX;
    private int[] datosY;

    public LineChartWithNodes(int[] datosX, int[] datosY) {
        this.datosX = datosX;
        this.datosY = datosY;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        // Dibujar ejes X y Y
        g.drawLine(30, height - 30, width - 30, height - 30);  // Eje X
        g.drawLine(30, 30, 30, height - 30);  // Eje Y

        // Dibujar graduaciones en el eje X
        int incrementX = (width - 60) / (datosX.length - 1);
        for (int i = 0; i < datosX.length; i++) {
            int x = 30 + i * incrementX;
            g.drawLine(x, height - 35, x, height - 25);
            g.drawString(String.valueOf(datosX[i]), x - 5, height - 10);
        }

        // Dibujar graduaciones en el eje Y
        int incrementY = (height - 60) / 10;
        for (int i = 0; i <= 10; i++) {
            int y = height - 30 - i * incrementY;
            g.drawLine(25, y, 35, y);
            g.drawString(String.valueOf(i * 10), 5, y + 5);
        }

        // Dibujar la línea y nodos
        g.setColor(Color.BLUE);
        for (int i = 0; i < datosX.length - 1; i++) {
            int x1 = 30 + i * incrementX;
            int y1 = height - 30 - datosY[i] * incrementY / 10;
            int x2 = 30 + (i + 1) * incrementX;
            int y2 = height - 30 - datosY[i + 1] * incrementY / 10;
            g.drawLine(x1, y1, x2, y2);

            // Dibujar nodo en el vértice
            int nodeSize = 6;
            g.fillOval(x1 - nodeSize / 2, y1 - nodeSize / 2, nodeSize, nodeSize);
            g.fillOval(x2 - nodeSize / 2, y2 - nodeSize / 2, nodeSize, nodeSize);
        }
    }
}