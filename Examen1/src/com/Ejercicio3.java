package com;

import java.util.Scanner;

public class Ejercicio3 {
    // Atributos de la clase
    private int filas;
    private int columnas;
    private int[][] matriz;

    /**
     * Constructor para inicializar la matriz con las dimensiones especificadas.
     *
     * @param filas    Número de filas de la matriz.
     * @param columnas Número de columnas de la matriz.
     */
    public Ejercicio3(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new int[filas][columnas];
    }

    /**
     * Método para llenar la matriz siguiendo el patrón de diagonales.
     * Los números se incrementan secuencialmente, comenzando desde 1.
     */
    public void llenarMatriz() {
        int numero = 1;

        // Recorre todas las diagonales de la matriz
        for (int suma = 0; suma < filas + columnas - 1; suma++) {
            if (suma % 2 == 0) { // Diagonales pares (invertidas)
                for (int indiceFila = 0; indiceFila < filas; indiceFila++) {
                    int indiceColumna = suma - indiceFila;
                    if (indiceColumna >= 0 && indiceColumna < columnas) {
                        matriz[indiceFila][indiceColumna] = numero++;
                    }
                }
            } else { // Diagonales impares (normales)
                for (int indiceColumna = 0; indiceColumna < columnas; indiceColumna++) {
                    int indiceFila = suma - indiceColumna;
                    if (indiceFila >= 0 && indiceFila < filas) {
                        matriz[indiceFila][indiceColumna] = numero++;
                    }
                }
            }
        }
    }

    /**
     * Método para imprimir la matriz en la consola.
     */
    public void imprimirMatriz() {
        System.out.println("Matriz resultante:");
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Crear un objeto Scanner para leer los datos del usuario
        java.util.Scanner scanner = new Scanner(System.in);

        // Solicitar las dimensiones de la matriz al usuario
        System.out.print("Ingrese el número de filas (n): ");
        int numeroFilas = scanner.nextInt();

        System.out.print("Ingrese el número de columnas (m): ");
        int numeroColumnas = scanner.nextInt();

        // Crear una instancia de MatrizDiagonales con las dimensiones ingresadas
        Ejercicio3 matriz = new Ejercicio3(numeroFilas, numeroColumnas);

        // Llenar la matriz siguiendo el patrón de diagonales
        matriz.llenarMatriz();

        // Imprimir la matriz generada
        matriz.imprimirMatriz();

    }
}