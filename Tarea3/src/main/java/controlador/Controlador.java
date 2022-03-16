package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import vista.Vista;

public class Controlador implements ActionListener {

    Vista vista = new Vista();
    String[] encabezado = new String[0];
    String[] nombres = new String[0];
    double[] cantidades = new double[0];
    GraficaBarra grafica = new GraficaBarra();

    public Controlador(Vista vista) {
        this.vista = vista;
        vista.botonAbrirArchivo.addActionListener(this);
        vista.botonGenerarGrafica.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.botonAbrirArchivo) {
            String ruta = "";
            //vista.exploradorArchivos();
            vista.explorador.showOpenDialog(null);
            File archivo = vista.explorador.getSelectedFile();
            if (archivo != null) {
                ruta = archivo.getAbsolutePath();
            }
            if (!ruta.equals("")) {
                int numLinea = 0;
                String titulos = "";
                String valores = "";
                try {
                    FileReader lectura = new FileReader(ruta);
                    BufferedReader archivoLeer = new BufferedReader(lectura);
                    String lineaLeida;
                    while ((lineaLeida = archivoLeer.readLine()) != null) {
                        if (numLinea == 0) {
                            titulos += lineaLeida;
                            numLinea++;
                        } else {
                            valores += lineaLeida + ",";
                            numLinea++;
                        }
                    }
                    archivoLeer.close();
                    lectura.close();
                    String[] datos = valores.split(",");
                    encabezado = titulos.split(",");
                    nombres = new String[numLinea - 1];;
                    cantidades = new double[numLinea - 1];
                    int posicion = 0;
                    //////////////////////////////////////////////////////                   
                    for (int i = 0; i < nombres.length; i++) {
                        nombres[i] = datos[posicion];
                        posicion += 2;
                    }
                    //////////////////////////////////////////////////////
                    posicion = 0;
                    for (int i = 0; i < cantidades.length; i++) {
                        cantidades[i] = Double.parseDouble(datos[posicion + 1]);
                        posicion += 2;
                    }
                } catch (FileNotFoundException ea) {
                    JOptionPane.showMessageDialog(null, "El sistema no puede encontrar\nel archivo especificado.", "Error", 0);
                } catch (IOException ea) {
                    JOptionPane.showMessageDialog(null, ea.getMessage());
                }
            }
        } else if (e.getSource() == vista.botonGenerarGrafica) {
            if (cantidades.length != 0) {
                if (!vista.campoTitulo.getText().equals("")) {
                    grafica.graficar(vista.campoTitulo.getText(), cantidades, nombres, encabezado);
                    vista.panelGrafica.removeAll();
                    vista.panelGrafica.add(grafica);
                    vista.panelGrafica.revalidate();
                    vista.panelGrafica.repaint();
                    grafica.generarGrafica();
                } else {
                    JOptionPane.showMessageDialog(null, "¡Complete el campo titulo!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "¡Primero seleccione un archivo!");
            }
        }
    }
}
