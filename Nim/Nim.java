package Nim;
import java.util.Scanner;

public class Nim {
    public static void main(String[] args) {
        
        boolean bandera = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre de Jugador 1");

        Jugador jugador1 = new Jugador(scanner.next());

        System.out.println("Ingrese el nombre de Jugador 2");
 
        Jugador jugador2 = new Jugador(scanner.next());

        Pila A = new Pila();
        Pila B = new Pila();
        Pila C = new Pila();

        int turno = 1;

        Jugador jugadorActual = new Jugador(jugador1.getNombre());
        System.out.println("A: "+A.getContadores()+"   B: "+B.getContadores()+"  C: "+C.getContadores());

        do{
        System.out.println(jugadorActual.getNombre()+ ", elija una pila");
        
        String pila = leerPila(A, B, C);
        
        reducirContadores(pila, A, B, C);
        
        System.out.println("\nA:"+A.getContadores()+"  B:"+B.getContadores()+"  C:"+C.getContadores());

            if (!A.getEstado() && !B.getEstado() && !C.getEstado()) {
                System.out.println(jugadorActual.getNombre()+", ya no quedan contadores, Ganaste!");
                bandera = true;
            }else{
                turno++;
                if(turno % 2 == 0){
                    jugadorActual.setNombre(jugador2.getNombre());
                }else{
                    jugadorActual.setNombre(jugador1.getNombre());
                }
            }

        }while(!bandera);
        scanner.close();  
    }


    private static String leerPila(Pila A, Pila B, Pila C){
         Scanner scanner = new Scanner(System.in);
         boolean bandera = false;
         String pilaSec = "";

        do{
            String pila = scanner.nextLine();
            switch (pila) {
                case "A":
                    if(!A.getEstado()){
                        System.out.println("Esta pila esta vacia. Ingrese otra: ");
                    break;
                    }
                    pilaSec = pila;
                    bandera = true;
                    break;
                case "B":
                
                    if(!B.getEstado()){
                        System.out.println("Esta pila ya esta vacia!. Ingresa otra: ");
                        break;
                    }
                    pilaSec = pila;
                    bandera = true;
                    break;
                case "C":    

                    if(!C.getEstado()){
                        System.out.println("Esta pila ya esta vacia!. Ingresa otra: ");
                        break;
                    }
                    pilaSec = pila;
                    bandera = true;
                    break;
                default: 
                    System.out.println("Pila no valida. Intentar de nuevo: "); 
                    break;   
            }
        }while (!bandera);
        return pilaSec;
        
            
    }

    
    private static void reducirContadores(String pila, Pila A, Pila B, Pila C){
        Scanner scanner = new Scanner(System.in);
        boolean bandera = false;
        
        do{
            System.out.println("Cuanto quitaras de la pila "+pila);
            int cantidad = scanner.nextInt();

            if(cantidad > 0){
                switch (pila) {
                    case "A":
                        A.reducirPila(cantidad);
                        bandera = true;
                        break;
                    case "B":
                        B.reducirPila(cantidad);
                        bandera = true;
                        break;
                    case "C":
                        C.reducirPila(cantidad);
                        bandera = true;
                        break;    
                }
            }else{
                System.out.println("Cantidad no valida");
            }
        }while(!bandera);
    }

}


