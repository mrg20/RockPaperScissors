import java.util.Random;
import java.util.ResourceBundle;

public class GameController {
    private ResourceBundle i18n;

    public GameController(){
        i18n = Internationalization.getI18n();
    }

    public void printInstructions(){
        System.out.println(i18n.getString("INSTRUCTIONS1"));
        System.out.println(i18n.getString("INSTRUCTIONS2"));
        System.out.println(i18n.getString("INSTRUCTIONS3"));
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
            return i18n.getString("WIN");
        }else if(action == clientAction){
            return i18n.getString("DRAFT");
        }
        return i18n.getString("LOSE");
    }
}
