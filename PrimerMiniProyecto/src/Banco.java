import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import crud.Cliente;

public class Banco {
    private List<Cliente> clientes;

    public Banco() {
        this.clientes = new ArrayList<>();
    }

    public void insertarCliente(String nombre, int ahorro, String cedula, int nivel_ingresos, String fecha_creacion) {
        clientes.add(new Cliente(nombre, ahorro, cedula, nivel_ingresos, fecha_creacion));
        System.out.println("Cliente agregado exitosamente.");
    }

    public void actualizarAhorro(String nombre, int nuevoAhorro, String cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre) && cliente.getCedula().equals(cedula)) {
                cliente.setAhorro(nuevoAhorro);
                System.out.println("Ahorro actualizado para " + nombre + ", con cedula: " + cedula);
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
                System.out.println("Nombre: " + cliente.getNombre() + ", Ahorro: " + cliente.getAhorro() + ", Cedula: " + cliente.getCedula() + ", fecha de creacion: " + cliente.getFecha());
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        System.out.println("Listado de clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("Nombre: " + cliente.getNombre() + ", Ahorro: " + cliente.getAhorro());
            System.out.println("Cedula: " + cliente.getCedula() + ", fecha de creacion: " + cliente.getFecha());
        }
    }


   

    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Insertar cliente");
            System.out.println("2. Actualizar ahorro");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Buscar cliente");
            System.out.println("5. Listar clientes");
            System.out.println("6. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese la cedula del cliente: ");
                    String cedula = scanner.nextLine();

                    System.out.print("Ingrese la fecha de creacion del cliente: ");
                    String fecha_creacion = scanner.nextLine();

                    System.out.print("Ingrese el ahorro inicial del cliente: ");
                    int ahorro = scanner.nextInt();

                    System.out.print("Ingrese el nivel de ingresos del cliente: ");
                    int nivel_ingresos = scanner.nextInt();


                    banco.insertarCliente(nombre, ahorro, cedula, nivel_ingresos, fecha_creacion);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del cliente: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese la cedula del cliente: ");
                    cedula = scanner.nextLine();
                    System.out.print("Ingrese el nuevo ahorro del cliente: ");
                    int nuevoAhorro = scanner.nextInt();
                    banco.actualizarAhorro(nombre, nuevoAhorro, cedula);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del cliente a eliminar: ");
                    nombre = scanner.nextLine();
                    banco.eliminarCliente(nombre);
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del cliente a buscar: ");
                    nombre = scanner.nextLine();
                    banco.buscarCliente(nombre);
                    break;
                case 5:
                    banco.listarClientes();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
