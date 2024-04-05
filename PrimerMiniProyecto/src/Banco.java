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

    public void pedirPrestamo(String nombre, int cantidadPrestamo) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre)) {
                int ahorroDisponible = cliente.getAhorro();

                if (cantidadPrestamo <= ahorroDisponible) {
                    cliente.setAhorro(ahorroDisponible - cantidadPrestamo);
                    System.out.println("Préstamo concedido. Nuevo saldo: " + cliente.getAhorro());
                } else if (cantidadPrestamo <= ahorroDisponible * 2) {
                    int cuotas = 6;
                    double interesAnual = 0.02;
                    double interesMensual = Math.pow(1 + interesAnual, 1.0 / 12) - 1;
                    double cuotaMensual = cantidadPrestamo * (interesMensual / (1 - Math.pow(1 + interesMensual, -cuotas)));
                    System.out.println("Préstamo concedido en " + cuotas + " cuotas mensuales.");
                    System.out.println("El valor de cada cuota mensual es: " + cuotaMensual);
                } else {
                    System.out.println("No se puede prestar más del doble del ahorro disponible.");
                }
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
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
            System.out.println("6. Pedir préstamo");
            System.out.println("7. Pedir CDT");
            System.out.println("8. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del teclado

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
                    System.out.print("Ingrese el nombre del cliente: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese la cantidad que desea pedir prestada: ");
                    int cantidadPrestamo = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer del teclado
                    banco.pedirPrestamo(nombre, cantidadPrestamo);
                    break;
                case 7:
                CDT cdt = new CDT();
                cdt.main(args);
                break;
           
                case 8:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 8);

        scanner.close();
    }

public static class CDT {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        // Pedir al usuario la cantidad de dinero que tiene ahorrada
        System.out.println("Ingrese la cantidad de dinero que tiene ahorrada: ");
        float ahorros = scanner.nextFloat();
    
        // Pedir al usuario la cantidad que desea depositar en el CDT
        System.out.println("Ingrese la cantidad de dinero que desea depositar en el CDT: ");
        float depositoCDT = scanner.nextFloat();
                    // Pedir al usuario el plazo del CDT (3 o 6 meses)
        System.out.println("Ingrese el plazo del CDT (3 o 6 meses): ");
        byte plazoCDT = scanner.nextByte();

        // Validar el plazo del CDT
        if (plazoCDT != 3 && plazoCDT != 6) {
            System.out.println("Plazo del CDT no válido.");
        }

        // Calcular el interés del CDT
        float interesCDT;
        if (plazoCDT == 3) {
            interesCDT = depositoCDT * 0.03f;
        } else {
            interesCDT = depositoCDT * 0.05f;
        }

        // Calcular el total ganado
        float totalGanado = depositoCDT + interesCDT;

        // Mostrar al usuario el total que ganará en el CDT
        System.out.println("El total que ganaría en el CDT es: " + totalGanado);
        }
    }
}
       
