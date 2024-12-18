#RECURSIVO
class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


class BinaryTree:
    def __init__(self):
        self.root = None

    # Método recursivo para insertar un nodo
    def insert(self, value):
        if self.root is None:
            self.root = Node(value)
        else:
            self._insert_rec(self.root, value)

    def _insert_rec(self, current, value):
        if value < current.value:
            if current.left is None:
                current.left = Node(value)
            else:
                self._insert_rec(current.left, value)
        else:
            if current.right is None:
                current.right = Node(value)
            else:
                self._insert_rec(current.right, value)

    # Método recursivo para imprimir el árbol en orden
    def inorder(self):
        self._inorder_rec(self.root)
        print()

    def _inorder_rec(self, current):
        if current is not None:
            self._inorder_rec(current.left)
            print(current.value, end=" ")
            self._inorder_rec(current.right)

    # Método recursivo para eliminar un nodo
    def delete(self, value):
        self.root = self._delete_rec(self.root, value)

    def _delete_rec(self, current, value):
        if current is None:
            return current

        # Buscar el nodo a eliminar
        if value < current.value:
            current.left = self._delete_rec(current.left, value)
        elif value > current.value:
            current.right = self._delete_rec(current.right, value)
        else:
            # Nodo con un hijo o sin hijos
            if current.left is None:
                return current.right
            elif current.right is None:
                return current.left

            # Nodo con dos hijos: obtener el sucesor inorder
            current.value = self._min_value_node(current.right).value
            current.right = self._delete_rec(current.right, current.value)

        return current

    def _min_value_node(self, node):
        if node.left is None:
            return node
        return self._min_value_node(node.left)


# Ejemplo de uso
if __name__ == "__main__":
    tree = BinaryTree()

    # Solicitar al usuario la cantidad de nodos
    try:
        cantidad_nodos = int(input("Ingrese la cantidad de nodos que tendrá el árbol: "))
        print(f"Se generarán {cantidad_nodos} nodos.\n")

        # Insertar nodos al árbol con valores automáticos o aleatorios
        for i in range(cantidad_nodos):
            valor = i + 1  # Valores consecutivos (puedes cambiar a valores aleatorios si prefieres)
            tree.insert(valor)
            print(f"Nodo {i + 1} agregado con valor: {valor}")

        # Mostrar el árbol en orden
        print("\nÁrbol en orden:")
        tree.inorder()

        # Solicitar al usuario el valor a eliminar
        valor_eliminar = int(input("\nIngrese el valor que desea eliminar del árbol: "))
        tree.delete(valor_eliminar)

        # Mostrar el árbol después de la eliminación
        print(f"\nÁrbol después de eliminar el valor {valor_eliminar}:")
        tree.inorder()

    except ValueError:
        print("Por favor, ingresa un número válido.")