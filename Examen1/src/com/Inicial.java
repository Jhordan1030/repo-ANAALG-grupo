
package com;


import java.util.Arrays;
import java.util.Scanner;

public class Inicial {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar tamaño del arreglo
        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = scanner.nextInt();

        // Generar el arreglo con números aleatorios
        int[] arreglo = Ejercicio1.generarNumerosAleatorios(n);

        // Mostrar el arreglo generado
        System.out.println("Arreglo generado: " + Arrays.toString(arreglo));

        // Solicitar el elemento a buscar
        System.out.print("Ingrese el número que desea buscar: ");
        int elemento = scanner.nextInt();

        // Buscar el elemento utilizando búsqueda secuencial
        int posicionSecuencial = Ejercicio1.busquedaSecuencial(arreglo, elemento);
        if (posicionSecuencial != -1) {
            System.out.println("Elemento encontrado en la posición (búsqueda secuencial): " + posicionSecuencial);
        } else {
            System.out.println("Elemento no encontrado (búsqueda secuencial).");
        }

        // Ordenar el arreglo para la búsqueda binaria
        Arrays.sort(arreglo);
        System.out.println("Arreglo ordenado: " + Arrays.toString(arreglo));

        // Buscar el elemento utilizando búsqueda binaria
        int posicionBinaria = Ejercicio1.busquedaBinaria(arreglo, elemento);
        if (posicionBinaria != -1) {
            System.out.println("Elemento encontrado en la posición (búsqueda binaria): " + posicionBinaria);
        } else {
            System.out.println("Elemento no encontrado (búsqueda binaria).");
        }
    }
    
}
