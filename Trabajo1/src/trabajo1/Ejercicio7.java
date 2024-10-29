package trabajo1;

import java.util.Random;

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

    private void generarMatriz(int[][] matriz) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = random.nextInt(20) + 1;
            }
        }
    }

    private void multiplicarMatrices() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrizC[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }
    }

    public String imprimirMatriz(int[][] matriz) {
        String resultado = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultado += matriz[i][j] + "\t";
            }
            resultado += "\n";
        }
        return resultado;
    }
    
    public String imprimirMatrices() {
        StringBuilder resultado = new StringBuilder();
        resultado.append(imprimirMatriz(matrizA));
        resultado.append(imprimirMatriz(matrizB));
        resultado.append(imprimirMatriz(matrizC));
        return resultado.toString();
    }
    
}
