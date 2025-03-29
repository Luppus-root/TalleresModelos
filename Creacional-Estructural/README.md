# Proyecto: CreacionalEstructuralApplication

## Descripción
Este proyecto implementa los patrones de diseño **Abstract Factory**, **Adapter** y **Controller** para proporcionar una interfaz flexible que permite a los usuarios interactuar con el programa mediante diferentes medios: **Consola, Frame (JOptionPane) o Web**.

El usuario puede seleccionar entre **tres tipos de comidas** y **dos tipos de bebidas**, y el programa mostrará el resultado según el medio de salida elegido.

## Patrones de Diseño Implementados

### **1. Abstract Factory**
Este patrón se utiliza para crear las fábricas que generarán los objetos de **Entrada** y **Salida** según el medio de interacción seleccionado por el usuario.

### **2. Adapter**
Este patrón permite adaptar la salida para cada medio de presentación, asegurando que la misma información pueda ser representada correctamente en la **Consola**, **JOptionPane** o **Web**. También incluye un adaptador para conversión entre tipos de datos.

### **3. Controller**
Patrón utilizado para manejar la lógica principal de la aplicación y coordinar entre los diferentes componentes.

## Estructura del Proyecto
```
CreacionalEstructuralApplication
│── src/
│ ├── Factory/    # Implementación de Abstract Factory
│ │ ├── EntradaFactory.java   # Fábrica de entradas
│ │ ├── SalidaFactory.java    # Fábrica de salidas
│ ├── Entrada/    # Implementación de las entradas según el medio
│ │ ├── EntradaConsola.java
│ │ ├── EntradaFrame.java
│ │ ├── EntradaWeb.java
│ ├── Salida/  # Implementación de las salidas según el medio
│ │ ├── SalidaConsola.java
│ │ ├── SalidaFrame.java
│ │ ├── SalidaWeb.java
│ ├── adapters/   # Implementación del patrón Adapter
│ │ ├── adapterStringInt.java    # Adaptador para conversión String-Int
│ │ ├── InterfaceStringInt.java  # Interfaz para el adaptador
│ ├── cliente/    # Cliente que usa los patrones
│ │ ├── Cliente.java
│ ├── controller/    # Controlador principal
│ │ ├── IndexController.java
│ ├── CreacionalEstructuralApplication.java  # Clase Main
```

## Instalación y Ejecución
1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/tu-usuario/CreacionalEstructuralApplication.git
   ```
2. **Compilar el proyecto** (si usas Java con Maven o Gradle, ajusta según tu entorno)
   ```bash
   javac -d bin src/**/*.java
   ```
3. **Ejecutar el programa**
   ```bash
   java -cp bin CreacionalEstructuralApplication
   ```

## Uso del Programa
1. El usuario selecciona el medio de interacción: **Consola, Frame (JOptionPane) o Web**.
2. Luego elige una comida de entre tres opciones.
3. Luego elige una bebida de entre dos opciones.
4. La salida se muestra según el medio elegido.

