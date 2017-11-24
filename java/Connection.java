import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connection extends Thread{
    private DataInputStream input;
    private DataOutputStream output;
    private Socket serviceSocket;

    public Connection(Socket serviceSocket){
        this.serviceSocket = serviceSocket;
    }

    @Override
    public void run(){

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
