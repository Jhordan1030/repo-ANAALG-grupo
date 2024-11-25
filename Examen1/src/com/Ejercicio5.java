package com;

import java.util.Scanner;

public class Ejercicio5 {

    private int[] izquierdoSuperior, izquierdoInferior, derechoSuperior, derechoInferior;
    private int numeroCentro, numeroSuperior, numeroInferior;
    private int[][] circulo;

    public Ejercicio5(int numeroOrden) {
        numeroCentro = (numeroOrden / 2) + 1;
        numeroSuperior = 1;
        numeroInferior = numeroOrden;
        izquierdoSuperior = new int[numeroCentro];
        izquierdoInferior = new int[numeroCentro];
        derechoSuperior = new int[numeroCentro];
        derechoInferior = new int[numeroCentro];
        circulo = new int[numeroCentro][numeroCentro];
    }

    public void generarCirculo(int numOrden) {
        int contadorIzquierdoInferior = 0, contadorIzquierdoSuperior = 0, contadorDerechoInferior = 0, contadorDerechoSuperior = 0;
        for (int contadorOrden = 2; contadorOrden < numOrden; contadorOrden++) {
            if (contadorOrden != numeroCentro) {
                if (contadorOrden < numeroCentro) {
                    if (contadorOrden % 2 == 0) {
                        izquierdoInferior[contadorIzquierdoInferior++] = contadorOrden;
                    } else {
                        izquierdoSuperior[contadorIzquierdoSuperior++] = contadorOrden;
                    }
                } else {
                    if (contadorOrden % 2 == 0) {
                        derechoSuperior[contadorDerechoSuperior++] = contadorOrden;
                    } else {
                        derechoInferior[contadorDerechoInferior++] = contadorOrden;
                    }
                }
            }
        }
    }

    public void llenarCirculo() {
        int posicionInicial = numeroCentro / 2, contadorVector = 0, contadorSuperior = posicionInicial - 1, contadorInferior = posicionInicial;
        circulo[0][posicionInicial] = numeroSuperior;
        circulo[numeroCentro - 1][posicionInicial] = numeroInferior;
        circulo[posicionInicial][posicionInicial] = numeroCentro;
        for (int contadorColumnas = 0; contadorColumnas < numeroCentro; contadorColumnas++) {
            if (contadorColumnas == 0) {
                circulo[contadorInferior++][contadorColumnas] = izquierdoInferior[contadorVector++];
            } else {
                if (contadorColumnas == posicionInicial) {
                    contadorSuperior = 1;
                    contadorInferior = numeroCentro - 2;
                    contadorVector = 0;
                } else {
                    if (contadorColumnas < posicionInicial && contadorColumnas == 0) {
                        circulo[contadorInferior++][contadorColumnas] = izquierdoInferior[contadorVector++];
                    } else {
                        if (contadorColumnas < posicionInicial) {
                            circulo[contadorSuperior--][contadorColumnas] = izquierdoSuperior[contadorVector - 1];
                            circulo[contadorInferior++][contadorColumnas] = izquierdoInferior[contadorVector++];
                        } else {
                            if (contadorColumnas > posicionInicial) {
                                circulo[contadorInferior--][contadorColumnas] = derechoInferior[contadorVector];
                                circulo[contadorSuperior++][contadorColumnas] = derechoSuperior[contadorVector++];
                            }
                        }
                    }
                }
            }
        }
    }

    public void imprimirCirculo() {
        for (int contadorFilas = 0; contadorFilas < circulo.length; contadorFilas++) {
            for (int contadorColumnas = 0; contadorColumnas < circulo[contadorFilas].length; contadorColumnas++) {
                if (circulo[contadorFilas][contadorColumnas] != 0) {
                    System.out.print(circulo[contadorFilas][contadorColumnas] + "\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroOrden = 0;

        do {
            System.out.print("Ingrese un número impar para el orden del círculo mágico: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingrese un número entero impar: ");
                scanner.next(); 
            }
            numeroOrden = scanner.nextInt();
        } while (numeroOrden % 2 == 0); 
        int tamanioCirculo = (numeroOrden + 1) / 2;
        if (tamanioCirculo % 2 != 0) {
            
            long startTime = System.nanoTime();

            Ejercicio5 circulo = new Ejercicio5(numeroOrden);

            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;

            circulo.generarCirculo(numeroOrden);
            circulo.llenarCirculo();
            circulo.imprimirCirculo();

            System.out.println("Tiempo de ejecución: " + executionTime + " nanosegundos");
            scanner.close();
        } else {
            System.out.print("Por favor! Ingrese un valor valido para el círculo mágico.\n");
        }
    }
}
