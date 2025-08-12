import java.util.Scanner;

public class ejercicio08 {
    public static void main(String[] args) {
        
Scanner scanner = new Scanner(System.in);

        boolean bool = true;

        while (bool){
            
            System.out.println("Dame un numero:");

                    int numero = scanner.nextInt();


            if(numero >= 0){

                System.out.println("Este numero es mayor a 0");

                bool = false;

            } 
            
            else{
                 System.out.println("Este numero NO es mayor a 0");
            }
             
        }

        scanner.close();

    }
}
