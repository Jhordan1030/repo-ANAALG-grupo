/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajo1;

import java.util.Scanner;

/**
 *
 * @author Giuliana Espinoza
 */
public class Ejercicio6 {
    

/**
 * Clase para representar y gestionar una matriz de enteros llenada en espiral.
 */

    private int[][] matriz;
    private int filas;
    private int columnas;

    public Ejercicio6(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new int[filas][columnas];
        llenarMatriz();
    }

    /**
     * Llena la matriz en un patrón en espiral desde los bordes hacia el centro.
     */
    private void llenarMatriz() {
        int contador = 1; 
        int filaInicio = filas - 1;
        int columnaInicio = columnas - 1;
        int filaFin = 0;
        int columnaFin = 0;

        while (contador <= filas * columnas) {
            for (int columna = columnaInicio; columna >= columnaFin; columna--) {
                matriz[filaInicio][columna] = contador++;
            }
            filaInicio--;

            for (int fila = filaInicio; fila >= filaFin; fila--) {
                matriz[fila][columnaFin] = contador++;
            }
            columnaFin++;

            if (filaInicio >= filaFin) {
                for (int columna = columnaFin; columna <= columnaInicio; columna++) {
                    matriz[filaFin][columna] = contador++;
                }
                filaFin++;
            }
            if (columnaFin <= columnaInicio) {
                for (int fila = filaFin; fila <= filaInicio; fila++) {
                    matriz[fila][columnaInicio] = contador++;
                }
                columnaInicio--;
            }
        }
    }

    /**
     * Muestra la matriz en formato tabular.
     */
    public void mostrarMatriz() {
        for (int[] fila : matriz) {
            for (int num : fila) {
                System.out.printf("%2d ", num); 
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) { 
   
        System.out.println("\nEjecutando Ejercicio 6\n");
         Scanner scannern = new Scanner(System.in);
          Scanner scannerm = new Scanner(System.in);
         System.out.println(" Ingrese n de la matriz: ");
        int n=scannern.nextInt();
        System.out.println("Ingrese m de la matriz:");
         int m=scannerm.nextInt();
         
       Ejercicio6 matrizEspiral = new Ejercicio6(n,m); 
        medirTiempoEjecucion(() -> matrizEspiral.mostrarMatriz());
        
        scannern.close();
        
        scannerm.close();
    }

    /**
     * Mide y muestra el tiempo de ejecución de una operación.
     * @param operacion La operación a medir.
     */
    private static void medirTiempoEjecucion(Runnable operacion) {
        long tiempoInicio = System.nanoTime();
        
        operacion.run();
        
        long tiempoFin = System.nanoTime();
        long duracionNanosegundos = tiempoFin - tiempoInicio;
        System.out.println("Tiempo de ejecución: " + duracionNanosegundos + " nanosegundos");
    }
    }
    
    


    

