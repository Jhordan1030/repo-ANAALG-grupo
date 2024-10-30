package trabajo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio3 {

    private int[] arreglo;

    // Constructor que genera el arreglo de números aleatorios
    public Ejercicio3(int n) {
        Random random = new Random();
        arreglo = new int[n];
        for (int num = 0; num < n; num++) {
            arreglo[num] = random.nextInt(100);  // Números aleatorios entre 0 y 99
        }
    }

    // Método para obtener el arreglo generado
    public int[] getArreglo() {
        return arreglo;
    }

    // Método para imprimir el arreglo
    public void mostrarArreglo() {
        System.out.println(Arrays.toString(arreglo));
    }

    // Búsqueda secuencial para encontrar todas las posiciones de un elemento
    public ArrayList<Integer> buscarSecuencial(int numeroBuscado) {
        ArrayList<Integer> posiciones = new ArrayList<>();
        for (int cont = 0; cont < arreglo.length; cont++) {
            if (arreglo[cont] == numeroBuscado) {
                posiciones.add(cont);
            }
        }
        return posiciones;
    }

    // Búsqueda binaria para encontrar todas las posiciones de un elemento
    public ArrayList<Integer> buscarBinaria(int numeroBuscado) {
        ArrayList<Integer> posiciones = new ArrayList<>();
        Arrays.sort(arreglo);  // Ordenar el arreglo para realizar la búsqueda binaria

        int izquierda = 0;
        int derecha = arreglo.length - 1;
        int posicion = -1;

        // Encontrar una posición del número buscado
        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            if (arreglo[medio] == numeroBuscado) {
                posicion = medio;
                break;
            } else if (arreglo[medio] < numeroBuscado) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        // Si se encontró el número, buscar las posiciones adyacentes
        if (posicion != -1) {
            int i = posicion;
            while (i >= 0 && arreglo[i] == numeroBuscado) {
                posiciones.add(i);
                i--;
            }
            i = posicion + 1;
            while (i < arreglo.length && arreglo[i] == numeroBuscado) {
                posiciones.add(i);
                i++;
            }
            posiciones.sort(Integer::compareTo);
        }
        return posiciones;
    }

    public static void main(String[] args) {
        // Código del ejercicio 1 
        System.out.println("Ejecutando Ejercicio 3");
        Scanner scanner = new Scanner(System.in);

        // Solicitar el tamaño del arreglo
        System.out.print("Ingrese la cantidad de números a generar: ");
        int n = scanner.nextInt();

        // Crear instancia de la clase Ejercicio3 y generar el arreglo
        Ejercicio3 ejercicio = new Ejercicio3(n);

        // Imprimir el arreglo generado
        System.out.println("Arreglo generado:");
        ejercicio.mostrarArreglo();

        // Solicitar el número a buscar
        System.out.print("Ingrese el número a buscar: ");
        int numeroBuscado = scanner.nextInt();
        long tiempoInicio = System.nanoTime();
        // Búsqueda secuencial
        ArrayList<Integer> posicionesSecuencial = ejercicio.buscarSecuencial(numeroBuscado);
        if (!posicionesSecuencial.isEmpty()) {
            System.out.println("Búsqueda secuencial - posiciones encontradas: " + posicionesSecuencial);
        } else {
            System.out.println("El número no se encontró en la búsqueda secuencial.");
        }

        // Búsqueda binaria
        ArrayList<Integer> posicionesBinaria = ejercicio.buscarBinaria(numeroBuscado);
        if (!posicionesBinaria.isEmpty()) {
            System.out.println("Búsqueda binaria - posiciones encontradas: " + posicionesBinaria);
        } else {
            System.out.println("El número no se encontró en la búsqueda binaria.");
        }

        // Medir el tiempo de fin de la ejecución total en nanosegundos
        long tiempoFin = System.nanoTime();

        // Calcular y mostrar el tiempo total de ejecución
        long tiempoEjecucionTotal = tiempoFin - tiempoInicio;
        System.out.println("Tiempo total de ejecución: " + tiempoEjecucionTotal + " ns");
    }

}
