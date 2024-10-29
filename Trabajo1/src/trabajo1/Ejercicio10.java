/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajo1;

/**
 *
 * @author demy7
 */
public class Ejercicio10 {
    
    private String nombre;
    private double[] notas;
    private double promedio;
    private String estado;

    public Ejercicio10(String nombre, int numNotas) {
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
