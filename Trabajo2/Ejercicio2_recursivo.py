import random

# Función para llenar el arreglo con números aleatorios
def llenar_arreglo(tamano):
    return [random.randint(1, 999) for _ in range(tamano)]

# Función recursiva para sumar los dígitos de un número
def suma_digitos(numero):
    if numero == 0:
        return 0
    else:
        return numero % 10 + suma_digitos(numero // 10)

# Función recursiva para procesar el arreglo A de manera decremental
def sumar_digitos_recursivo(arreglo, index=None):
    if index is None:
        index = len(arreglo) - 1  # Inicializar el índice como el último elemento

    if index < 0:
        return []
    else:
        return sumar_digitos_recursivo(arreglo, index - 1) + [suma_digitos(arreglo[index])]


# Programa principal
def main():
    tamano = int(input("Ingrese el tamaño del arreglo: "))  
    arreglo_a = llenar_arreglo(tamano)  
    print(f"Arreglo original A: {arreglo_a}")

  
    arreglo_b_recursivo = sumar_digitos_recursivo(arreglo_a)
    print(f"Arreglo B (suma de dígitos, recursivo): {arreglo_b_recursivo}")

if _name_ == "_main_":
    main()