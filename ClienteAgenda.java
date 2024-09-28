
import java.io.*;
import java.net.*;

public class ClienteAgenda {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Conectado al servidor de Agendamiento.");

            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String mensajeCliente;
            String respuestaServidor;

            do {
                System.out.println("Escribe 'AGREGAR <Tarea>' para agregar una Tarea, 'VER' para ver las tareas o 'salir' para desconectarte.");
                mensajeCliente = teclado.readLine();
                salida.println(mensajeCliente);

                respuestaServidor = entrada.readLine();
                System.out.println("Servidor dice: " + respuestaServidor);

            } while (!mensajeCliente.equalsIgnoreCase("salir"));

            socket.close();
            System.out.println("Cliente desconectado.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
