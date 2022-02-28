package paquete;

public class Cuenta {

    private long cui;
    private int numero_cuenta;
    private String tipo;
    private float fondo;

    public Cuenta(long cui, int numero_cuenta, String tipo, float fondo) {
        this.cui = cui;
        this.numero_cuenta = numero_cuenta;
        this.tipo = tipo;
        this.fondo = fondo;
    }

    public long getCui() {
        return cui;
    }

    public void setCui(long cui) {
        this.cui = cui;
    }

    public int getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(int numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getFondo() {
        return fondo;
    }

    public void setFondo(float fondo) {
        this.fondo = fondo;
    }

    @Override
    public String toString() {
        return "\nNumero_cuenta: " + numero_cuenta + "\nTipo: " + tipo + "\nFondo: " + fondo;
    }

}
