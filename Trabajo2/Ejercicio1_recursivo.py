import random

# Función para llenar el arreglo con números aleatorios
def llenar_arreglo(tamano):
    return [random.randint(1, 999) for _ in range(tamano)]

# Método recursivo para sumar los dígitos múltiplos de un número en un elemento
def suma_digitos_multiplo_recursivo(numero, elemento, suma=0):
    if elemento == 0:
        return suma
    digito = elemento % 10
    if digito % numero == 0:
        suma += digito
    return suma_digitos_multiplo_recursivo(numero, elemento // 10, suma)

# Función recursiva para aplicar la suma de dígitos múltiplos a todo el arreglo
def suma_digitos_multiplo_arreglo_recursivo(numero, arreglo):
    if not arreglo:
        return []
    return [suma_digitos_multiplo_recursivo(numero, arreglo[0])] + suma_digitos_multiplo_arreglo_recursivo(numero, arreglo[1:])

# Programa principal
def main():
    tamano = int(input("Ingrese el tamaño del arreglo: "))
    arreglo_a = llenar_arreglo(tamano)
    print(f"Arreglo original: {arreglo_a}")
    numero = int(input("Ingrese el número para verificar múltiplos: "))
    # Recursivo
    arreglo_b_recursivo = suma_digitos_multiplo_arreglo_recursivo(numero, arreglo_a)
    print(f"Arreglo B (recursivo): {arreglo_b_recursivo}")

if __name__ == "__main__":
    main()
