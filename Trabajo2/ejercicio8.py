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

def ordenar_columna_secuencial(matriz, indice_columna):
    num_filas = len(matriz)
    # Extraer la columna y ordenarla
    columna = [matriz[fila][indice_columna] for fila in range(num_filas)]
    columna.sort()
    # Reemplazar la columna ordenada en la matriz original
    for fila in range(num_filas):
        matriz[fila][indice_columna] = columna[fila]
    return matriz

def seleccionar_maximo(columna, n):
        if n == 1:
            return 0
        max_idx = seleccionar_maximo(columna, n - 1)
        return n - 1 if columna[n - 1] > columna[max_idx] else max_idx

def ordenar_recursivo(columna, n):
        if n <= 1:
            return columna
        max_idx = seleccionar_maximo(columna, n)
        columna[n - 1], columna[max_idx] = columna[max_idx], columna[n - 1]
        return ordenar_recursivo(columna, n - 1)

def ordenar_columna_recursivo_decremental(matriz, indice_columna):
    n = len(matriz)
    # Extraer la columna
    columna = [matriz[fila][indice_columna] for fila in range(n)]
    # Ordenar la columna de manera recursiva
    columna = ordenar_recursivo(columna, n)
    # Reemplazar la columna ordenada en la matriz original
    for fila in range(n - 1, -1, -1):
        matriz[fila][indice_columna] = columna[fila]
    return matriz


def main():
    # Solicitar el tamaño de la matriz
    num_filas = int(input("Ingrese el número de filas de la matriz: "))
    num_columnas = int(input("Ingrese el número de columnas de la matriz: "))

    # Generar los valores de la matriz automáticamente dentro del rango especificado
    matriz = generar_matriz(num_filas, num_columnas)

    # Imprimir la matriz
    print("\nLa matriz generada es:")
    imprimir_matriz(matriz)

    # Solicitar la columna a ordenar
    indice_columna = int(input(f"\nIngrese el número de la columna que desea ordenar (secuencial) (0 a {num_columnas - 1}): "))
    while indice_columna < 0 or indice_columna >= num_columnas:
        indice_columna = int(input(f"Valor inválido. Ingrese el número de la columna que desea ordenar (0 a {num_columnas - 1}): "))

    # Ordenar la columna usando el algoritmo secuencial
    matriz_ordenada_secuencial = ordenar_columna_secuencial([fila[:] for fila in matriz], indice_columna)
    print("\nLa matriz con la columna ordenada (secuencial) es:")
    imprimir_matriz(matriz_ordenada_secuencial)

    # Solicitar la columna a ordenar
    indice_columna = int(input(f"\nIngrese el número de la columna que desea ordenar (recursivo) (0 a {num_columnas - 1}): "))
    while indice_columna < 0 or indice_columna >= num_columnas:
        indice_columna = int(input(f"Valor inválido. Ingrese el número de la columna que desea ordenar (0 a {num_columnas - 1}): "))

    # Ordenar la columna usando el algoritmo recursivo decremental
    matriz_ordenada_recursivo = ordenar_columna_recursivo_decremental([fila[:] for fila in matriz], indice_columna)
    print("\nLa matriz con la columna ordenada (recursivo) es:")
    imprimir_matriz(matriz_ordenada_recursivo)

if __name__ == "__main__":
    main()
