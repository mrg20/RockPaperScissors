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
            new Connection(clientSocket).start();
        }
    }
}
