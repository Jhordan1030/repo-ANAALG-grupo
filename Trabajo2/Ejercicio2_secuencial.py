import random

# Función para llenar el arreglo con números aleatorios
def llenar_arreglo(tamano):
    """Llena un arreglo con números aleatorios entre 1 y 999."""
    return [random.randint(1, 999) for _ in range(tamano)]

# Función secuencial para sumar los dígitos de cada elemento del arreglo A
def sumar_digitos_secuencial(arreglo):
    """Suma los dígitos de cada número en el arreglo de manera secuencial."""
    resultado = []
    for numero in arreglo:
        suma = sum(int(digit) for digit in str(numero))  # Sumar los dígitos de cada número
        resultado.append(suma)
    return resultado

# Programa principal
def main():
    tamano = int(input("Ingrese el tamaño del arreglo: "))  # Solicitar el tamaño del arreglo
    arreglo_a = llenar_arreglo(tamano)  # Llenar el arreglo A con números aleatorios
    print(f"Arreglo original A: {arreglo_a}")

    # Sumar los dígitos de cada elemento de A de manera secuencial
    arreglo_b_secuencial = sumar_digitos_secuencial(arreglo_a)
    print(f"Arreglo B (suma de dígitos, secuencial): {arreglo_b_secuencial}")

if __name__ == "__main__":
    main()
