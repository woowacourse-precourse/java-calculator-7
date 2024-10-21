package calculator;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    //기본 구분자, 참조/내용 변경 불가능
    private final List<String> defaultDelimiters = List.of(",",":");
    //커스텀 구분자, 참조 변경 불가능
    private final List<String> customDelimiters = new ArrayList<>();

    public String[] parseInput(String input) {
        if (input.startsWith("//")){
            input = extractCustomDelimiter(input);
            String regex = String.join("|", defaultDelimiters) + "|" + String.join("|", customDelimiters);
            return input.split(regex);
        } else{
            String regex = String.join("|", defaultDelimiters);
            return input.split(regex);
        }
    }
    private String extractCustomDelimiter(String input) {
        int delimiterEndIndex = input.indexOf("\\n");

        if (delimiterEndIndex == -1)
            throw new IllegalArgumentException("Invalid delimiter: " + input);

        String customDelimiter = input.substring(2, delimiterEndIndex);

        if (!customDelimiters.contains(customDelimiter)){
            customDelimiters.add(customDelimiter);
        }

        return input.substring(delimiterEndIndex+2);
    }
}
