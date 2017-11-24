import java.io.IOException;

public class RockPaperScissors {
    public static void main(String[] args) throws IOException {
        new GameController().printInstructions();
        Server server = new Server();
        server.openSocket();
        server.startConnectionManagment();
    }
}
