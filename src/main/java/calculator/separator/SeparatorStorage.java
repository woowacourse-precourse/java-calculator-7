package calculator.separator;

import java.util.ArrayList;
import java.util.List;

public class SeparatorStorage {
    private static List<String> separators = new ArrayList<>();
    public void addSeparator(String separator){
        separators.add(separator);
    }
    public List<String> getSeparators() {
        return new ArrayList<>(separators);
    }
}
