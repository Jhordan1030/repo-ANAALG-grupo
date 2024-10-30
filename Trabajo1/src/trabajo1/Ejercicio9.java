
package trabajo1;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio9 {
    private int[][] matriz;
    private int filas;
    private int columnas;

    // Constructor para generar la matriz aleatoria
    public Ejercicio9(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new int[filas][columnas];
        llenarMatriz();
    }

    // Método para llenar la matriz con números aleatorios
    private void llenarMatriz() {
        Random random = new Random();
        for (int contadorFilas = 0; contadorFilas < filas; contadorFilas++) {
            for (int contadorColumnas = 0; contadorColumnas < columnas; contadorColumnas++) {
                matriz[contadorFilas][contadorColumnas] = random.nextInt(99) + 1; // Números entre 1 y 99
            }
        }
    }

    // Método para imprimir la matriz
    public void imprimirMatriz() {
        for (int contadorFilas = 0; contadorFilas < filas; contadorFilas++) {
            for (int contadorColumnas = 0; contadorColumnas < columnas; contadorColumnas++) {
                System.out.print(matriz[contadorFilas][contadorColumnas] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Método para ordenar las columnas de la matriz
    public void ordenarColumnas() {
        for (int contadorColumnas = 0; contadorColumnas < columnas; contadorColumnas++) {
            ordenarPorSeleccion(contadorColumnas);
        }
    }

    // Método de ordenamiento por selección
    private void ordenarPorSeleccion(int columna) {
        for (int contadorFilas = 0; contadorFilas < filas - 1; contadorFilas++) {
            int minimoIndex = contadorFilas;
            for (int contador = contadorFilas + 1; contador < filas; contador++) {
                if (matriz[contador][columna] < matriz[minimoIndex][columna]) {
                    minimoIndex = contador;
                }
            }
            // Swap
            int valorTemporal = matriz[minimoIndex][columna];
            matriz[minimoIndex][columna] = matriz[contadorFilas][columna];
            matriz[contadorFilas][columna] = valorTemporal;
        }
    }

    // Método para solicitar un número entero al usuario
    private static int solicitarEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    // Método para realizar mediciones de tiempo
    private static void realizarMediciones(int filas, int columnas, long tiemposSeleccion, long tiemposTotales) {
        
            Ejercicio9 matriz = new Ejercicio9(filas, columnas);
            System.out.println("Matriz generada :");
            matriz.imprimirMatriz();

            long startTimeTotal = System.nanoTime();
            medirOrdenamientoSeleccion(matriz, tiemposSeleccion);
            tiemposTotales = System.nanoTime() - startTimeTotal;
    }

    // Método para medir el tiempo de ordenamiento por selección
    private static void medirOrdenamientoSeleccion(Ejercicio9 matriz, long tiemposSeleccion) {
        long startTime = System.nanoTime();
        matriz.ordenarColumnas();
        tiemposSeleccion = System.nanoTime() - startTime;

        System.out.println("Ordenado con método de selección:");
        matriz.imprimirMatriz();
    }

    // Método para mostrar los resultados de las mediciones
    private static void mostrarResultados(long tiemposSeleccion, long tiemposTotales) {
        mostrarTiempos("método de selección", tiemposSeleccion);
        mostrarTiempos("total", tiemposTotales);
        
    }

    // Método para mostrar los tiempos de ejecución
    private static void mostrarTiempos(String descripcion, long tiempos) {
        System.out.println("Tiempos de ejecución del " + descripcion + " (nanosegundos):");
        
            System.out.println(tiempos);
    }

    
    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        // Código del ejercicio 9 
        System.out.println("\nEjecutando Ejercicio 9\n"); 
        Scanner scanner = new Scanner(System.in);
        int filas = solicitarEntero(scanner, "Ingrese el número de filas (m): ");
        int columnas = solicitarEntero(scanner, "Ingrese el número de columnas (n): ");
        
        long tiemposSeleccion = 0;
        long tiemposTotales = 0;

        realizarMediciones(filas, columnas, tiemposSeleccion, tiemposTotales);
        mostrarResultados(tiemposSeleccion, tiemposTotales);

        scanner.close();
    }
}
