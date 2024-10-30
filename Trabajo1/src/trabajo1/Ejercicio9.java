
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
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(99) + 1; // Números entre 1 y 99
            }
        }
    }

    // Método para imprimir la matriz
    public void imprimirMatriz() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Método para ordenar las columnas de la matriz
    public void ordenarColumnas() {
        for (int j = 0; j < columnas; j++) {
            ordenarPorSeleccion(j);
        }
    }

    // Método de ordenamiento por selección
    private void ordenarPorSeleccion(int col) {
        for (int i = 0; i < filas - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < filas; j++) {
                if (matriz[j][col] < matriz[minIndex][col]) {
                    minIndex = j;
                }
            }
            // Swap
            int temp = matriz[minIndex][col];
            matriz[minIndex][col] = matriz[i][col];
            matriz[i][col] = temp;
        }
    }

    // Método para solicitar un número entero al usuario
    private static int solicitarEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    // Método para realizar mediciones de tiempo
    private static void realizarMediciones(int filas, int columnas, int numMediciones, long[] tiemposSeleccion, long[] tiemposTotales) {
        for (int i = 0; i < numMediciones; i++) {
            Ejercicio9 matriz = new Ejercicio9(filas, columnas);
            System.out.println("Matriz generada " + (i + 1) + ":");
            matriz.imprimirMatriz();

            long startTimeTotal = System.nanoTime();
            medirOrdenamientoSeleccion(matriz, tiemposSeleccion, i);
            tiemposTotales[i] = System.nanoTime() - startTimeTotal;
        }
    }

    // Método para medir el tiempo de ordenamiento por selección
    private static void medirOrdenamientoSeleccion(Ejercicio9 matriz, long[] tiemposSeleccion, int index) {
        long startTime = System.nanoTime();
        matriz.ordenarColumnas();
        tiemposSeleccion[index] = System.nanoTime() - startTime;

        System.out.println("Ordenado con método de selección:");
        matriz.imprimirMatriz();
    }

    // Método para mostrar los resultados de las mediciones
    private static void mostrarResultados(long[] tiemposSeleccion, long[] tiemposTotales) {
        mostrarTiempos("método de selección", tiemposSeleccion);
        mostrarTiempos("total", tiemposTotales);
        System.out.println("Promedios de tiempos de ejecución:");
        System.out.println("Método de selección: " + calcularPromedio(tiemposSeleccion) + " nanosegundos");
        System.out.println("Total: " + calcularPromedio(tiemposTotales) + " nanosegundos");
    }

    // Método para mostrar los tiempos de ejecución
    private static void mostrarTiempos(String descripcion, long[] tiempos) {
        System.out.println("Tiempos de ejecución del " + descripcion + " (nanosegundos):");
        for (long tiempo : tiempos) {
            System.out.println(tiempo);
        }
    }

    // Método para calcular el promedio de los tiempos de ejecución
    private static long calcularPromedio(long[] tiempos) {
        long suma = 0;
        for (long tiempo : tiempos) {
            suma += tiempo;
        }
        return suma / tiempos.length;
    }

    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        // Código del ejercicio 9 
        System.out.println("\nEjecutando Ejercicio 9\n"); 
        Scanner scanner = new Scanner(System.in);
        int filas = solicitarEntero(scanner, "Ingrese el número de filas (m): ");
        int columnas = solicitarEntero(scanner, "Ingrese el número de columnas (n): ");
        int numMediciones = 1;
        long[] tiemposSeleccion = new long[numMediciones];
        long[] tiemposTotales = new long[numMediciones];

        realizarMediciones(filas, columnas, numMediciones, tiemposSeleccion, tiemposTotales);
        mostrarResultados(tiemposSeleccion, tiemposTotales);

        scanner.close();
    }
}
