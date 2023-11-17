# InditexBack

Este proyecto utiliza Java junto con RestAssured, Jackson y  Karate para interactuar con la API de una tienda de mascotas y realizar varias operaciones.

## Requisitos

- Java 8 o superior
- Maven
- RestAssured
- Jackson
- Karate

## Estructura del Proyecto

- `src/main/java`: Contiene el código fuente del proyecto.
- `src/resources`: Contiene gherkins con llamadas implementadas con karate.
- `pom.xml`: Archivo de configuración de Maven.

## Funcionalidades Implementadas

### Creación de Usuario y Recuperación de Datos

- **Crear Usuario:**
  Utiliza RestAssured para crear un usuario en la tienda de mascotas.

- **Recuperar Datos del Usuario Creado:**
  Recupera los datos del usuario creado mediante una petición HTTP GET.

### Obtención de Mascotas Vendidas y Conteo por Nombre

- **Recoger Mascotas Vendidas:**
  Realiza una petición HTTP GET al endpoint `/pet/findByStatus` para obtener las mascotas vendidas en formato JSON.

- **Contar Mascotas por Nombre:**
  Implementa un método que cuenta cuántas mascotas tienen el mismo nombre a partir de la lista obtenida.

## Ejecución del Proyecto

1. Clona este repositorio: `git clone <https://github.com/ChemitaContigo/inditexBack.git>`
2. Abre el proyecto en tu IDE.
3. Asegúrate de tener todas las dependencias y bibliotecas configuradas en tu entorno de desarrollo.
4. Ejecuta las pruebas para probar las funcionalidades implementadas.


