import java.util.Scanner;

public class ejercicio04 {
    public static void main(String[] args) {
        
    Scanner scanner = new Scanner(System.in);

    System.out.println("Cual es tu nombre?:");

    String nombre = scanner.nextLine();

    System.out.println("Bienvenido " + nombre);

   scanner.close(); 
    }
}
