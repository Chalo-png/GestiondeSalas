
# Sistema de Gestión de Reservas de Salas

## Descripción del diseño del programa

El programa está diseñado en Java y utiliza una arquitectura modular para gestionar salas, usuarios y reservas dentro de una organización. Se compone de las siguientes clases principales:

- **App:** Punto de entrada del programa que maneja la interacción con el usuario a través de una interfaz de línea de comandos.
- **SistemaGestion:** Clase central que gestiona las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para salas, usuarios y reservas.
- **Sala:** Representa una sala de reuniones con atributos como código, nombre, ubicación y estado de reserva.
- **Usuario:** Representa un usuario con atributos como identificador, nombre, departamento y descripción.
- **Reserva:** Vincula una sala y un usuario en una fecha específica, incluyendo detalles adicionales de la reserva.

Además, se implementan pruebas unitarias utilizando JUnit para asegurar la calidad y funcionalidad del código, cubriendo todos los casos de uso y restricciones establecidas, como la limitación de una reserva por usuario en una misma fecha.

## Manual de usuario

### Requisitos Previos

- **Java:** Asegúrate de tener Java instalado en tu sistema.
- **Gradle:** Se utiliza Gradle para la gestión de dependencias y compilación. Puedes instalar Gradle utilizando Chocolatey (choco).

### Instalación de Gradle con Chocolatey

1. **Instalar Chocolatey:** Si no tienes Chocolatey instalado, abre una terminal con permisos de administrador y ejecuta:

    ```powershell
    Set-ExecutionPolicy Bypass -Scope Process -Force; `
    [System.Net.ServicePointManager]::SecurityProtocol = `
    [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; `
    iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))
    ```

2. **Instalar Gradle:** Una vez instalado Chocolatey, ejecuta el siguiente comando en la terminal:

    ```bash
    choco install gradle
    ```

    Verifica la instalación con:

    ```bash
    gradle -v
    ```

### Clonar el Repositorio

Clona el repositorio desde GitHub:

```bash
git clone https://github.com/tu-usuario/GestiondeSalas.git
```

## Compilar y Ejecutar el Programa

### Navegar al Directorio del Proyecto:

```bash
cd GestiondeSalas
```

### Compilar el Programa:

Utiliza Gradle para compilar el proyecto:

```bash
gradle build
```

### Ejecutar el Programa:

Después de compilar, ejecuta el programa con:

```bash
gradle run
```

## Uso del Programa

### Menú Principal:

- Al iniciar el programa, se mostrará el menú principal con opciones para gestionar usuarios, salas y reservas.
- Selecciona la opción deseada ingresando el número correspondiente y presiona Enter.

### Gestión de Usuarios:

- **Agregar Usuario:** Ingresa los datos solicitados (identificador, nombre, departamento y descripción).
- **Listar Usuarios:** Muestra todos los usuarios registrados.
- **Actualizar Usuario:** Proporciona el identificador del usuario a actualizar y los nuevos datos.
- **Eliminar Usuario:** Ingresa el identificador del usuario que deseas eliminar.

### Gestión de Salas:

- **Agregar Sala:** Introduce el código, nombre y ubicación de la sala.
- **Listar Salas:** Muestra todas las salas disponibles con su estado de reserva.
- **Actualizar Sala:** Proporciona el código de la sala a actualizar y los nuevos datos.
- **Eliminar Sala:** Ingresa el código de la sala que deseas eliminar.

### Gestión de Reservas:

- **Agregar Reserva:** Introduce el código de la sala, identificador del usuario, fecha (formato YYYY-MM-DD) y detalle de la reserva.
- **Listar Reservas:** Muestra todas las reservas existentes.
- **Actualizar Reserva:** Proporciona los detalles de la reserva a actualizar y los nuevos datos.
- **Eliminar Reserva:** Ingresa los detalles de la reserva que deseas eliminar.

### Salir:

- Selecciona la opción de salir para finalizar el programa.

## Reporte de resultados de las pruebas unitarias

Se han implementado pruebas unitarias utilizando JUnit para garantizar la correcta funcionalidad de las operaciones CRUD y las restricciones de reservas. A continuación se detalla el estado de las pruebas:

### Pruebas de Usuarios:

- Creación, actualización, lectura y eliminación de usuarios.
- Validación de que no se pueden crear usuarios duplicados.

### Pruebas de Salas:

- Creación, actualización, lectura y eliminación de salas.
- Verificación del estado de reserva de las salas.

### Pruebas de Reservas:

- Creación, actualización, lectura y eliminación de reservas.
- Aseguramiento de que una sala no pueda ser reservada por múltiples usuarios en la misma fecha.
- Validación de que un usuario no pueda tener más de una reserva en la misma fecha.

### Resultados:

Todas las pruebas unitarias han pasado exitosamente, lo que confirma que las funcionalidades del programa cumplen con los requisitos establecidos y que las restricciones de reserva se aplican correctamente. Esto asegura la fiabilidad y estabilidad del sistema de gestión de reservas de salas.
