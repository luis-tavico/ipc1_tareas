package paquete;

public class Transferencia {

    private int cuentaOrigen;
    private int cuentaDestino;
    private float monto;
    private String fecha_hora;

    public Transferencia(int cuentaOrigen, int cuentaDestino, float monto, String fecha_hora) {
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
        this.fecha_hora = fecha_hora;
    }

    public int getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(int cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public int getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(int cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    @Override
    public String toString() {
        return "Transfirio: " + monto + "; Al numero de cuenta: " + cuentaDestino + "; El dia: " + fecha_hora + "\n";
    }
}
