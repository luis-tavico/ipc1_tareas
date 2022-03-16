package vista;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Vista extends javax.swing.JFrame {

    private JPanel panelGeneral;
    public JTextField campoTitulo;
    public JButton botonAbrirArchivo;
    public JButton botonGenerarGrafica;
    public JPanel panelGrafica;
    private JLabel etiquetaTitulo;
    public JFileChooser explorador;

    public Vista() {
        setSize(590, 380);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
    }

    public void iniciarComponentes() {

        panelGeneral = new JPanel();
        panelGeneral.setLayout(null);
        this.getContentPane().add(panelGeneral);
        ///////////////////////////////////////
        campoTitulo = new JTextField();
        campoTitulo.setBounds(60, 10, 230, 23);
        panelGeneral.add(campoTitulo);
        ///////////////////////////////////////
        botonAbrirArchivo = new JButton();
        botonAbrirArchivo.setText("Abrir Archivo");
        botonAbrirArchivo.setBounds(300, 10, 125, 23);
        panelGeneral.add(botonAbrirArchivo);
        ///////////////////////////////////////
        botonGenerarGrafica = new JButton();
        botonGenerarGrafica.setText("Generar Grafica");
        botonGenerarGrafica.setBounds(435, 10, 125, 23);
        panelGeneral.add(botonGenerarGrafica);
        ///////////////////////////////////////
        etiquetaTitulo = new JLabel();
        etiquetaTitulo.setText("Titulo:");
        etiquetaTitulo.setBounds(15, 10, 60, 23);
        panelGeneral.add(etiquetaTitulo);
        ///////////////////////////////////////
        panelGrafica = new JPanel();
        panelGrafica.setBounds(15, 43, 545, 285);
        panelGeneral.add(panelGrafica);
        ///////////////////////////////////////
        explorador = new JFileChooser();

    }
}
