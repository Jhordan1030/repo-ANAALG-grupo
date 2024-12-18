import random

# Función para llenar el arreglo con números aleatorios
def llenar_arreglo(tamano):
    """Llena un arreglo con números aleatorios de 1 a 999."""
    return [random.randint(1, 999) for _ in range(tamano)]

# Método secuencial para sumar los dígitos múltiplos de un número en cada elemento del arreglo
def suma_digitos_multiplo_secuencial(numero, arreglo):
    """Método secuencial para sumar los dígitos múltiplos de un número en cada elemento del arreglo."""
    resultado = []
    for elemento in arreglo:
        suma = sum(int(d) for d in str(elemento) if int(d) % numero == 0)
        resultado.append(suma)
    return resultado

# Programa principal
def main():
    tamano = int(input("Ingrese el tamaño del arreglo: "))
    arreglo_a = llenar_arreglo(tamano)
    print(f"Arreglo original: {arreglo_a}")
    # Secuencial
    numero = int(input("Ingrese el número para verificar múltiplos: "))
    
    arreglo_b_secuencial = suma_digitos_multiplo_secuencial(numero, arreglo_a)

    # Secuencial
    arreglo_b_secuencial = suma_digitos_multiplo_secuencial(numero, arreglo_a)
    print(f"Arreglo B (secuencial): {arreglo_b_secuencial}")

if __name__ == "__main__":
    main()
