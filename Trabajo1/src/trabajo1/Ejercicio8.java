package trabajo1;


import java.util.Random;
import java.util.Scanner;

public class Ejercicio8 {

    private int[][] matriz;
    private int n;

    public Ejercicio8(int n) {
        this.n = n;
        matriz = new int[n][n];
        Random random = new Random();
        for (int filas = 0; filas < n; filas++) {
            for (int columnas = 0; columnas < n; columnas++) {
                matriz[filas][columnas] = random.nextInt(20) + 1;
            }
        }
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int calcularDeterminante() { 
        int[][] matrizCopia = new int[n][n];
        for (int fila = 0; fila < n; fila++) {
            for (int columna = 0; columna < n; columna++) {
                matrizCopia[fila][columna] = matriz[fila][columna];
            }
        }
        int determinante = 1;
        // Procesar cada columna para realizar la eliminación del metodo Gauss
        for (int columnaPivote = 0; columnaPivote < n; columnaPivote++) {
            int filaMaxima = columnaPivote;
            // Encontrar la fila con el valor absoluto máximo en la columna actual (pivote)
            for (int filaActual = columnaPivote + 1; filaActual < n; filaActual++) {
                if (Math.abs(matrizCopia[filaActual][columnaPivote]) > Math.abs(matrizCopia[filaMaxima][columnaPivote])) {
                    filaMaxima = filaActual;
                }
            }
            // Si el pivote no está en la fila actual, se intercambia filas para maximizar la precisión
            if (columnaPivote != filaMaxima) {
                int[] filaTemporal = matrizCopia[columnaPivote];
                matrizCopia[columnaPivote] = matrizCopia[filaMaxima];
                matrizCopia[filaMaxima] = filaTemporal;
                determinante *= -1;
            }
            // Si el elemento de pivote es cero, la matriz es singular y el determinante es cero
            if (matrizCopia[columnaPivote][columnaPivote] == 0) {
                return 0;
            }
            // Realizar la eliminación de Gauss para crear ceros debajo del pivote
            for (int fila = columnaPivote + 1; fila < n; fila++) {
                double factor = (double) matrizCopia[fila][columnaPivote] / matrizCopia[columnaPivote][columnaPivote];
                for (int columna = columnaPivote; columna < n; columna++) {
                    matrizCopia[fila][columna] -= factor * matrizCopia[columnaPivote][columna];
                }
            }
            determinante *= matrizCopia[columnaPivote][columnaPivote];
        }
        return determinante;
    }

    public String imprimirMatriz() {
        String resultado = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultado += matriz[i][j] + "\t";
            }
            resultado += "\n";
        }
        return resultado;
    }
    
    // Método para solicitar un número entero al usuario
    private static int solicitarEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }
    
    public static void main(String[] args) { 
        // Código del ejercicio 8 
        int determinante = 0;
        System.out.println("\nEjecutando Ejercicio 9\n"); 
        Scanner scanner = new Scanner(System.in);
        int tamaño = solicitarEntero(scanner, "Ingrese el tamaño de la matriz cuadrática (n): ");        
        long tiemposSeleccion=0;
        long tiemposTotales=0;
        Ejercicio8 matriz = new Ejercicio8(tamaño);
        System.out.println(matriz.imprimirMatriz());
        determinante = matriz.calcularDeterminante();
        System.out.println("El valor del determinante de la matriz es: " + determinante);
        long startTimeTotal = System.nanoTime();
        tiemposTotales = System.nanoTime() - startTimeTotal;
        System.out.println("Tiempo ejecución= "+tiemposTotales+" nanosegundos");
        
        scanner.close();
    }
}
