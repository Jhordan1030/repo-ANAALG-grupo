package trabajo1;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio10 {
    private Estudiantes[] estudiantes;

    public Ejercicio10(int numEstudiantes, int numNotas) {
        estudiantes = new Estudiantes[numEstudiantes];
        for (int i = 0; i < numEstudiantes; i++) {
            estudiantes[i] = new Estudiantes("Estudiante " + (i + 1), numNotas);
            llenarNotas(estudiantes[i]);
            estudiantes[i].calcularPromedio();
            estudiantes[i].determinarEstado();
        }
    }

    private void llenarNotas(Estudiantes estudiante) {
        Random rand = new Random();
        for (int i = 0; i < estudiante.getNotas().length; i++) {
            estudiante.setNota(i, 1 + rand.nextDouble() * 9); // Notas entre 1 y 10
        }
    }

    public void imprimirEstudiantes() {
        // Imprimir encabezados dinámicamente
        System.out.printf("%-15s", "Estudiante");
        for (int i = 0; i < estudiantes[0].getNotas().length; i++) {
            System.out.printf("%-10s", "Nota " + (i + 1));
        }
        System.out.printf("%-10s %-15s%n", "Promedio", "Estado");

        // Imprimir datos de los estudiantes
        for (Estudiantes estudiante : estudiantes) {
            System.out.printf("%-15s", estudiante.getNombre());
            for (double nota : estudiante.getNotas()) {
                System.out.printf("%-10.2f", nota);
            }
            System.out.printf("%-10.2f %-15s%n", estudiante.getPromedio(), estudiante.getEstado());
        }
    }

    public void contarEstados() {
        int aprobados = 0;
        int supletorios = 0;
        int reprobados = 0;

        for (Estudiantes estudiante : estudiantes) {
            switch (estudiante.getEstado()) {
                case "Aprobado":
                    aprobados++;
                    break;
                case "Supletorio":
                    supletorios++;
                    break;
                case "Reprobado":
                    reprobados++;
                    break;
            }
        }

        System.out.println("\nCantidad de estudiantes:");
        System.out.println("Aprobados: " + aprobados);
        System.out.println("Supletorio: " + supletorios);
        System.out.println("Reprobados: " + reprobados);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numEstudiantes = solicitarEntero(scanner, "Ingrese el número de estudiantes: ");
        int numNotas = solicitarEntero(scanner, "Ingrese el número de notas por estudiante: ");

        long inicio = System.nanoTime();
        Ejercicio10 notas = new Ejercicio10(numEstudiantes, numNotas);
        long fin = System.nanoTime();

        notas.imprimirEstudiantes();
        notas.contarEstados();

        long duracion = fin - inicio; // Tiempo en nanosegundos
        System.out.println("Tiempo de ejecución: " + duracion + " nanosegundos");

        scanner.close();
    }

    private static int solicitarEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    // Clase interna Estudiantes
    private class Estudiantes {
        private String nombre;
        private double[] notas;
        private double promedio;
        private String estado;

        public Estudiantes(String nombre, int numNotas) {
            this.nombre = nombre;
            this.notas = new double[numNotas];
        }

        public void calcularPromedio() {
            double suma = 0;
            for (double nota : notas) {
                suma += nota;
            }
            this.promedio = suma / notas.length;
        }

        public void determinarEstado() {
            if (promedio >= 7) {
                this.estado = "Aprobado";
            } else if (promedio < 5) {
                this.estado = "Reprobado";
            } else {
                this.estado = "Supletorio";
            }
        }

        public void setNota(int index, double nota) {
            this.notas[index] = nota;
        }

        public double getPromedio() {
            return promedio;
        }

        public String getEstado() {
            return estado;
        }

        public double[] getNotas() {
            return notas;
        }

        public String getNombre() {
            return nombre;
        }
    }
}
