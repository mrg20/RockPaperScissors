import java.util.Random;

public class GameController {

    public void printInstructions(){
        System.out.println("Game Instructions");
    }

    public String doMatch(String clientInfo){
        int action = createAction();
        return compareActions(action, Integer.parseInt(clientInfo));
    }

    private int createAction() {
        Random random = new Random();
        int max = 3;
        int min = 1;
        return random.nextInt(max - min + 1) + min;
    }

    private String compareActions(int action, int clientAction) {
        int[] winList=new int[]{3, 1, 2};
        if(winList[clientAction-1] == action){
            return "YOU WIN THIS TIME";
        }else if(action == clientAction){
            return "DRAFT, USED THE SAME COMMANDS";
        }
        return "YOU LOSE, THIS AI IS POWERFUL";
    }
}
