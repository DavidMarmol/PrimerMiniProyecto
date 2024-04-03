package crud;

public class Cliente {
    private String nombre;
    private int ahorro;

    public Cliente(String nombre, int ahorro) {
        this.nombre = nombre;
        this.ahorro = ahorro;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAhorro() {
        return ahorro;
    }

    public void setAhorro(int ahorro) {
        this.ahorro = ahorro;
    }
}