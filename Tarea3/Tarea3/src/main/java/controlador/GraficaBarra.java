package controlador;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficaBarra extends javax.swing.JPanel {

    DefaultCategoryDataset datos;
    JFreeChart barras;
    ChartPanel chartPanel;

    public void graficar(String titulo, double[] cantidad, String[] nombre, String[] encabezado) {
        datos = new DefaultCategoryDataset();
        for (int i = 0; i < cantidad.length; i++) {
            datos.addValue(cantidad[i], nombre[i], "");
        }
        barras = ChartFactory.createBarChart(titulo, encabezado[0], encabezado[1], datos, PlotOrientation.VERTICAL, true, true, false);
        chartPanel = new ChartPanel(barras);
        chartPanel.setPreferredSize(new java.awt.Dimension(535, 270));
        this.removeAll();
        this.add(chartPanel);
    }

    public void generarGrafica() {
        try {
            DateFormat dateFormat = new SimpleDateFormat("HH;mm;ss");
            Date date = new Date();
            final ChartRenderingInfo informacion = new ChartRenderingInfo(new StandardEntityCollection());
            final File archivo = new File("Grafica(" + dateFormat.format(date) + ").png");
            ChartUtilities.saveChartAsPNG(archivo, barras, 500, 300, informacion);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
