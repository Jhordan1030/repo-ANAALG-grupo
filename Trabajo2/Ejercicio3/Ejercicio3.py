import random

# Algoritmo secuencial
def valor_mayor(matriz):
    numero = matriz[0][0]
    for i in range(len(matriz)):
        for j in range(len(matriz[0])):
            if matriz[i][j] > numero:
                numero = matriz[i][j]
    return numero


# Algoritmo recursivo
def valor_mayor_recursivo(matriz, i=0, mayor_actual=None):
    if i == len(matriz):
        return mayor_actual

    if mayor_actual is None:
        mayor_actual = matriz[0][0]

    for valor in matriz[i]:
        if valor > mayor_actual:
            mayor_actual = valor
            
    return valor_mayor_recursivo(matriz, i + 1, mayor_actual)


def llenado(matriz):
    for i in range(len(matriz)):
        for j in range(len(matriz[i])):
            matriz[i][j] = random.randint(1, 200)


def mostrar(matriz):
    m = ""
    for i in range(len(matriz)):
        for j in range(len(matriz[i])):
            m += str(matriz[i][j]) + "\t"
        m += "\n"
    return m


# Probar funcionamiento
matriz = [[0] * 4 for _ in range(3)]
llenado(matriz)
print(mostrar(matriz))
print("Aplicando el Algoritmo secuencial")
print(valor_mayor(matriz))
print("Aplicando el Algoritmo recursivo")
print(valor_mayor_recursivo(matriz))