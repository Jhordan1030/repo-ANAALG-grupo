package trabajo1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Ejercicio2 {

    int[] numeros;
    int[] numeros2;

    // Constructor que genera los números aleatorios
    Ejercicio2(int n) {
        this.numeros = new int[n];
        this.numeros2 = new int[n];
        generarNumerosAleatorios();
    }

    // Generar números aleatorios y guardarlos en los arreglos de la clase
    private void generarNumerosAleatorios() {
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 101);  // Genera números entre 0 y 100
            numeros2[i] = (int) (Math.random() * 101); // Genera números entre 0 y 100 para el segundo arreglo
        }
    }

    // Mostrar los números generados de ambos arreglos
    public void mostrar() {
        System.out.println("Arreglo numeros:");
        for (int num : numeros) {
            System.out.print(num + "\t");
        }
        System.out.println();

        System.out.println("Arreglo numeros2:");
        for (int num : numeros2) {
            System.out.print(num + "\t");
        }
        System.out.println();
    }

    // Encontrar elementos de numeros que están en numeros2
    public ArrayList<Integer> elementosEnNumeros2() {
        return elementosEnComun(numeros, numeros2);
    }

    // Encontrar elementos de numeros2 que están en numeros
    public ArrayList<Integer> elementosEnNumeros() {
        return elementosEnComun(numeros2, numeros);
    }

    // Método privado para encontrar elementos comunes entre dos arreglos
    private ArrayList<Integer> elementosEnComun(int[] arreglo1, int[] arreglo2) {
        HashSet<Integer> conjunto = new HashSet<>();
        ArrayList<Integer> elementosComunes = new ArrayList<>();

        for (int num : arreglo2) {
            conjunto.add(num);
        }

        for (int num : arreglo1) {
            if (conjunto.contains(num) && !elementosComunes.contains(num)) {
                elementosComunes.add(num);
            }
        }

        return elementosComunes;
    }
    
    public static void main(String[] args) { 
        // Código del ejercicio 1 
        System.out.println("Ejecutando Ejercicio 2"); 
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese el valor de números:");
        int n = entrada.nextInt();

        long tiempoInicio = System.nanoTime();

        Ejercicio2 numeros = new Ejercicio2(n);
        numeros.mostrar();
        System.out.println("Elementos de numeros que están en numeros2: " + numeros.elementosEnNumeros2());
        System.out.println("Elementos de numeros2 que están en numeros: " + numeros.elementosEnNumeros());
        long tiempoFin = System.nanoTime();
        long tiempoEjecucion = tiempoFin - tiempoInicio;
        System.out.println("Tiempo de ejecución: " + tiempoEjecucion + " ns");

    }
    
}
