package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author admin
 */
/*
public class GraficoPastel extends JFrame {

    public GraficoPastel() {
        super("Prevalencia de Condiciones de Salud");

        int desnutricion = 30;  // Porcentaje de desnutrición
        int sobrepeso = 40;      // Porcentaje de sobrepeso
        int alergias = 20;       // Porcentaje de alergias
        int obesidad = 10;       // Porcentaje de obesidad
        int diabetes = 15;       // Porcentaje de diabetes

        PieChart pieChart = new PieChart(desnutricion, sobrepeso, alergias, obesidad, diabetes);
        add(pieChart, BorderLayout.CENTER);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GraficoPastel());
    }
}

class PieChart extends JPanel {
    private final int desnutricion;
    private final int sobrepeso;
    private final int alergias;
    private final int obesidad;
    private final int diabetes;

    public PieChart(int desnutricion, int sobrepeso, int alergias, int obesidad, int diabetes) {
        this.desnutricion = desnutricion;
        this.sobrepeso = sobrepeso;
        this.alergias = alergias;
        this.obesidad = obesidad;
        this.diabetes = diabetes;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int total = desnutricion + sobrepeso + alergias + obesidad + diabetes;
        int startAngle = 0;

        int width = getWidth();
        int height = getHeight();
        int diameter = Math.min(width, height) - 40;
        int x = (width - diameter) / 2;
        int y = (height - diameter) / 2;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        drawPieSlice(g2d, x, y, diameter, startAngle, 360 * desnutricion / total, Color.RED, "");
        startAngle += 360 * desnutricion / total;

        drawPieSlice(g2d, x, y, diameter, startAngle, 360 * sobrepeso / total, Color.GREEN, "");
        startAngle += 360 * sobrepeso / total;

        drawPieSlice(g2d, x, y, diameter, startAngle, 360 * alergias / total, Color.BLUE, "");
        startAngle += 360 * alergias / total;

        drawPieSlice(g2d, x, y, diameter, startAngle, 360 * obesidad / total, Color.ORANGE, "");
        startAngle += 360 * obesidad / total;

        drawPieSlice(g2d, x, y, diameter, startAngle, 360 * diabetes / total, Color.PINK, "");
    }

    private void drawPieSlice(Graphics2D g, int x, int y, int diameter, int startAngle, int arcAngle, Color color, String label) {
        g.setColor(color);
        g.fillArc(x, y, diameter, diameter, startAngle, arcAngle);
        g.setColor(Color.BLACK);
        int labelX = (int) (x + diameter / 2 * Math.cos(Math.toRadians(startAngle + arcAngle / 2)));
        int labelY = (int) (y + diameter / 2 * Math.sin(Math.toRadians(startAngle + arcAngle / 2)));
        g.drawLine(x + diameter / 2, y + diameter / 2, labelX, labelY);
        g.drawString(label, labelX, labelY);
        g.drawString(formatPercentage(arcAngle), labelX + 30, labelY);
    }

    private String formatPercentage(int value) {
        DecimalFormat df = new DecimalFormat("0.##");
        return df.format((double) value / 360 * 100) + "%";
    }
}*/

public class GraficoPastel extends JFrame {

    public GraficoPastel() {
        super("Prevalencia de Condiciones de Salud");

        int desnutricion = 30;  // Porcentaje de desnutrición
        int sobrepeso = 40;      // Porcentaje de sobrepeso
        int alergias = 20;       // Porcentaje de alergias
        int obesidad = 10;       // Porcentaje de obesidad
        int diabetes = 15;       // Porcentaje de diabetes

        PieChart pieChart = new PieChart(desnutricion, sobrepeso, alergias, obesidad, diabetes);
        add(pieChart, BorderLayout.CENTER);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GraficoPastel());
    }
}

class PieChart extends JPanel {
    private final int desnutricion;
    private final int sobrepeso;
    private final int alergias;
    private final int obesidad;
    private final int diabetes;

    public PieChart(int desnutricion, int sobrepeso, int alergias, int obesidad, int diabetes) {
        this.desnutricion = desnutricion;
        this.sobrepeso = sobrepeso;
        this.alergias = alergias;
        this.obesidad = obesidad;
        this.diabetes = diabetes;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int total = desnutricion + sobrepeso + alergias + obesidad + diabetes;
        int startAngle = 0;

        int width = getWidth();
        int height = getHeight();
        int diameter = Math.min(width, height) - 40;
        int x = (width - diameter) / 2;
        int y = (height - diameter) / 2;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        drawGraduationLines(g2d, width, height);
        drawPieSlice(g2d, x, y, diameter, startAngle, 360 * desnutricion / total, Color.RED, "Desnutrición");
        startAngle += 360 * desnutricion / total;

        drawPieSlice(g2d, x, y, diameter, startAngle, 360 * sobrepeso / total, Color.GREEN, "Sobrepeso");
        startAngle += 360 * sobrepeso / total;

        drawPieSlice(g2d, x, y, diameter, startAngle, 360 * alergias / total, Color.BLUE, "Alergias");
        startAngle += 360 * alergias / total;

        drawPieSlice(g2d, x, y, diameter, startAngle, 360 * obesidad / total, Color.ORANGE, "Obesidad");
        startAngle += 360 * obesidad / total;

        drawPieSlice(g2d, x, y, diameter, startAngle, 360 * diabetes / total, Color.PINK, "Diabetes");
    }

    private void drawGraduationLines(Graphics2D g, int width, int height) {
        g.setColor(Color.BLACK);
        int startX = 30;
        int endX = width - 30;
        int y = height - 30;
        int lineLength = 5;

        // Eje X graduado
        for (int x = startX; x <= endX; x += 10) {
            g.drawLine(x, y - lineLength, x, y + lineLength);
        }

        // Eje Y graduado
        int startY = 30;
        int endY = height - 30;
        for (int yy = startY; yy <= endY; yy += 10) {
            g.drawLine(startX - lineLength, yy, startX + lineLength, yy);
        }
    }

    private void drawPieSlice(Graphics2D g, int x, int y, int diameter, int startAngle, int arcAngle, Color color, String label) {
        g.setColor(color);
        g.fillArc(x, y, diameter, diameter, startAngle, arcAngle);
        g.setColor(Color.BLACK);
        int labelX = (int) (x + diameter / 2 * Math.cos(Math.toRadians(startAngle + arcAngle / 2)));
        int labelY = (int) (y + diameter / 2 * Math.sin(Math.toRadians(startAngle + arcAngle / 2)));
        g.drawLine(x + diameter / 2, y + diameter / 2, labelX, labelY);
        g.drawString(label, labelX, labelY);
        g.drawString(formatPercentage(arcAngle), labelX + 30, labelY);
    }

    private String formatPercentage(int value) {
        DecimalFormat df = new DecimalFormat("0.##");
        return df.format((double) value / 360 * 100) + "%";
    }
}