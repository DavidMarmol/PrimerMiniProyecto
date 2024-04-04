package crud;

public class Cliente {
    private String nombre;
    private int ahorro;
    private String cedula;
    private String fecha_creacion;
    private int nivel_ingresos;

    public Cliente(String nombre, int ahorro, String cedula, int nivel_ingresos, String fecha_creacion) {
        this.nombre = nombre;
        this.ahorro = ahorro;
        this.cedula = cedula;
        this.fecha_creacion = fecha_creacion;
        this.nivel_ingresos = nivel_ingresos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAhorro() {
        return ahorro;
    }

    public String getCedula() {
        return cedula;
    }

    public String getFecha() {
        return fecha_creacion;
    }

    public int getIngresos() {
        return nivel_ingresos;
    }

    public void setAhorro(int ahorro) {
        this.ahorro = ahorro;
    }
}