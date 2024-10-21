package calculator.separator;

import java.util.ArrayList;
import java.util.List;

public class DelimiterStorage {
    private static final List<String> delimiters = new ArrayList<>();
    public void addDelimiter(String delimiter){

        if(delimiter.matches("\\d")){
            throw new IllegalArgumentException("숫자는 구분자가 될 수 없다");
        }

        delimiters.add(delimiter);
    }
    public List<String> getDelimiters() {
        return new ArrayList<>(delimiters);
    }
}
