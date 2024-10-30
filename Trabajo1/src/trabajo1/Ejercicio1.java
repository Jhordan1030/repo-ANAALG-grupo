package trabajo1;

import java.util.Scanner;

public class Ejercicio1 {

    int[] numeros;

    // Constructor que genera los números aleatorios
    Ejercicio1(int n) {
        this.numeros = new int[n];
        generarNumerosAleatorios();
    }

    // Función para verificar si un número es primo
    private static boolean esPrimo(int num) {
        if (num < 2) {
            return false;
        }
        for (int contador = 2; contador <= Math.sqrt(num); contador++) { // Corregido el <=
            if (num % contador == 0) {
                return false;
            }
        }
        return true;
    }

    // Generar n números aleatorios y guardarlos en el arreglo de la clase
    private void generarNumerosAleatorios() {
        for (int num = 0; num < numeros.length; num++) {
            numeros[num] = (int) (Math.random() * 101); // Genera números entre 0 y 100
        }
    }

    // Contar y mostrar los números primos en el arreglo
    public static void contarPrimos(int[] arreglo) {
        int contadorPrimos = 0;
        System.out.print("Números primos: ");
        for (int num = 0; num < arreglo.length; num++) {
            if (esPrimo(arreglo[num])) {
                System.out.print(arreglo[num] + " ");
                contadorPrimos++;
            }
        }

        System.out.println("\nCantidad de números primos: " + contadorPrimos);
    }

    // Mostrar los números generados
    public void mostrar() {
        for (int num = 0; num < numeros.length; num++) {
            System.out.print(numeros[num] + " \t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Código del ejercicio 1 
        System.out.println("Ejecutando Ejercicio 1");
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de números aleatorios a generar:");
        int n = entrada.nextInt();

        // Medir el tiempo de inicio total
        long startTime = System.nanoTime();

        // Crear instancia de Ejercicio1 y ejecutar las operaciones
        Ejercicio1 ejercicio = new Ejercicio1(n);
        ejercicio.mostrar();

        // Contar números primos
        Ejercicio1.contarPrimos(ejercicio.numeros);

        // Medir el tiempo de fin total
        long endTime = System.nanoTime();

        // Calcular el tiempo total de ejecución
        long totalExecutionTime = endTime - startTime;
        System.out.println("Tiempo total de ejecución: " + totalExecutionTime + " nanosegundos");
        
        entrada.close();

    }

}
