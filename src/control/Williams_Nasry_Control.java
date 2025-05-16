package control;


import java.util.Scanner;


public class Williams_Nasry_Control {

   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0; 

        while (opcion != 4) {
            System.out.println("\n=== Menu ===");//menu
            System.out.println("1. Cifrado Cesar");
            System.out.println("2. Filtrar");
            System.out.println("3. Opcion 3");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion (1-4): ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiamos el buffer para poder leer en otras lineas

            if (opcion == 1) {
                System.out.println("\n=== Encripta tus textos usando CIFRADO CESAR ===");
                System.out.print("Ingrese la frase a cifrar: "); // ingresa frase
                String frase = scanner.nextLine(); 
                System.out.print("Ingrese el numero de posiciones a desplazar: "); // ingresa desplazamiento
                int desplazamiento = scanner.nextInt();

                String fraseFinal = "";

                for (int i = 0; i < frase.length(); i++) { // codigo Cesar
                    char letra = frase.charAt(i);
                    if ((letra >= 'a' && letra <= 'z') || (letra >= 'A' && letra <= 'Z')) { // verificamos que sea letra
                        char baseLetra;
                        if (letra >= 'a' && letra <= 'z') {
                            baseLetra = 'a'; // si es minuscula ponerlo en la linea de caracteres minusculos
                        } else {
                            baseLetra = 'A'; // base mayuscula
                        }
                        letra = (char) ((letra - baseLetra + desplazamiento) % 26 + baseLetra); // para calcular el desplazamiento
                    }
                    fraseFinal += letra; // concatenamos cada char a la fraseFinal
                }

                System.out.println("Texto cifrado: " + fraseFinal);
                
            } else if (opcion == 2) {

        String palabra = "";
        int longitud = 0;
                System.out.println("FILTRAR");
        System.out.println("Ingrese una frase: ");
        String frase = scanner.nextLine();

        do {
            System.out.println("Ingrese un numero entero positivo que representara la longitud minima requerida: ");
            longitud = scanner.nextInt();

        } while (longitud <= 0);

        System.out.println("Palabras con mas de " + longitud + " letras: ");

        for (int i = 0; i < frase.length(); i++) {
            char j = frase.charAt(i);

            if (j != ' ') {
                palabra += j;
            } else {
                if (palabra.length() >= longitud) {
                    System.out.println(palabra);
                }
                palabra = "";
            }

        }

        if (palabra.length() > longitud) {
            System.out.println(palabra);
        }
       
                
            } else if (opcion == 3) {
              
               
            } else if (opcion == 4) {
                System.out.println("Saliendo del programa...");
            } else {
                System.out.println("Opcion no valida");
            }
        }
    }
}