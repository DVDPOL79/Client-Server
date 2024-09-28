
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ServidorAgenda {
    private static List<String> citas = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(5000);
            System.out.println("Servidor de Agendamiento iniciado...");

            Socket socketCliente = servidor.accept();
            System.out.println("Cliente conectado!");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true);

            String mensajeCliente;
            while ((mensajeCliente = reader.readLine()) != null) {
                if (mensajeCliente.startsWith("AGREGAR")) {
                    String cita = mensajeCliente.substring(8); // Extraer la cita
                    citas.add(cita);
                    salida.println("Tarea agregada: " + cita);
                } else if (mensajeCliente.equals("VER")) {
                    if (citas.isEmpty()) {
                        salida.println("No hay Tareas.");
                    } else {
                        salida.println("Tareas actuales: " + citas);
                    }
                } else if (mensajeCliente.equalsIgnoreCase("salir")) {
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
