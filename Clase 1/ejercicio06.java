import java.util.Scanner;

public class ejercicio06 {
    public static void main(String[] args) {
        

        Scanner scanner = new Scanner(System.in);

        System.out.println("Dame el precio:");

        double num = scanner.nextDouble();

        double IVA = 0.1;

        System.out.println( "Este es el precio final: " + (num * IVA));
   

        scanner.close();
    }
}
