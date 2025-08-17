import java.util.Random;

public class ejercicio201{
    public static void main(String[] args) {
        int[] numeros = new int[10];
        Random random = new Random();

        
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(11) - 5; 
        }

        System.out.print("Array: ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }

        int mayor = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > mayor) {
                mayor = numeros[i];
            }
        }

        System.out.println("\nEl mayor valor del array es: " + mayor);
    }
}