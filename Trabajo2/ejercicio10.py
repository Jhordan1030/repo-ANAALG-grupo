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
        if random.choice([True, False]):
            nodo_actual.izquierda = Nodo(random.randint(1, 100))
            nodos.append(nodo_actual.izquierda)
        if random.choice([True, False]):
            nodo_actual.derecha = Nodo(random.randint(1, 100))
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

def eliminar_recursivo_decremental(raiz, valor):
    if not raiz:
        return raiz
    
    if valor > raiz.valor:
        raiz.derecha = eliminar_recursivo_decremental(raiz.derecha, valor)
    elif valor < raiz.valor:
        raiz.izquierda = eliminar_recursivo_decremental(raiz.izquierda, valor)
    else:
        if not raiz.izquierda:
            return raiz.derecha
        elif not raiz.derecha:
            return raiz.izquierda
        temp_valor = encontrar_maximo(raiz.izquierda)
        raiz.valor = temp_valor
        raiz.izquierda = eliminar_recursivo_decremental(raiz.izquierda, temp_valor)
    return raiz

def eliminar_secuencial(raiz, valor):
    if not raiz:
        return raiz
    padre = None
    nodo_actual = raiz
    while nodo_actual and nodo_actual.valor != valor:
        padre = nodo_actual
        if valor < nodo_actual.valor:
            nodo_actual = nodo_actual.izquierda
        else:
            nodo_actual = nodo_actual.derecha
    if not nodo_actual:
        return raiz
    if not nodo_actual.izquierda:
        if not padre:
            return nodo_actual.derecha
        elif nodo_actual == padre.izquierda:
            padre.izquierda = nodo_actual.derecha
        else:
            padre.derecha = nodo_actual.derecha
    elif not nodo_actual.derecha:
        if not padre:
            return nodo_actual.izquierda
        elif nodo_actual == padre.izquierda:
            padre.izquierda = nodo_actual.izquierda
        else:
            padre.derecha = nodo_actual.izquierda
    else:
        sucesor_padre = nodo_actual
        sucesor = nodo_actual.derecha
        while sucesor.izquierda:
            sucesor_padre = sucesor
            sucesor = sucesor.izquierda
        if sucesor_padre != nodo_actual:
            sucesor_padre.izquierda = sucesor.derecha
            sucesor.derecha = nodo_actual.derecha
        sucesor.izquierda = nodo_actual.izquierda
        if not padre:
            raiz = sucesor
        elif nodo_actual == padre.izquierda:
            padre.izquierda = sucesor
        else:
            padre.derecha = sucesor
    return raiz

def encontrar_maximo(nodo):
    actual = nodo
    while actual.derecha:
        actual = actual.derecha
    return actual.valor

def main():
    # Solicitar la profundidad del árbol
    profundidad = int(input("Ingrese la profundidad del árbol: "))
    
    # Generar el árbol automáticamente
    arbol = generar_arbol(profundidad)

    # Imprimir el árbol original
    print("\nEl árbol generado es:")
    imprimir_arbol(arbol)

    # Solicitar el valor del nodo a eliminar
    valor = int(input("\nIngrese el valor del nodo que desea eliminar: "))

    # Eliminar el nodo usando el método secuencial
    print("\nUsando el método secuencial para eliminar el nodo...")
    arbol_secuencial = eliminar_secuencial(arbol, valor)
    print("\nEl árbol después de eliminar el nodo (secuencial) es:")
    imprimir_arbol(arbol_secuencial)

    # Eliminar el nodo usando el método recursivo decremental
    print("\nUsando el método recursivo para eliminar el nodo...")
    arbol_recursivo = eliminar_recursivo_decremental(arbol, valor)
    print("\nEl árbol después de eliminar el nodo (recursivo) es:")
    imprimir_arbol(arbol_recursivo)

if __name__ == "__main__":
    main()
