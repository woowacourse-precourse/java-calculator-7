package calculator;

import java.util.List;

public class Splitter {
    public static String[] splitByDelimiters(String input, List<String> delimiters) {
        String regex = String.join("|", delimiters.stream()
                .map(delimiter -> "\\" + delimiter)
                .toArray(String[]::new));
        return input.split(regex);
    }
}
