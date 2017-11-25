import java.io.IOException;

public class RockPaperScissors {
    public static void main(String[] args) throws IOException {
        setBundle(args);
        new GameController().printInstructions();
        Server server = new Server();
        server.openSocket();
        server.startConnectionManagment();
    }

    private static void setBundle(String[] language) {
        if(language.length>1){
            String[] languageInfo = language[1].split("_");
            Internationalization.createBundle(languageInfo[0], languageInfo[1]);
        }else{
            Internationalization.createBundle("en", "US");
        }
    }
}
