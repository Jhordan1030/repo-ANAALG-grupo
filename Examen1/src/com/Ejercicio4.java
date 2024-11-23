package com;

public class Ejercicio4 {
    
    public int [][] matriz;

    public Ejercicio4(int n) { // n debe ser un numero impar
        this.matriz = new int[n][n];
    }
    
    public void matrizRombo(int p){ // p representa los primeros numeros a llenar en la matriz rombo
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
    
    public long calcularTiempoEjecucion(int p) {
        long inicio = System.nanoTime();
        matrizRombo(p);
        long fin = System.nanoTime();
        return fin - inicio;
    }
    
    public String imprimirMatriz(){
        String resultado = "";
        for (int filas = 0; filas < matriz.length; filas++) {
            for (int columnas = 0; columnas < matriz[0].length; columnas++) {
                resultado += matriz[filas][columnas] + "\t";
            }
            resultado += "\n";
        } 
        return resultado;
    }   
}