package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    public static List<String> separators;
    public Separator() {
        separators = new ArrayList<>();
        separators.add(";");
        separators.add(",");
    }

    public void addSeparator(String separator) {
        separators.add(separator);
    }
}
