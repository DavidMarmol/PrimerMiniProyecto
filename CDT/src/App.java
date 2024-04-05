import java.util.Scanner;

     public class CDT {

         public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario la cantidad de dinero que tiene ahorrada
        System.out.println("Ingrese la cantidad de dinero que tiene ahorrada: ");
        double ahorros = scanner.nextDouble();

        // Pedir al usuario la cantidad que desea depositar en el CDT
        System.out.println("Ingrese la cantidad de dinero que desea depositar en el CDT: ");
        double depositoCDT = scanner.nextDouble();

        // Pedir al usuario el plazo del CDT (3 o 6 meses)
        System.out.println("Ingrese el plazo del CDT (3 o 6 meses): ");
        int plazoCDT = scanner.nextInt();

        // Validar el plazo del CDT
        if (plazoCDT != 3 && plazoCDT != 6) {
            System.out.println("Plazo del CDT no válido.");
            return;
        }

        // Calcular el interés del CDT
        double interesCDT;
        if (plazoCDT == 3) {
            interesCDT = depositoCDT * 0.03;
        } else {
            interesCDT = depositoCDT * 0.05;
        }

        // Calcular el total ganado en el CDT
        double totalGanado = depositoCDT + interesCDT;

        // Mostrar al usuario el total que ganará en el CDT
        System.out.println("El total que ganará en el CDT es: " + totalGanado);
    }
}

      
      




