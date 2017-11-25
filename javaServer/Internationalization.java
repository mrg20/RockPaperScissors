import java.util.Locale;
import java.util.ResourceBundle;

public class Internationalization {

    private static ResourceBundle i18n = null;

    private Internationalization(ResourceBundle bundle){
        i18n = bundle;
    }

    public static void createBundle(String language, String country){
        if(i18n == null){
            new Internationalization(ResourceBundle.getBundle("Bundle", new Locale(language, country)));
        }
    }

    public static ResourceBundle getI18n() {
        return i18n;
    }
}
