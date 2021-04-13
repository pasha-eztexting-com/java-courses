package Task2_1;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {
        Locale currentLocale;
        if (args.length > 0 && args[0].equals("Ru")) {
            currentLocale = new Locale("ru","RU");
        } else {
            currentLocale = new Locale("en","EN");
        }

        ResourceBundle bundle = ResourceBundle.getBundle("Task2_1/PudgeBundle", currentLocale);

        Menu menu = new Menu(bundle);

        menu.process();
    }
}
