import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ResourceBundle;

public class Server {
    private ServerSocket socketOnService;
    private ResourceBundle i18n;

    public Server(){
         i18n = Internationalization.getI18n();
    }

    public void openSocket() throws IOException {
        socketOnService = new ServerSocket(9000);
    }

    public void startConnectionManagment() throws IOException {
        while (true) {
            System.out.println(i18n.getString("MACHINEwait"));
            Socket clientSocket = socketOnService.accept();
            System.out.println(i18n.getString("MACHINEaccepted"));
            new Connection(clientSocket).start();
            System.out.println(i18n.getString("MACHINEstarted"));
        }
    }
}
