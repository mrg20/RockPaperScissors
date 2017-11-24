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
            Socket clientSocket = socketOnService.accept();
            System.out.println("Client Accepted");
            new Connection(clientSocket).start();
            System.out.println("Connection Started");
        }
    }
}
