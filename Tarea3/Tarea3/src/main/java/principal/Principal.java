package principal;

import controlador.Controlador;
import vista.Vista;

public class Principal {
    
    public static void main(String[] args) {
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista);
        vista.setVisible(true);
    }
}
