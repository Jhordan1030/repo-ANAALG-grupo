package trabajo1;

import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio3 {

    int[] arreglo;
    int[] arregloOriginal;

    // Constructor que genera el arreglo de números aleatorios
    public Ejercicio3(int n) {
        this.arreglo = new int[n];
        this.arregloOriginal = new int[n];
        generarNumerosAleatorios();
    }

    // Método para generar números aleatorios
    private void generarNumerosAleatorios() {
        for (int num = 0; num < arreglo.length; i++) {
            arreglo[num] = (int) (Math.random() * 101); // Números entre 0 y 100
        }
        // Guardar el arreglo original antes de ordenar para la búsqueda binaria
        System.arraycopy(arreglo, 0, arregloOriginal, 0, arreglo.length);
    }

    // Método para mostrar el arreglo original y el arreglo ordenado
    public void mostrarArregloOriginal() {
        System.out.print("Arreglo original: ");
        for (int num : arregloOriginal) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public void mostrarArregloOrdenado() {
        System.out.print("Arreglo ordenado para búsqueda binaria: ");
        Arrays.sort(arreglo);  // Ordenar el arreglo
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Búsqueda secuencial de un elemento, retorna una lista de posiciones donde se encuentra
    public ArrayList<Integer> busquedaSecuencial(int elemento) {
        ArrayList<Integer> posiciones = new ArrayList<>();
        for (int num = 0; num < arregloOriginal.length; num++) {
            if (arregloOriginal[num] == elemento) {
                posiciones.add(num);
            }
        }
        return posiciones;
    }

    // Búsqueda binaria de un elemento, retorna una lista de posiciones donde se encuentra
    public ArrayList<Integer> busquedaBinaria(int elemento) {
        ArrayList<Integer> posiciones = new ArrayList<>();
        int izquierda = 0;
        int derecha = arreglo.length - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;

            if (arreglo[medio] == elemento) {
                posiciones.add(medio);

                // Buscar a la izquierda y derecha de la posición encontrada
                int col = medio - 1;
                while (col >= 0 && arreglo[col] == elemento) {
                    posiciones.add(col);
                    col--;
                }

                int fila = medio + 1;
                while (fila < arreglo.length && arreglo[fila] == elemento) {
                    posiciones.add(fila);
                    fila++;
                }
                break;
            } else if (arreglo[medio] < elemento) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return posiciones;
    }
}
