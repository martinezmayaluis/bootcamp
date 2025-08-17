public class ejercicio203 {
   
     public static boolean esPalindromo(String texto) {
        // Eliminar espacios y pasar a minúsculas
        texto = texto.replaceAll("\\s+", "").toLowerCase();

        // Comparar la cadena original con su reverso
        String reverso = new StringBuilder(texto).reverse().toString();

        return texto.equals(reverso);
    }
   
    public static void main(String[] args) {

         String[] pruebas = {
            "anita lava la tina",
            "reconocer",
            "Hola mundo",
            "Oso",
            "A mamá Roma le aviva el amor a mamá"
        };

         for (String prueba : pruebas) {
            System.out.println("\"" + prueba + "\" es palíndromo? " + esPalindromo(prueba));
        }
        
    }
}

    

