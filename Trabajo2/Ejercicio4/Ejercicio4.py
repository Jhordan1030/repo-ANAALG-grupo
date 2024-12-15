import random

# Algoritmo secuencial
def suma_filas(matriz):
    filas = [0] * len(matriz)
    for i in range(len(matriz)):
        for j in range(len(matriz[i])):
            filas[i] += matriz[i][j]
    return filas


# Algoritmo recursivo
def suma_filas_recursivo(matriz, i=0):
    if i == len(matriz):
        return []

    suma_actual = 0
    for valor in matriz[i]:
        suma_actual += valor

    return [suma_actual] + suma_filas_recursivo(matriz, i + 1)


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