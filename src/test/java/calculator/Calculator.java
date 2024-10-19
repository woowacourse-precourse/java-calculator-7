package calculator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Calculator {

    public Set<String> delimiters = new HashSet<>(Arrays.asList(",", ";"));

    public void checkCustomDelimiter(String input) {
        if (input.startsWith("//") && input.endsWith("\n")) {
            String content = input.substring(2, input.length() - 1);
            delimiters.add(content);
        }
    }

    public String[] splitNumbers(String input) {
        if (input.startsWith("//")) {
            input = input.substring(input.indexOf("\n") + 1);
        }
        String regex = String.join("|", delimiters);
        return input.split(regex);
    }
}
