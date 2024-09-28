
# Aplicación Cliente-Servidor en Java
Este es un ejemplo básico de una aplicación Cliente-Servidor en Java que demuestra la comunicación entre un cliente y un servidor utilizando sockets.

## Descripción
La aplicación está compuesta por dos programas principales:

#### Servidor:
Espera conexiones entrantes de clientes y procesa sus solicitudes.

#### Cliente: 
Se conecta al servidor y permite al usuario enviar mensajes o comandos.
Este proyecto es ideal para entender los fundamentos de la arquitectura cliente-servidor y la comunicación en red utilizando Java.

## Características
-Comunicación bidireccional entre cliente y servidor.
-Uso de sockets TCP para establecer conexiones de red.
-Ejemplo simple que puede ser ampliado para aplicaciones más complejas.

## Requisitos
-Java Development Kit (JDK) 8 o superior.
-Un entorno de desarrollo Java (opcional pero recomendado), como IntelliJ IDEA, Eclipse o NetBeans.
-Sistema operativo que soporte Java (Windows, macOS, Linux).

## Instrucciones para ejecutar

### 1. Clonar el repositorio
Primero, clona el repositorio en tu máquina local.

### 2. Compilar los archivos Java
Compila el código fuente tanto del servidor como del cliente:

### 3. Ejecutar el Servidor
Inicia el servidor para que pueda aceptar conexiones de clientes:

ServidorAgenda.java

Deberías ver un mensaje en la consola indicando que el servidor está escuchando en el puerto especificado.

### 4. Ejecutar el Cliente
En otra terminal o ventana de comandos, ejecuta el cliente:

ClienteAgenda.java

El cliente intentará conectarse al servidor y te permitirá enviar mensajes o comandos.

## Uso de la Aplicación
-Enviar Mensajes: El cliente te solicitará que ingreses mensajes que serán enviados al servidor.
-Procesamiento en el Servidor: El servidor recibirá los mensajes y podrá procesarlos o responder según la lógica implementada.
-Finalizar Comunicación: Para cerrar la conexión, puedes enviar el mensaje "salir" desde el cliente.

## Personalización
Esta aplicación básica puede ser personalizada o ampliada de varias maneras:

-Agregar Funcionalidades: Implementa nuevas características en el servidor, como procesamiento de datos, cálculos, almacenamiento en base de datos, etc.
-Manejo de Múltiples Clientes: Modifica el servidor para manejar conexiones de múltiples clientes simultáneamente utilizando hilos (threads).
-Interfaz Gráfica: Añade una interfaz gráfica al cliente o al servidor para mejorar la experiencia del usuario.
-Seguridad: Implementa medidas de seguridad como autenticación y cifrado de datos.

## Código de Ejemplo

```Java
import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(5000);
            System.out.println("Servidor escuchando en el puerto 5000...");
            Socket socketCliente = servidor.accept();
            System.out.println("Cliente conectado!");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true);
            String mensajeCliente;
            while ((mensajeCliente = reader.readLine()) != null) {
                System.out.println("Cliente dice: " + mensajeCliente);
                salida.println("Respuesta del servidor: " + mensajeCliente);
                if (mensajeCliente.equalsIgnoreCase("salir")) {
                    break;
                }
            }
            socketCliente.close();
            servidor.close();
            System.out.println("Servidor cerrado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
```java
import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Conectado al servidor.");
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensajeCliente;
            String respuestaServidor;
            do {
                System.out.print("Escribe un mensaje: ");
                mensajeCliente = teclado.readLine();
                salida.println(mensajeCliente);
                respuestaServidor = entrada.readLine();
                System.out.println(respuestaServidor);
            } while (!mensajeCliente.equalsIgnoreCase("salir"));
            socket.close();
            System.out.println("Cliente desconectado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 
```

## Ejecución de Prueba
-Inicia el Servidor: Asegúrate de que el servidor esté ejecutándose y escuchando conexiones.
-Conecta el Cliente: Ejecuta el cliente para conectarte al servidor.
-Interacción: Envía mensajes desde el cliente y observa cómo el servidor los recibe y responde.
-Finaliza la Comunicación: Envía "salir" desde el cliente para cerrar la conexión.

## Posibles Errores y Soluciones
-Puerto Ocupado: Si recibes un error de que el puerto está ocupado, asegúrate de que no haya otro proceso utilizando el puerto 5000 o cambia el número de puerto en el código.
-Conexión Rechazada: Verifica que el servidor esté en ejecución antes de iniciar el cliente.

## Contribuciones

Las contribuciones son bienvenidas. Puedes hacerlo de la siguiente manera:

-Fork: Haz un fork del proyecto.
-Clonar: Clona tu fork en tu máquina local.
-Crear una Rama: Crea una rama para tu característica o corrección de errores.
-Commit: Realiza los cambios y haz commit con mensajes descriptivos.
-Push: Sube tus cambios a tu repositorio en GitHub.
-Pull Request: Abre un pull request en el repositorio original.

Muchas Gracias por observar mi producto
