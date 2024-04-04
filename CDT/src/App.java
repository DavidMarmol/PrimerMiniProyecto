
import java.util.Scanner;

     

      public class  App{
      
          public static void main(String[] args) {
              Scanner scanner = new Scanner(System.in);
      
              // Mostrar un menú al usuario
              System.out.println("¿Qué desea hacer?");
              System.out.println("1. Solicitar un préstamo");
              System.out.println("2. Realizar un CDT");
              System.out.println("Ingrese la opción deseada: ");
              int opcion = scanner.nextInt();
      
              // Procesar la opción seleccionada por el usuario
              switch (opcion) {
                  case 1:
                      // Solicitar un préstamo
                      System.out.println("Ingrese la cantidad de dinero que tiene ahorrada: ");
                      double ahorros = scanner.nextInt();
      
                      System.out.println("Ingrese la cantidad de dinero que desea prestar: ");
                      double prestamo = scanner.nextInt();
      
                      // Validar si el préstamo es mayor a los ahorros
                      if (prestamo > ahorros) {
                          // Validar si el préstamo es mayor al doble de los ahorros
                          if (prestamo > (ahorros * 2)) {
                              System.out.println("Lo siento, no puede prestar más del doble de lo que tiene ahorrado.");
                              return;
                          } else {
                              // Calcular el valor de la cuota mensual
                              double tasaInteresMensual = 0.02 / 12;
                              int numeroCuotas = 6;
                              double valorCuota = prestamo * (tasaInteresMensual * Math.pow((1 + tasaInteresMensual), numeroCuotas)) / (Math.pow((1 + tasaInteresMensual), numeroCuotas) - 1);
      
                              // Mostrar al usuario el valor de la cuota mensual
                              System.out.println("El valor de la cuota mensual es: " + valorCuota);
                          }
                      } else {
                          // Restar el préstamo de los ahorros y mostrar el saldo restante
                          double saldo = (int) (ahorros - prestamo);
                          System.out.println("Su préstamo ha sido aprobado. Le queda un saldo de: " + saldo);
                      }
                      break;
                  case 2:
                      // Realizar un CDT
                      System.out.println("Ingrese la cantidad de dinero que desea depositar en el CDT: ");
                      double depositoCDT = scanner.nextDouble();
      
                      System.out.println("Ingrese el plazo del CDT (3 o 6 meses): ");
                      int plazoCDT = scanner.nextInt();
      
                      // Calcular el interés del CDT
                      double interesCDT;
                      if (plazoCDT == 3) {
                          interesCDT = depositoCDT * 0.03;
                      } else if (plazoCDT == 6) {
                          interesCDT = depositoCDT * 0.05;
                      } else {
                          System.out.println("Plazo del CDT no válido.");
                          return;
                      }
      
                      // Mostrar al usuario el total que ganará en el CDT
                      System.out.println("El total que ganará en el CDT es: " + interesCDT);
                      break;
                  default:
                      System.out.println("Opción no válida.");
              }
          }
      }
      
      




