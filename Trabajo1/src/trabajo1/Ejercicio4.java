/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajo1;

import java.util.ArrayList;
import java.util.Random;

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
        // Tu código aquí
    }
    
}

    

