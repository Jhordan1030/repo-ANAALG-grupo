package trabajo1;
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
}
