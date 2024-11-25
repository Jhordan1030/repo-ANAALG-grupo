package com;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio2 {
    private int[][] matriz;

    // Constructor para inicializar la matriz con datos aleatorios
    public Ejercicio2(int m, int n) {
        matriz = new int[m][n];
        Random random = new Random();
        for (int fila = 0; fila < m; fila++) {
            for (int columna = 0; columna < n; columna++) {
                matriz[fila][columna] = random.nextInt(100); // Números aleatorios entre 0 y 99
            }
        }
    }


    // Método para imprimir la matriz
    public void imprimirMatriz() {
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + "\t");
            }
            System.out.println();
        }
    }

    // Método para ordenar una fila usando burbuja mejorada
    public void ordenarFila(int fila) {
        boolean intercambio;
        int longitud = matriz[fila].length;
        do {
            intercambio = false;
            for (int columna = 0; columna < longitud - 1; columna++) {
                if (matriz[fila][columna] > matriz[fila][columna + 1]) {
                    // Intercambiar
                    int temp = matriz[fila][columna];
                    matriz[fila][columna] = matriz[fila][columna + 1];
                    matriz[fila][columna + 1] = temp;
                    intercambio = true;
                }
            }
            longitud--; // Reducir el rango de comparación
        } while (intercambio);
    }

    // Método para ordenar una columna usando burbuja mejorada
    public void ordenarColumna(int columna) {
        boolean intercambio;
        int filas = matriz.length;
        do {
            intercambio = false;
            for (int fila = 0; fila < filas - 1; fila++) {
                if (matriz[fila][columna] > matriz[fila + 1][columna]) {
                    // Intercambiar
                    int temp = matriz[fila][columna];
                    matriz[fila][columna] = matriz[fila + 1][columna];
                    matriz[fila + 1][columna] = temp;
                    intercambio = true;
                }
            }
            filas--; // Reducir el rango de comparación
        } while (intercambio);
    }

    // Getter para acceder a la matriz (si es necesario)
    public int[][] getMatriz() {
        return matriz;
    }

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
       
    }
}
