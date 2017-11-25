public class GameController {

    public void printInstructions(){
        System.out.println("Game Instructions");
    }

    public String getMatchResult(String clientInfo){
        System.out.println("A client send:" + clientInfo);
        return "";
    }
}
