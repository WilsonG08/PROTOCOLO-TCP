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
            // Socket socket_cliente = new Socket("localhost", 3000);
            Socket socket_cliente = new Socket("172.31.118.83", 3000);

            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Ingrese el mensaje para el servidor: ");

                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
                PrintWriter salida = new PrintWriter(socket_cliente.getOutputStream(), true);

                // Enviar datos al cliente
                String mensaje = scanner.nextLine();
                salida.println(mensaje);

                // Leer datps reconodos desde el cliente
                String datos_recibidos = entrada.readLine();
                System.out.println("Mensaje recibido: " + datos_recibidos);
            }
            // Crear buffer para recibir y enviar datos al cliente

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
