import random

def es_simetrica_secuencial(matriz):
    n = len(matriz)
    for fila in range(n):
        for columna in range(n):
            if matriz[fila][columna] != matriz[columna][fila]:
                return False
    return True

def es_simetrica_recursiva_decremental(matriz, fila=None, columna=None):
    n = len(matriz)
    if fila is None:
        fila = n - 1
    if columna is None:
        columna = n - 1
    
    if fila < 0:
        return True
    if matriz[fila][columna] != matriz[columna][fila]:
        return False
    if columna > 0:
        return es_simetrica_recursiva_decremental(matriz, fila, columna - 1)
    else:
        return es_simetrica_recursiva_decremental(matriz, fila - 1, n - 1)


def generar_matriz(n, max_valor):
    return [[random.randint(1, max_valor) for _ in range(n)] for _ in range(n)]

def imprimir_matriz(matriz):
    for fila in matriz:
        print(' '.join(f'{num:3}' for num in fila))

def transponer_matriz(matriz):
    n = len(matriz)
    transpuesta = [[matriz[j][i] for j in range(n)] for i in range(n)]
    return transpuesta

def main():
    # Solicitar el tamaño de la matriz
    n = int(input("Ingrese el tamaño de la matriz (n x n): "))
    max_valor = int(input("Ingrese el valor máximo para los números de la matriz: "))

    # Generar la matriz automáticamente
    matriz = generar_matriz(n, max_valor)

    # Imprimir la matriz original
    print("\nLa matriz generada es:")
    imprimir_matriz(matriz)

    # Generar y imprimir la matriz transpuesta
    matriz_transpuesta = transponer_matriz(matriz)
    print("\nLa matriz transpuesta es:")
    imprimir_matriz(matriz_transpuesta)

    # Verificar si la matriz original es simétrica usando el algoritmo secuencial
    if es_simetrica_secuencial(matriz):
        print("\nLa matriz es simétrica (verificación secuencial).")
    else:
        print("\nLa matriz no es simétrica (verificación secuencial).")

    # Verificar si la matriz original es simétrica usando el algoritmo recursivo
    if es_simetrica_recursiva_decremental(matriz):
        print("\nLa matriz es simétrica (verificación recursiva).")
    else:
        print("\nLa matriz no es simétrica (verificación recursiva).\n")

if __name__ == "__main__":
    main()
