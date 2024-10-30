package trabajo1;

import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;

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

    public double calcularDeterminante() {
        double[][] matrizCopia = new double[n][n];
        for (int fila = 0; fila < n; fila++) {
            for (int columna = 0; columna < n; columna++) {
                matrizCopia[fila][columna] = matriz[fila][columna];
            }
        }

        double determinante = 1.0;
        for (int columnaPivote = 0; columnaPivote < n; columnaPivote++) {
            int filaMaxima = columnaPivote;
            for (int filaActual = columnaPivote + 1; filaActual < n; filaActual++) {
                if (Math.abs(matrizCopia[filaActual][columnaPivote]) > Math.abs(matrizCopia[filaMaxima][columnaPivote])) {
                    filaMaxima = filaActual;
                }
            }

            if (columnaPivote != filaMaxima) {
                double[] filaTemporal = matrizCopia[columnaPivote];
                matrizCopia[columnaPivote] = matrizCopia[filaMaxima];
                matrizCopia[filaMaxima] = filaTemporal;
                determinante *= -1;
            }

            if (matrizCopia[columnaPivote][columnaPivote] == 0.0) {
                return 0.0;
            }

            for (int fila = columnaPivote + 1; fila < n; fila++) {
                double factor = matrizCopia[fila][columnaPivote] / matrizCopia[columnaPivote][columnaPivote];
                for (int columna = columnaPivote; columna < n; columna++) {
                    matrizCopia[fila][columna] -= factor * matrizCopia[columnaPivote][columna];
                }
            }

            determinante *= matrizCopia[columnaPivote][columnaPivote];
        }

        // Redondear el determinante a 2 decimales 
        DecimalFormat df = new DecimalFormat("#.##"); 
        return Double.parseDouble(df.format(determinante));
    }

    public String imprimirMatriz() {
        StringBuilder resultado = new StringBuilder();
        for (int filas = 0; filas < n; filas++) {
            for (int columnas = 0; columnas < n; columnas++) {
                resultado.append(matriz[filas][columnas]).append("\t");
            }
            resultado.append("\n");
        }
        return resultado.toString();
    }

    private static int solicitarEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        System.out.println("\nEjecutando Ejercicio 8\n");
        Scanner scanner = new Scanner(System.in);
        int tamaño = solicitarEntero(scanner, "Ingrese el tamaño de la matriz cuadrática (n): ");
        
        long startTimeTotal = System.nanoTime();
        Ejercicio8 matriz = new Ejercicio8(tamaño);
        System.out.println(matriz.imprimirMatriz());
        
        double determinante = matriz.calcularDeterminante();
        System.out.println("El valor del determinante de la matriz es: " + determinante);
        
        long tiemposTotales = System.nanoTime() - startTimeTotal;
        System.out.println("Tiempo ejecución= " + tiemposTotales + " nanosegundos");

        scanner.close();
    }
}
