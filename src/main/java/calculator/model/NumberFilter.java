package calculator.model;

import java.util.Arrays;
import java.util.List;

public class NumberFilter {
    private static final String NUMBER_FROM = "^[0-9]+$";
    private static final List<String> SPECIAL_STRINGS =
            Arrays.asList(".", "^", "$", "*", "+", "?", "{", "}", "[", "]", "(", ")", "|");


    public List<Long> filter(String inputString, String separator) {
        String confirmedSeparator = confirmSeparator(separator);

        return Arrays.stream(inputString.split(confirmedSeparator))
                .filter(token -> token.matches(NUMBER_FROM))
                .map(Long::parseLong)
                .toList();
    }

    private String confirmSeparator(String separator) {
        if (SPECIAL_STRINGS.contains(separator)) {
            return "\\" + separator;
        }

        return separator;
    }
}
