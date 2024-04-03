import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import crud.Cliente;

public class Banco {
    private List<Cliente> clientes;

    public Banco() {
        this.clientes = new ArrayList<>();
    }

    public void insertarCliente(String nombre, int ahorro) {
        clientes.add(new Cliente(nombre, ahorro));
        System.out.println("Cliente agregado exitosamente.");
    }

    public void actualizarAhorro(String nombre, int nuevoAhorro) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre)) {
                cliente.setAhorro(nuevoAhorro);
                System.out.println("Ahorro actualizado para " + nombre);
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    public void eliminarCliente(String nombre) {
        clientes.removeIf(cliente -> cliente.getNombre().equals(nombre));
        System.out.println("Cliente eliminado exitosamente.");
    }

    public void buscarCliente(String nombre) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre)) {
                System.out.println("Nombre: " + cliente.getNombre() + ", Ahorro: " + cliente.getAhorro());
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }
}
