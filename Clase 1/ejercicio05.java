import java.util.Scanner;

public class ejercicio05 {
    
public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);

    System.out.println("Dame un numero:");

    int numero = scanner.nextInt();

    if (numero % 2 <= 0){

        System.out.println("Este numero es divisible por 2");

    } else{

        System.out.println("Este numero no es divisible entre 2");
    }
    
    
    
    scanner.close();
}
}
