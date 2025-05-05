
# 🧭 Navegador UDLAP

Este sistema permite calcular la **ruta más corta entre dos ubicaciones dentro del campus de la Universidad de las Américas Puebla (UDLAP)**, utilizando grafos ponderados y el algoritmo de Dijkstra.

## 📌 Objetivo

Facilitar la navegación entre puntos estratégicos del campus, optimizando el tiempo de traslado entre ellos.

## 🚀 Tecnologías utilizadas

- Java 8+
- Estructuras de datos: HashMap, PriorityQueue
- Algoritmo: Dijkstra (para rutas mínimas)

## 🗺️ Nodos disponibles

Cada letra representa una ubicación del campus:

| Letra | Ubicación            |
|-------|-----------------------|
| A     | Humanidades           |
| B     | Ágora                 |
| C     | Hacienda              |
| D     | Negocios              |
| E     | Auditorio             |
| F     | Ingeniería            |
| G     | Biblioteca            |
| H     | Cafetería             |
| I     | Servicios médicos     |
| J     | Salud                 |
| K     | Alberca               |
| L     | Gimnasio              |
| M     | Sorteo                |
| N     | Atletismo             |
| O     | Templo del dolor      |

## 🛠️ Compilación y ejecución

### 1. Compilar el proyecto

```bash
javac src/*.java
```

### 2. Ejecutar el programa

```bash
java -cp src Main
```

## 🧪 Ejemplo de uso

```
--- Navegador UDLAP ---
Lugar de origen (A-O): A
Lugar de destino (A-O): E
Ruta óptima: A → C → D → E
Tiempo estimado: 15 minutos
```

## 📂 Estructura del repositorio

```
udlap-navigator/
├── src/
│   ├── Graph.java
│   ├── Dijkstra.java
│   └── Main.java
├── README.md
```
