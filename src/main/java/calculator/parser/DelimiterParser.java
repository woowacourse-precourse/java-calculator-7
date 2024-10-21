package calculator.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DelimiterParser {

    private static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");

    //TODO 3 : 기본 구분자를 기준으로 구분자 분리하는 기능
    public static List<String> parseDelimiters(String input) {
        List<String> delimiters = new ArrayList<>(DEFAULT_DELIMITERS);

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            String customDelimiter = input.substring(2, delimiterEndIndex);
            delimiters.add(customDelimiter);
        }

        return delimiters;
    }

    //TODO 4 : 커스텀 구분자를 기준으로 구분자 분리하는 기능
    public static String extractNumbersPart(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            return input.substring(delimiterEndIndex + 1);
        }
        return input;
    }
}
