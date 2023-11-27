import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class clienteTCP {

    public static void main(String[] args) {
        try {
            // Crear un socket para conectarse al servidor
            Socket socketCliente = new Socket("172.31.118.83", 3000);
            String mensaje;

            do {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Ingrese el mensaje para el servidor: ");

                BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
                PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true);

                // Enviar datos al servidor
                mensaje = scanner.nextLine();
                salida.println(mensaje);

                // Salir del bucle si el mensaje es "chao"
                if (mensaje.equals("chao")) {
                    break;
                }

                // Leer datos recibidos desde el servidor
                String datosRecibidos = entrada.readLine();
                System.out.println("Mensaje recibido: " + datosRecibidos);

            } while (true); // El bucle se ejecuta siempre, pero se sale si el mensaje es "chao"

            // Cerrar la conexión
            socketCliente.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
