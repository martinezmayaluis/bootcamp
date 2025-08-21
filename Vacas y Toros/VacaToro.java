
import java.util.*;

public class VacaToro{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numeroSecreto = generarNumeroSecreto();
        int intentos = 0;
        
        System.out.println("Adivina el número secreto (4 números): ");

        while(true){
            System.out.println("Ingresa tu intento: ");
            String intento = scanner.nextLine();

            if(!esValido(intento)){
                System.out.println("Entrada invalida. deben ser 4 números distintos.");
                continue;
            }
            intentos++;
            int toros = contarToros(numeroSecreto, intento);
            int vacas = contarVacas(numeroSecreto, intento);

            if(toros == 4){
                System.out.println("Felicidades. Adivinaste el número en " + intentos + " intentos");
                break;
            }else{
                System.out.println(toros + " toros, " + vacas + " vacas");
            }
        }
        scanner.close();
    }

    private static String generarNumeroSecreto(){
        Random rand = new Random();
        Set<Integer> cifras = new LinkedHashSet<>();
        
        int primerDigito;
        do{
            primerDigito = rand.nextInt(9) + 1;
        
        }while(cifras.contains(primerDigito));
        cifras.add(primerDigito);
        
        while(cifras.size() < 4){
            cifras.add(rand.nextInt(10));
        }
        StringBuilder numero = new StringBuilder();
        for (int cifra : cifras){
            numero.append(cifra);
        }
        return numero.toString();
    } 

     private static boolean esValido(String intento) {
        if (intento.length() != 4 || !intento.matches("\\d+")) {
            return false;
        }
        Set<Character> unicos = new HashSet<>();
        for (char c : intento.toCharArray()) {
            unicos.add(c);
        }
        return unicos.size() == 4;
    }

     private static int contarToros(String numeroSecreto, String intento){
        int toros = 0;
        for(int i = 0; i < 4; i++){
            if(numeroSecreto.charAt(i) == intento.charAt(i)){
                toros++;
            }
        }
        return toros;
     }

     private static int contarVacas(String numeroSecreto, String intento){

        int vacas = 0;
        for(int i = 0; i < 4; i++){
            char c = intento.charAt(i);

            if(numeroSecreto.indexOf(c) != -1 && numeroSecreto.charAt(i) != c){
                vacas++;
            }
        }
        return vacas;
     }

    

    
}