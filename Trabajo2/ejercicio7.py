import random
from collections import defaultdict

def generar_matriz(num_filas, num_columnas, valor_maximo):
    matriz = []
    for fila in range(num_filas):
        fila_valores = [random.randint(1, valor_maximo) for _ in range(num_columnas)]
        matriz.append(fila_valores)
    return matriz

def imprimir_matriz(matriz):
    for fila in matriz:
        print(' '.join(f'{num:3}' for num in fila))

def contar_ocurrencias_secuencial(matriz):
    conteo_ocurrencias = defaultdict(int)
    for fila in matriz:
        for valor in fila:
            conteo_ocurrencias[valor] += 1
    return conteo_ocurrencias

def contar_ocurrencias_recursivo_decremental(matriz, conteo_ocurrencias=None, indice_fila=None, indice_columna=None):
    n = len(matriz)
    if conteo_ocurrencias is None:
        conteo_ocurrencias = defaultdict(int)
    if indice_fila is None:
        indice_fila = n - 1
    if indice_columna is None:
        indice_columna = len(matriz[indice_fila]) - 1
    
    if indice_fila < 0:
        return conteo_ocurrencias
    if indice_columna >= 0:
        conteo_ocurrencias[matriz[indice_fila][indice_columna]] += 1
        return contar_ocurrencias_recursivo_decremental(matriz, conteo_ocurrencias, indice_fila, indice_columna - 1)
    else:
        return contar_ocurrencias_recursivo_decremental(matriz, conteo_ocurrencias, indice_fila - 1, len(matriz[indice_fila]) - 1)

def imprimir_conteo(conteo_ocurrencias):
    for valor, cantidad in conteo_ocurrencias.items():
        print(f"{valor} -> {cantidad}")

def main():
    # Solicitar el tamaño de la matriz
    num_filas = int(input("Ingrese el número de filas de la matriz: "))
    num_columnas = int(input("Ingrese el número de columnas de la matriz: "))

    # Solicitar el valor máximo para el rango de valores de la matriz
    valor_maximo = int(input("Ingrese el valor máximo para los elementos de la matriz: "))

    # Generar los valores de la matriz automáticamente dentro del rango especificado
    matriz = generar_matriz(num_filas, num_columnas, valor_maximo)

    # Imprimir la matriz
    print("\nLa matriz generada es:")
    imprimir_matriz(matriz)

    # Contar las ocurrencias usando el algoritmo secuencial
    conteo_secuencial = contar_ocurrencias_secuencial(matriz)
    print("\nConteo de ocurrencias (secuencial):")
    imprimir_conteo(conteo_secuencial)

    # Contar las ocurrencias usando el algoritmo recursivo decremental
    conteo_recursivo = contar_ocurrencias_recursivo_decremental(matriz)
    print("\nConteo de ocurrencias (recursivo):")
    imprimir_conteo(conteo_recursivo)

if __name__ == "__main__":
    main()
