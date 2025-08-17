import java.util.Random;

public class ejercicio202 {
    public static void main(String[] args) {
         int[] array = new int[100];

        Random random = new Random();

        for(int i= 0; i < array.length; i++ ){
            array[i] = random.nextInt(61) - 30;
        }
        
        System.out.println("Array generado:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

    


    }
}
