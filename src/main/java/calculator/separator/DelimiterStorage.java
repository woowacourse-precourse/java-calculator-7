package calculator.separator;

import java.util.ArrayList;
import java.util.List;

public class DelimiterStorage {
    private static List<String> delimiters = new ArrayList<>();
    public void addDelimiter(String delimiter){
        delimiters.add(delimiter);
    }
    public List<String> getDelimiters() {
        return new ArrayList<>(delimiters);
    }
}
