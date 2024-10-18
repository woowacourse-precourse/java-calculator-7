package separator;

import java.util.ArrayList;

public class Separator {
    public static ArrayList<Character> separators = new ArrayList<>();

    public Separator() {
        separators.add(',');
        separators.add(':');
    }

    public void addNewSeparators(char separator) {
        separators.add(separator);
    }
}
