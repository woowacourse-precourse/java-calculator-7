package calculator;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {
    private SeparatorManager sepManager;
    public StringSplitter(SeparatorManager sepManager) {
        this.sepManager = sepManager;
    }
    public List<String> split(String input, List<String> separators) {
        String regex = String.join("|", separators);
        return Arrays.asList(input.split(regex));
    }
}
