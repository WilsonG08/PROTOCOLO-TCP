import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class hiloCliente  extends Thread{

    private Socket socket_cliente;

    public hiloCliente(Socket socket_cliente){
        this.socket_cliente = socket_cliente;
    }

    public void run(){

        // Crear buffer para recibir y enviar datos al cliente
        try {
            while (true){

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(socket_cliente.getOutputStream(), true);

            //Crear datos recibidos desde el cliente
            String datos_recibido = entrada.readLine();
            System.out.println("Mensaje recibido: " + datos_recibido);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el mansaje para el cliente: ");
            String mensaje =scanner.nextLine();

            // Enviar datos al cliente
            salida.println(mensaje);
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
