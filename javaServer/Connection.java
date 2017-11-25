import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connection extends Thread{
    private DataInputStream input;
    private DataOutputStream output;
    private Socket serviceSocket;
    private GameController gameController;

    public Connection(Socket serviceSocket){
        this.serviceSocket = serviceSocket;
        gameController = new GameController();
    }

    @Override
    public void run(){
        System.out.println("Server routine starting");
        try {
            openInputSocket();
            openOutputSocket();
            inputOutputController();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                serviceSocket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void openInputSocket() throws IOException {
        input = new DataInputStream(serviceSocket.getInputStream());
    }

    public void openOutputSocket() throws IOException {
        output = new DataOutputStream(serviceSocket.getOutputStream());
    }

    private void inputOutputController() throws IOException {
        while (true) {
            System.out.println("Waiting for client input");
            String clientInfo = readSocket();
            System.out.println("Info received: " + clientInfo);
            String matchResult = gameController.getMatchResult(clientInfo);
            System.out.println("Sending info: " + matchResult);
            sendInformation(matchResult);
        }
    }

    public String readSocket() throws IOException {
        return input.readUTF();
    }

    public void sendInformation(String information) throws IOException {
        output.writeUTF(information);
    }
}
