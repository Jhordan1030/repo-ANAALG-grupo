package trabajo1;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio7 {

    private int[][] matrizA;
    private int[][] matrizB;
    private int[][] matrizC;
    private int n; // Vendría a ser el tamaño para las matrices

    public Ejercicio7(int n) {
        this.n = n;
        this.matrizA = new int[n][n];
        this.matrizB = new int[n][n];
        matrizC = new int[n][n];
        generarMatriz(matrizA);
        generarMatriz(matrizB);
        multiplicarMatrices();
    }

    public int[][] getMatrizA() {
        return matrizA;
    }

    public void setMatrizA(int[][] matrizA) {
        this.matrizA = matrizA;
    }

    public int[][] getMatrizB() {
        return matrizB;
    }

    public void setMatrizB(int[][] matrizB) {
        this.matrizB = matrizB;
    }

    public int[][] getMatrizC() {
        return matrizC;
    }

    public void setMatrizC(int[][] matrizC) {
        this.matrizC = matrizC;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    

    private void generarMatriz(int[][] matriz) { // Genera la matriz con numeros aleatorios
        Random random = new Random();
        for (int filas = 0; filas < n; filas++) {
            for (int columnas = 0; columnas < n; columnas++) {
                matriz[filas][columnas] = random.nextInt(20) + 1;
            }
            System.out.println();
        }
    }

    private void multiplicarMatrices() { // Realiza la multiplicacion de las dos matrices para generar la tercera matriz
        int valor=0;
        for (int filas = 0; filas < n; filas++) {
            for (int columnas = 0; columnas < n; columnas++) {
                for (int variableAuxiliar = 0; variableAuxiliar < n; variableAuxiliar++) {
                    valor += matrizA[filas][variableAuxiliar] * matrizB[variableAuxiliar][columnas];
                }
                matrizC[filas][columnas]=valor;
                valor=0;
            }
        }
    }

    public String imprimirMatriz(int[][] matriz) { // Muestra la matriz
        String resultado = "";
        for (int filas = 0; filas < n; filas++) {
            for (int columnas = 0; columnas < n; columnas++) {
                resultado += matriz[filas][columnas] + "\t";
            }
            resultado += "\n";
        }
        return resultado;
    }
    
    public String imprimirMatrices() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("\nLa matriz A\n");
        resultado.append(imprimirMatriz(matrizA));
        resultado.append("\nLa matriz B\n");
        resultado.append(imprimirMatriz(matrizB));
        resultado.append("\nMatriz C ->  Resultante de la multiplicacion\n");
        resultado.append(imprimirMatriz(matrizC));
        return resultado.toString();
    }
    
    // Método para solicitar un número entero al usuario
    private static int solicitarEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }
    
    public static void main(String[] args) { 
        // Código del ejercicio 7
        System.out.println("\nEjecutando Ejercicio 7\n"); 
        Scanner scanner = new Scanner(System.in);
        int tamaño = solicitarEntero(scanner, "Ingrese el tamaño de la matriz cuadrática (n): ");        
        
        long tiemposTotales=0;
        long startTimeTotal = System.nanoTime();
        Ejercicio7 matriz = new Ejercicio7(tamaño);
        matriz.multiplicarMatrices();
        System.out.println(matriz.imprimirMatrices());
        tiemposTotales = System.nanoTime() - startTimeTotal;
        System.out.println("Tiempo ejecución= "+tiemposTotales+" nanosegundos");
        
        scanner.close();
    }
    
}
