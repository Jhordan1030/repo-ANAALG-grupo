package com;

import java.util.Scanner;

public class Ejercicio4 {

    public int[][] matriz;

    public Ejercicio4(int n) { // n debe ser un numero impar
        this.matriz = new int[n][n];
    }

    public void matrizRombo(int p) { // p representa los primeros numeros a llenar en la matriz rombo
        int centro = matriz.length / 2;
        int numero = 1;

        // Llenar la mitad superior de la matriz (incluido el centro)
        for (int fila = 0; fila <= centro && numero <= p; fila++) {
            for (int columna = centro - fila; columna <= centro + fila && numero <= p; columna++) {
                matriz[fila][columna] = numero++;
            }
        }

        // Llenar la mitad inferior de la matriz
        for (int fila = centro + 1; fila < matriz.length && numero <= p; fila++) {
            for (int columna = fila - centro; columna < matriz.length - (fila - centro) && numero <= p; columna++) {
                matriz[fila][columna] = numero++;
            }
        }
    }

    
    
    public String imprimirMatriz() {
        StringBuilder resultado = new StringBuilder();
        for (int filas = 0; filas < matriz.length; filas++) {
            for (int columnas = 0; columnas < matriz[0].length; columnas++) {
                if (matriz[filas][columnas] != 0) {
                    resultado.append(matriz[filas][columnas]).append("\t");
                } else {
                    resultado.append("\t"); 
                }
            }
            resultado.append("\n");
        }
        return resultado.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tamaño de la matriz: ");
        int n = scanner.nextInt();  // n es el tamaño de la matriz
        Ejercicio4 matriz = new Ejercicio4(n);
        System.out.println("Ingrese el numero de los primeros elementos que se mostraran en la matriz");
        int p = scanner.nextInt();
        matriz.matrizRombo(p);
        System.out.println(matriz.imprimirMatriz());
    }
}
