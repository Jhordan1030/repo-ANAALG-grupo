
package com;


import java.util.Arrays;
import java.util.Scanner;

public class Inicial {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar tamaño de la matriz
        System.out.print("Ingrese el número de filas (m): ");
        int m = scanner.nextInt();
        System.out.print("Ingrese el número de columnas (n): ");
        int n = scanner.nextInt();

        // Crear la instancia de Ejercicio2 con la matriz
        Ejercicio2 ejercicio = new Ejercicio2(m, n);

        System.out.println("Matriz original:");
        ejercicio.imprimirMatriz();

        // Preguntar al usuario si quiere ordenar una fila o columna
        System.out.print("¿Desea ordenar una fila o columna? (1: fila, 2: columna): ");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            // Ordenar fila
            System.out.print("Ingrese el número de la fila a ordenar (0 a " + (m - 1) + "): ");
            int fila = scanner.nextInt();
            if (fila >= 0 && fila < m) {
                ejercicio.ordenarFila(fila);
                System.out.println("Matriz con la fila ordenada:");
                ejercicio.imprimirMatriz();
            } else {
                System.out.println("Número de fila inválido.");
            }
        } else if (opcion == 2) {
            // Ordenar columna
            System.out.print("Ingrese el número de la columna a ordenar (0 a " + (n - 1) + "): ");
            int columna = scanner.nextInt();
            if (columna >= 0 && columna < n) {
                ejercicio.ordenarColumna(columna);
                System.out.println("Matriz con la columna ordenada:");
                ejercicio.imprimirMatriz();
            } else {
                System.out.println("Número de columna inválido.");
            }
        } else {
            System.out.println("Opción inválida.");
        }

        scanner.close();
    }
    
}
