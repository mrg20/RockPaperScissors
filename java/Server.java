import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket myService;
    private Socket serviceSocket;
    private DataInputStream input;
    private DataOutputStream output;

    public void openSocket() throws IOException {
        myService = new ServerSocket(1024);
    }

    public void acceptConnection(){
        try {
            serviceSocket = myService.accept();
        }
        catch (IOException acceptClientError) {//Do not want to close the socket if I cannot accept a client.
            System.out.println(acceptClientError);
        }
    }

    public void openInputSocket() throws IOException {
        input = new DataInputStream(serviceSocket.getInputStream());
    }

    public String readSocket() throws IOException {
        return input.readUTF();
    }

    public void openOutputSocket() throws IOException {
        output = new DataOutputStream(serviceSocket.getOutputStream());
    }

    public void sendInformation(String information) throws IOException {
        output.writeUTF(information);
    }
}
