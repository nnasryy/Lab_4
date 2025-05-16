/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cesar;

import java.util.Scanner;

public class Vasquez_Alexander_Control {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("\n=== Menu ==="); // menu
            System.out.println("1. Cifrado Cesar");
            System.out.println("2. Filtrar Palabras por Longitud");
            System.out.println("3. Codigo Enigma");
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
                System.out.println("\n=== Filtra tus FRASES ===");
                System.out.print("Ingrese una frase: ");
                String frase = scanner.nextLine();

                do {
                    System.out.print("Ingrese un numero entero positivo que representara la longitud minima requerida: ");
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

                if (palabra.length() >= longitud) {
                    System.out.println(palabra);
                }
            } else if (opcion == 3) {
                System.out.println("\n=== Codigo Enigma ===");
                System.out.println("1. Encriptar texto");
                System.out.println("2. Desencriptar texto");
                System.out.println("3. Regresar");
                System.out.print("Seleccione una opcion (1-3): ");
                int opcionEnigma = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                if (opcionEnigma == 1) {
                    System.out.print("Ingrese el texto a encriptar: ");
                    String textoOriginal = scanner.nextLine();
                    String pares = "";
                    String impares = "";

                    for (int i = 0; i < textoOriginal.length(); i++) {
                        if (i % 2 == 0) {                     // Separamos pares e impares
                            pares += textoOriginal.charAt(i); // caracteres en posiciones pares
                        } else {
                            impares += textoOriginal.charAt(i); // caracteres en posiciones impares
                        }
                    }

                    String textoEncriptado = pares + impares; // concatenamos primero los pares a los impares
                    System.out.println("Texto encriptado: " + textoEncriptado);
                } else if (opcionEnigma == 2) {
                    System.out.print("Ingrese el texto a desencriptar: ");
                    String textoEncriptado = scanner.nextLine();
                    int longitudPares = textoEncriptado.length() / 2;
                    String pares = "";
                    String impares = "";

                    for (int i = 0; i < longitudPares; i++) {
                        pares += textoEncriptado.charAt(i);
                        if (i + longitudPares < textoEncriptado.length()) {
                            impares += textoEncriptado.charAt(i + longitudPares);
                        }
                    }

                    String textoDesencriptado = "";
                    for (int i = 0; i < longitudPares; i++) {
                        textoDesencriptado += pares.charAt(i);
                        if (i < impares.length()) {
                            textoDesencriptado += impares.charAt(i);
                        }
                    }

                    System.out.println("Texto desencriptado: " + textoDesencriptado);
                } else if (opcionEnigma == 3) {
                    System.out.println("Regresando al menu principal...");
                } else {
                    System.out.println("Opcion no valida.");
                }

            } else if (opcion == 4) {
                System.out.println("Saliendo del programa...");
            } else {
                System.out.println("Opcion no valida");
            }
        }

    }
}
