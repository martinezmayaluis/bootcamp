import java.util.Scanner;

public class ejercicio09 {
    
    public static void main(String[] args) {

        int intentos = 3;
        String contra = "bolas";
        Scanner scanner = new Scanner(System.in);

    while (intentos > 0){
        System.out.println("Cual es tu contraseña?: ");
        String entrada = scanner.nextLine();


        if(entrada.equals(contra)){
            
            System.out.println("¡Contraseña correcta! Acceso Concedido");
            return;
        } 
        
        else{
            intentos--;
            System.out.println("Contraseña incorrecta. Intentos restantes: " + intentos);
        }
         
    }
        System.out.println("Has agotado tus intentos. Acceso Denegado");

        scanner.close();
    }

}


