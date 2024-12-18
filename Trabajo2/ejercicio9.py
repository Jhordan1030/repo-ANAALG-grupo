import random
from collections import deque

class Nodo:
    def __init__(self, valor):
        self.valor = valor
        self.izquierda = None
        self.derecha = None

def generar_arbol(profundidad):
    if profundidad == 0:
        return None
    raiz = Nodo(random.randint(1, 100))
    nodos = deque([raiz])
    while nodos and profundidad > 1:
        nodo_actual = nodos.popleft()
        nodo_actual.izquierda = Nodo(random.randint(1, 100))
        nodo_actual.derecha = Nodo(random.randint(1, 100))
        nodos.append(nodo_actual.izquierda)
        nodos.append(nodo_actual.derecha)
        profundidad -= 1
    return raiz

def imprimir_arbol(raiz):
    if not raiz:
        return
    nodos = deque([raiz])
    while nodos:
        nivel = len(nodos)
        while nivel > 0:
            nodo_actual = nodos.popleft()
            print(nodo_actual.valor, end=' ')
            if nodo_actual.izquierda:
                nodos.append(nodo_actual.izquierda)
            if nodo_actual.derecha:
                nodos.append(nodo_actual.derecha)
            nivel -= 1
        print()

def suma_niveles_secuencial(raiz):
    if not raiz:
        return []
    suma_niveles = []
    nodos = deque([raiz])
    while nodos:
        nivel = len(nodos)
        suma = 0
        while nivel > 0:
            nodo_actual = nodos.popleft()
            suma += nodo_actual.valor
            if nodo_actual.izquierda:
                nodos.append(nodo_actual.izquierda)
            if nodo_actual.derecha:
                nodos.append(nodo_actual.derecha)
            nivel -= 1
        suma_niveles.append(suma)
    return suma_niveles

def suma_total_secuencial(raiz):
    return sum(suma_niveles_secuencial(raiz))

def determinar_profundidad(nodo):
    if not nodo:
        return 0
    return max(determinar_profundidad(nodo.izquierda), determinar_profundidad(nodo.derecha)) + 1

def suma_niveles_recursiva_decremental(raiz):
    if not raiz:
        return []

    # Primero se determina la profundidad del árbol
    profundidad = determinar_profundidad(raiz)
    suma_niveles = [0] * profundidad

    def helper(nodo, nivel):
        if not nodo:
            return
        # Sumar el valor del nodo al nivel correspondiente
        suma_niveles[nivel] += nodo.valor
        if nodo.izquierda:
            helper(nodo.izquierda, nivel - 1)
        if nodo.derecha:
            helper(nodo.derecha, nivel - 1)

    # Iniciar la recursión desde la raíz
    helper(raiz, profundidad - 1)
    return suma_niveles

def suma_total_recursiva_decremental(raiz):
    return sum(suma_niveles_recursiva_decremental(raiz))

def main():
    # Solicitar la profundidad del árbol
    profundidad = int(input("Ingrese la profundidad del árbol: "))
    
    # Generar el árbol automáticamente
    arbol = generar_arbol(profundidad)

    # Imprimir el árbol
    print("\nEl árbol generado es:")
    imprimir_arbol(arbol)

    # Calcular la suma de los valores por niveles y el total usando el algoritmo secuencial
    suma_niveles_seq = suma_niveles_secuencial(arbol)
    suma_total_seq = suma_total_secuencial(arbol)
    print("\nLa suma de los valores por niveles (secuencial) es:", suma_niveles_seq)
    print("La suma total de los valores (secuencial) es:", suma_total_seq)

    # Calcular la suma de los valores por niveles y el total usando el algoritmo recursivo decremental
    suma_niveles_rec_dec = suma_niveles_recursiva_decremental(arbol)
    suma_total_rec_dec = suma_total_recursiva_decremental(arbol)
    print("\nLa suma de los valores por niveles (recursivo decremental) es:", suma_niveles_rec_dec)
    print("La suma total de los valores (recursivo decremental) es:", suma_total_rec_dec)

if __name__ == "__main__":
    main()
