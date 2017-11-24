import java.io.IOException;

public class RockPaperScissors {
    public static void main(String[] args) throws IOException {
        giveInstructions();
        Server server = new Server();
        server.openSocket();
        server.startConnectionManagment();
    }

    private static void giveInstructions() {
        System.out.println("Instructions");
    }
}
