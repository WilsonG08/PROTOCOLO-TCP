import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class servidorTCP {

    public static void main(String[] args) {
        // Crear socket del servidor
        try{
            ServerSocket socket_servidor = new ServerSocket(3000);
            System.out.println("Esperando conexion");

            while (true){

                // Esperar y aceptar conxione del cliente
                Socket socket_cliente = socket_servidor.accept();
                System.out.println("Cliente conectado: "+ socket_cliente.getInetAddress().getHostAddress());

                // Crear un hilo para manejar la conexion con el clienteeeeeee
                hiloCliente hilo = new hiloCliente(socket_cliente);
                hilo.start();
            }

        }catch(IOException e){
            // Todo Auto generated cathc block
            e.printStackTrace();
        }
    }
}
