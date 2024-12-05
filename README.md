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
git clone https://github.com/tu_usuario/gestion-salas.git](https://github.com/Chalo-png/GestiondeSalas.git
