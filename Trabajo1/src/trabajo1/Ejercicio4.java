/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajo1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Giuliana Espinoza
 */
public class Ejercicio4 {
    

/**
 * Clase que representa un arreglo de números enteros, permitiendo generar números aleatorios,
 * insertar un número en una posición específica, e imprimir su contenido.
 * 
 * @author Giuliana Espinoza
 */

    private static final int VALOR_MAXIMO = 100;
    private ArrayList<Integer> numeros; 
    
    /**
     * Constructor para inicializar el arreglo con números aleatorios.
     * 
     * @param tamano Tamaño del arreglo.
     */
    public Ejercicio4(int tamano) {
        numeros = new ArrayList<>();
        if (tamano > 0) {
            inicializarConNumerosAleatorios(tamano);
        } else {
            System.out.println("El tamaño debe ser positivo. Tamaño recibido: " + tamano);
        }
    }
    
    /**
     * Inicializa el arreglo con números aleatorios en el rango de 0 a VALOR_MAXIMO.
     * 
     * @param tamano Cantidad de números a generar.
     */
    private void inicializarConNumerosAleatorios(int tamano) {
        Random random = new Random();
        for (int i = 0; i < tamano; i++) {
            numeros.add(random.nextInt(VALOR_MAXIMO)); 
        }
    }
    
    /**
     * Inserta un valor en la posición especificada dentro del arreglo.
     * 
     * @param valor Valor a insertar.
     * @param posicion Posición donde se desea insertar el valor.
     */
    public void insertarNumero(int valor, int posicion) {
        if (posicion >= 0 && posicion <= numeros.size()) {
            numeros.add(posicion, valor);
        } else {
            System.out.println("Posición inválida: " + posicion);
        }
    }
     
    /**
     * Imprime el contenido del arreglo con un mensaje específico.
     * 
     * @param mensaje Mensaje a mostrar antes de imprimir el arreglo.
     */
    public void imprimirConMensaje(String mensaje) {
        System.out.println(mensaje + numeros);
    }

    /**
     * Obtiene el tamaño actual del arreglo.
     * 
     * @return Tamaño del arreglo.
     */
    public int getTamano() {
        return numeros.size();
    }
    
    public static void main(String[] args) { 
    // Código del ejercicio 1 
        System.out.println("\nEjecutando Ejercicio 4\n");
        long startTime = System.nanoTime(); // Inicia el cronómetro

        Scanner scanner = new Scanner(System.in);

        // Paso 1: Crear el arreglo original
        System.out.print("Ingrese el tamaño del arreglo original: ");
        int tamano = scanner.nextInt();
        if (tamano <= 0) {
            System.out.println("El tamaño debe ser un número positivo.");
            return;
        }

        Ejercicio4 arreglo = new    Ejercicio4(tamano);
        arreglo.imprimirConMensaje("Arreglo original: ");

        // Paso 2: Insertar nuevos datos
        insertarNuevosDatos(arreglo, scanner);

        // Imprimir arreglo modificado
        arreglo.imprimirConMensaje("Arreglo modificado: ");
        System.out.println("Nuevo tamaño del arreglo: " + arreglo.getTamano());

        scanner.close();

        // Finaliza el cronómetro y muestra el tiempo de ejecución
        long endTime = System.nanoTime();
        long duration = endTime - startTime;   
        System.out.println("Tiempo de ejecución: " + duration + " ns");
    }

    /**
     * Inserta nuevos valores en el arreglo en posiciones específicas dadas por el usuario.
     * 
     * @param arreglo El arreglo en el que se insertarán los nuevos valores.
     * @param scanner Scanner para la entrada del usuario.
     */
    private static void insertarNuevosDatos(Ejercicio4 arreglo, Scanner scanner) {
        System.out.print("Ingrese la cantidad de datos a insertar: ");
        int cantidadInserciones = scanner.nextInt();

        for (int i = 0; i < cantidadInserciones; i++) {
            System.out.print("Ingrese el valor a insertar: ");
            int valor = scanner.nextInt();
            System.out.print("Ingrese la posición en la que desea insertarlo (0 a " + arreglo.getTamano() + "): ");
            int posicion = scanner.nextInt();

            if (posicion >= 0 && posicion <= arreglo.getTamano()) {
                arreglo.insertarNumero(valor, posicion);
            } else {
                System.out.println("Posición inválida: " + posicion);
            }
        }
    }
        
        
    }
    

    

