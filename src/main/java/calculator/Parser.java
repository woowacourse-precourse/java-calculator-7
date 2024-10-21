package calculator;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private String delimiters = ",|:";
    List<String> tokens = new ArrayList<>();

    public List<String> parsing(String rawLine) {
        if (rawLine.startsWith("//")) {
            int delimiterEndIndex = rawLine.indexOf("\\n");
            if (delimiterEndIndex != -1) {
                delimiters = rawLine.substring(2, delimiterEndIndex);
                rawLine = rawLine.substring(delimiterEndIndex + 2);
            } else {
                System.exit(1);
            }
        }
        return tokens = List.of(rawLine.split(delimiters));
    }
}
