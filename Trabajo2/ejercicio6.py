import random

def generar_matriz(num_filas, num_columnas):
    matriz = []
    for fila in range(num_filas):
        fila_valores = [random.randint(1, 100) for _ in range(num_columnas)]
        matriz.append(fila_valores)
    return matriz

def imprimir_matriz(matriz):
    for fila in matriz:
        print(' '.join(f'{num:3}' for num in fila))

def transpuesta_secuencial(matriz, num_filas, num_columnas):
    transpuesta = [[0] * num_filas for _ in range(num_columnas)]
    for fila in range(num_filas):
        for columna in range(num_columnas):
            transpuesta[columna][fila] = matriz[fila][columna]
    return transpuesta

def transponer_recursivo_decremental(matriz, transpuesta, fila=None, columna=None):
    n = len(matriz)
    if fila is None:
        fila = n - 1
    if columna is None:
        columna = len(matriz[0]) - 1
    
    if fila < 0:
        return
    if columna >= 0:
        transpuesta[columna][fila] = matriz[fila][columna]
        transponer_recursivo_decremental(matriz, transpuesta, fila, columna - 1)
    else:
        transponer_recursivo_decremental(matriz, transpuesta, fila - 1, n - 1)

def transpuesta_recursiva(matriz, num_filas, num_columnas):
    transpuesta = [[0] * num_filas for _ in range(num_columnas)]
    transponer_recursivo_decremental(matriz, transpuesta)
    return transpuesta

def main():
    # Solicitar el tamaño de la matriz
    num_filas = int(input("Ingrese el número de filas de la matriz (n): "))
    num_columnas = int(input("Ingrese el número de columnas de la matriz (m): "))

    # Generar los valores de la matriz automáticamente
    matriz = generar_matriz(num_filas, num_columnas)

    # Imprimir la matriz original
    print("\nLa matriz generada es:")
    imprimir_matriz(matriz)

    # Calcular e imprimir la matriz transpuesta usando el algoritmo secuencial
    transpuesta_seq = transpuesta_secuencial(matriz, num_filas, num_columnas)
    print("\nLa matriz transpuesta (secuencial) es:")
    imprimir_matriz(transpuesta_seq)

    # Calcular e imprimir la matriz transpuesta usando el algoritmo recursivo
    transpuesta_rec = transpuesta_recursiva(matriz, num_filas, num_columnas)
    print("\nLa matriz transpuesta (recursiva) es:")
    imprimir_matriz(transpuesta_rec)

if __name__ == "__main__":
    main()
