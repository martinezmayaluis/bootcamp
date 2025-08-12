import java.util.*;

public class ejercicio10 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> dias = new ArrayList<>(Arrays.asList("lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"));
       
        boolean bool = false;
         System.out.println("¿Que dia es hoy?: ");
         String entrada = scanner.nextLine().toLowerCase();

         while(!bool){

            if(dias.contains(entrada)){

                if(entrada.equals("sabado")|| entrada.equals("domingo")){
            

                System.out.println("Este NO es un dia laboral");
                bool = false;
                break;
            
                 }
                else{

                    System.out.println("Este es un dia laboral");
                    bool = true;

                    } 
         }
        
        }
    
        scanner.close();
    }
}
