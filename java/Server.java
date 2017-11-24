import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket myService;
    private Socket serviceSocket;

    public void openSocket() throws IOException {
        myService = new ServerSocket(1024);
    }

    public void acceptConnection(){
        try {
            serviceSocket = myService.accept();
        }
        catch (IOException e) {//Do not want to close the socket if I cannot accept a client.
            System.out.println(e);
        }
    }

    public DataInputStream receiveInformation() throws IOException {
        DataInputStream input = null;
        input = new DataInputStream(serviceSocket.getInputStream());
        return input;
    }

    public void sendInformation(String information) throws IOException {
        DataOutputStream output;
        output = new DataOutputStream(serviceSocket.getOutputStream());
        output.writeBytes(information);
    }
}
