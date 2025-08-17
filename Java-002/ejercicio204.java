import java.util.Scanner;

public class ejercicio204 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa una cadena de dígitos: ");
        String cadena = scanner.nextLine();

        int[] numeros = new int[cadena.length()];


        for (int i = 0; i < cadena.length(); i++) {
            numeros[i] = Character.getNumericValue(cadena.charAt(i));
        }
        
        System.out.print("Array resultante: ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        scanner.close();
    }
    
}
