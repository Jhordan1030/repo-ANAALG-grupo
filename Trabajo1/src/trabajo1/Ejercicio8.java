package trabajo1;

import java.util.Random;

public class Ejercicio8 {

    private int[][] matriz;
    private int n;

    // Constructor que inicializa el tamaño de la matriz y la genera aleatoriamente
    public Ejercicio8(int n) {
        this.n = n;
        matriz = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = random.nextInt(10); // Números entre 0 y 9
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

    public int obtenerDeterminante() {
        return calcularDeterminante(matriz, n);
    }

    public int calcularDeterminante(int[][] matriz, int tamaño) {
        int[][] temp = new int[tamaño][tamaño];
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                temp[i][j] = matriz[i][j];
            }
        }
        int determinante = 1;
        for (int i = 0; i < tamaño; i++) {
            int maxFila = i;
            for (int k = i + 1; k < tamaño; k++) {
                if (Math.abs(temp[k][i]) > Math.abs(temp[maxFila][i])) {
                    maxFila = k;
                }
            }

            // Intercambiamos las filas si el pivote no está en la fila actual
            if (i != maxFila) {
                int[] filaTemp = temp[i];
                temp[i] = temp[maxFila];
                temp[maxFila] = filaTemp;
                determinante *= -1; // Cambiamos el signo del determinante
            }

            // Si el elemento de pivote es cero, el determinante es cero
            if (temp[i][i] == 0) {
                return 0;
            }

            // Realizamos la eliminación de Gauss
            for (int k = i + 1; k < tamaño; k++) {
                double factor = (double) temp[k][i] / temp[i][i];
                for (int j = i; j < tamaño; j++) {
                    temp[k][j] -= factor * temp[i][j];
                }
            }
            determinante *= temp[i][i];
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
    
    public static void main(String[] args) { 
        // Código del ejercicio 1 
        System.out.println("Ejecutando Ejercicio 1"); 
        // Tu código aquí 
    }
    
}
