#RECURSIVO
# Define un nodo del árbol binario
class Node:
    def __init__(self, value):
        self.value = value  # Almacena el valor
        self.left = None  # Referencia al hijo izquierdo
        self.right = None  # Referencia al hijo derecho

def ImpresionArbol(raiz, nivel=0):
    if raiz is not None:
        ImpresionArbol(raiz.right, nivel - 1)  # Recorre el subárbol derecho
        print(' ' * 4 * abs(nivel) + '->', raiz.value)  # Imprime el nodo actual
        ImpresionArbol(raiz.left, nivel - 1)  # Recorre el subárbol izquierdo


# Calcula la suma de los valores de todos los nodos (recursivo)
def SumaArbol(raiz):
    if raiz is None:
        return 0
    # Suma el valor del nodo actual más la suma de los subárboles izquierdo y derecho
    return raiz.value +     SumaArbol(raiz.left) + SumaArbol(raiz.right)


def CrearArbol(n, values, index=0):
    if index >= n:  # Condición base: si el índice está fuera de rango
        return None

    # Crear el nodo actual
    value = values[index]
    root = Node(value)

    # Índices de los hijos izquierdo y derecho
    left_index = 2 * index + 1
    right_index = 2 * index + 2

    # Crear recursivamente los hijos
    root.left = CrearArbol(n, values, left_index)
    root.right = CrearArbol(n, values, right_index)

    return root


# Bloque principal
if __name__ == "__main__":
    # Crear el árbol binario a partir de la entrada del usuario
    n = int(input("Ingrese la cantidad de nodos en el árbol: "))
    if n <= 0:
        print("El árbol no puede tener menos de un nodo.")
    else:
        values = []
        print("Ingrese los valores de los nodos en el orden de inserción:")
        for i in range(n):
            values.append(int(input(f"Nodo {i + 1}: ")))

        # Crear el árbol binario
       # root = CrearArbol(n, values)
        root = CrearArbol(n, values, index=0)


        # Imprimir el árbol
        if root:
            print("\nEl árbol binario es:")
            ImpresionArbol(root)

            # Calcular la suma de los nodos
            total_sum = SumaArbol(root)
            print("\nLa suma de los valores de todos los nodos es:", total_sum)