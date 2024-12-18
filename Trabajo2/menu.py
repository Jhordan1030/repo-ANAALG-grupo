import os

def menu():
    print("\nBienvenido al menú principal")
    print("Selecciona una opción para ejecutar un script:")
    
    scripts = [f for f in os.listdir() if f.endswith('.py') and f != __file__]
    for i, script in enumerate(scripts, start=1):
        print(f"{i}. {script}")

    print("0. Salir")

def ejecutar_script(seleccion):
    scripts = [f for f in os.listdir() if f.endswith('.py') and f != __file__]
    if 1 <= seleccion <= len(scripts):
        script = scripts[seleccion - 1]
        print(f"\nEjecutando {script}...\n")
        os.system(f"python {script}")
    else:
        print("Selección no válida")

def main():
    while True:
        menu()
        try:
            seleccion = int(input("Ingresa el número de la opción que deseas ejecutar: "))
            if seleccion == 0:
                print("Saliendo del menú. ¡Hasta luego!")
                break
            ejecutar_script(seleccion)
        except ValueError:
            print("Por favor, ingresa un número válido.")

if __name__ == "__main__":
    main()
