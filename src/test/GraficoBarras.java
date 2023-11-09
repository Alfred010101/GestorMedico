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

import javax.swing.*;
import java.awt.*;

public class GraficoBarras extends JFrame {

    public GraficoBarras() {
        super("Distribución de Género");

        int hombres = 100; // Porcentaje de hombres
        int mujeres = 80;  // Porcentaje de mujeres

        BarChart barChart = new BarChart(hombres, mujeres);
        add(barChart, BorderLayout.CENTER);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GraficoBarras());
    }
}

class BarChart extends JPanel {
    private final int hombres;
    private final int mujeres;

    public BarChart(int hombres, int mujeres) {
        this.hombres = hombres;
        this.mujeres = mujeres;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int barWidth = 100;

        g.setColor(Color.GRAY);
        g.fillRect(60, 20, 2, 200);

        g.setColor(Color.BLUE);
        g.fillRect(80, 200 - hombres, barWidth, hombres);

        g.setColor(Color.PINK);
        g.fillRect(200, 200 - mujeres, barWidth, mujeres);

        g.setColor(Color.BLACK);
        g.drawString("Hombres", 80, 230);
        g.drawString("Mujeres", 210, 230);

        g.drawString("0%", 40, 210);
        g.drawString("100%", 40, 50);
    }
}