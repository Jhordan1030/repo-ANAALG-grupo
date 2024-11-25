package com;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio1 {
    // Método para generar un arreglo de números aleatorios
    public static int[] generarNumerosAleatorios(int n) {
        int[] arreglo = new int[n];
        Random rand = new Random();
        for (int cont = 0; cont < n; cont++) {
            arreglo[cont] = rand.nextInt(100);  // Genera números aleatorios entre 0 y 99
        }
        return arreglo;
    }

    // Búsqueda secuencial
    public static int busquedaSecuencial(int[] arreglo, int elemento) {
        for (int cont = 0; cont < arreglo.length; cont++) {
            if (arreglo[cont] == elemento) {
                return cont;  // Retorna la posición si encuentra el elemento
            }
        }
        return -1;  // Retorna -1 si no se encuentra el elemento
    }

    // Búsqueda binaria
    public static int busquedaBinaria(int[] arreglo, int elemento) {
        int izquierda = 0, derecha = arreglo.length - 1;
        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            if (arreglo[medio] == elemento) {
                return medio;  // Retorna la posición si encuentra el elemento
            }
            if (arreglo[medio] < elemento) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return -1;  // Retorna -1 si no se encuentra el elemento
    }

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        // Solicitar tamaño del arreglo
        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = scanner.nextInt();

        // Medir el tiempo de inicio total
        long startTime = System.nanoTime();



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