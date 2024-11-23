package com;
import java.util.Random;
public class Ejercicio2 {
    private int[][] matriz;

    // Constructor para inicializar la matriz con datos aleatorios
    public Ejercicio2(int m, int n) {
        matriz = new int[m][n];
        Random random = new Random();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = random.nextInt(100); // Números aleatorios entre 0 y 99
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
        int n = matriz[fila].length;
        do {
            intercambio = false;
            for (int i = 0; i < n - 1; i++) {
                if (matriz[fila][i] > matriz[fila][i + 1]) {
                    // Intercambiar
                    int temp = matriz[fila][i];
                    matriz[fila][i] = matriz[fila][i + 1];
                    matriz[fila][i + 1] = temp;
                    intercambio = true;
                }
            }
            n--; // Reducir el rango de comparación
        } while (intercambio);
    }

    // Método para ordenar una columna usando burbuja mejorada
    public void ordenarColumna(int columna) {
        boolean intercambio;
        int m = matriz.length;
        do {
            intercambio = false;
            for (int i = 0; i < m - 1; i++) {
                if (matriz[i][columna] > matriz[i + 1][columna]) {
                    // Intercambiar
                    int temp = matriz[i][columna];
                    matriz[i][columna] = matriz[i + 1][columna];
                    matriz[i + 1][columna] = temp;
                    intercambio = true;
                }
            }
            m--; // Reducir el rango de comparación
        } while (intercambio);
    }

    // Getter para acceder a la matriz (si es necesario)
    public int[][] getMatriz() {
        return matriz;
    }
}
