package paquete;

public class Cliente {

    private long cui;
    private String nombre;
    private String apellido;

    public Cliente(long cui, String nombre, String apellido) {
        this.cui = cui;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public long getCui() {
        return cui;
    }

    public void setCui(long cui) {
        this.cui = cui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "CUI: " + cui + "\nNombre: " + nombre + "\nApellido: " + apellido;
    }

}
