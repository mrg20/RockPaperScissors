import java.io.*;
import java.net.Socket;
import java.util.ResourceBundle;

public class Connection extends Thread{
    private BufferedReader input;
    private PrintWriter output;
    private Socket serviceSocket;
    private GameController gameController;
    private ResourceBundle i18n;

    public Connection(Socket serviceSocket){
        this.serviceSocket = serviceSocket;
        gameController = new GameController();
        i18n = Internationalization.getI18n();
    }

    @Override
    public void run(){
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
        input = new BufferedReader(new InputStreamReader(serviceSocket.getInputStream()));
    }

    public void openOutputSocket() throws IOException {
        output = new PrintWriter(new OutputStreamWriter(serviceSocket.getOutputStream(),
                "UTF-8"), true);
    }

    private void inputOutputController() throws IOException {
        while (true) {
            System.out.println(i18n.getString("wait"));
            String clientInfo = readSocket();
            System.out.println(i18n.getString("received") + clientInfo);
            String matchResult = gameController.doMatch(clientInfo);
            System.out.println(i18n.getString("sending") + matchResult);
            sendInformation(matchResult);
        }
    }

    public String readSocket() throws IOException {
        return input.readLine();
    }

    public void sendInformation(String information) throws IOException {
        output.println(information);
    }
}
