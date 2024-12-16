import random

# Algoritmo secuencial
def suma_filas(matriz):
    filas = [0] * len(matriz)
    for i in range(len(matriz)):
        for j in range(len(matriz[i])):
            filas[i] += matriz[i][j]
    return filas


# Algoritmo recursivo
def suma_filas_recursivo(matriz, i=None):
    # Caso base: Si la matriz está vacía, retornar [0]
    if not matriz:
        return [0]
    if i is None:
        i = len(matriz) - 1
    if i < 0:
        return []
    suma_actual = sum(matriz[i])
    return suma_filas_recursivo(matriz, i - 1) + [suma_actual]



def llenado(matriz):
    for i in range(len(matriz)):
        for j in range(len(matriz[i])):
            matriz[i][j] = random.randint(1, 20)


def mostrar(matriz):
    m = ""
    for i in range(len(matriz)):
        for j in range(len(matriz[i])):
            m += str(matriz[i][j]) + "\t"
        m += "\n"
    return m


# Probar funcionamiento
matriz = [[0] * 6 for _ in range(5)]
llenado(matriz)
print(mostrar(matriz))
print("Aplicando el Algoritmo secuencial")
print(suma_filas(matriz))
print("Aplicando el Algoritmo recursivo")
print(suma_filas_recursivo(matriz))