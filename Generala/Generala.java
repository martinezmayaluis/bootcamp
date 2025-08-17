package Generala;
import java.util.*;
import java.util.stream.Collectors;

public class Generala {
    public static void main(String[] args) {
        Generala resultado = new Generala();
        System.out.println(resultado.jugada("55555"));
        System.out.println(resultado.jugada("55533"));
        System.out.println(resultado.jugada("12345"));
    
    }
    String jugada(String dados)
    {
        boolean inv = validarJugada(dados);
        if (!inv) {
            return "INVALIDO";
        }
        return identificarJugada(dados);
    }

    public static boolean validarJugada(String dados){
        Scanner scanner = new Scanner(System.in);
        
        if(dados.length()!=5){
            return false;
        }
    
        for (char c : dados.toCharArray()) {
            if (!Character.isDigit(c) || (c - '0') < 1 || (c - '0') > 6) {
                return false;
            }
        }
        
        scanner.close();
        return true;
    }
    
    
    public static String identificarJugada(String jugada) {
        String tipoJugada = "";
        Set<Character> digitosRep = new HashSet<>();
        int[] rep = new int[6];

        List<Character> escalera1 = Arrays.asList('1', '2', '3', '4', '5');
        List<Character> escalera2 = Arrays.asList('2', '3', '4', '5', '6');
        List<Character> escalera3 = Arrays.asList('3', '4', '5', '6', '1');

        for (char c : jugada.toCharArray()) {
            digitosRep.add(c);
            rep[(c - '0') - 1]++;
        }

        int d = digitosRep.size();

        switch (d) {
            case 1:
                tipoJugada = "GENERALA";
                break;
            case 2:
                boolean tieneCuatro = false;
                boolean tieneTres = false;
                for (int r : rep) {
                    if (r == 4) tieneCuatro = true;
                    if (r == 3) tieneTres = true;
                }
                if (tieneCuatro) {
                    tipoJugada = "POKER";
                } else if (tieneTres) {
                    tipoJugada = "FULL";
                } else {
                    tipoJugada = "NADA";
                }
                break;
            case 5:
                List<Character> jugadaList = jugada.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toList());

                Set<Character> jugadaSet = new HashSet<>(jugadaList);
                if (jugadaSet.containsAll(escalera1) || jugadaSet.containsAll(escalera2) || jugadaSet.containsAll(escalera3)) {
                    tipoJugada = "ESCALERA";
                } else {
                    tipoJugada = "NADA";
                }
                break;
            default:
                tipoJugada = "NADA";
                break;
        }

        return tipoJugada;
    }

}


//2.1. Cuál es la probabilidad de sacar generala en un tiro 

// 0.077%

//2.2. Cuál es la probabilidad de sacar poker en un tiro 

// 1.93%

//2.3. Cuál es la probabilidad de sacar full en un tiro 

// 3.86%

//2.4. Cuál es la probabilidad de sacar escalera en un tiro 

// 3.09%

//2.5. Cuál es la probabilidad de sacar nada en un tiro

// 91%

// 3.1 Cuál es la probabilidad de sacar generala en dos tiros 

// aprox 4.6%

//3.2 Cuál es la probabilidad de sacar generala en dos tiros 

//aprox 8.23%