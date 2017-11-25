import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket socketOnService;

    public void openSocket() throws IOException {
        socketOnService = new ServerSocket(9000);
    }

    public void startConnectionManagment() throws IOException {
        while (true) {
            System.out.println("MACHINE: Waiting a client");
            Socket clientSocket = socketOnService.accept();
            System.out.println("MACHINE: Client accepted");
            new Connection(clientSocket).start();
            System.out.println("MACHINE: Connection started with one client");
        }
    }
}
