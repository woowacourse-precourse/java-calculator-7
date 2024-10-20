package calculator.model;

import java.util.Arrays;
import java.util.List;

public class NumberFilter {
    private static final String NUMBER_FROM = "^[0-9]+$";
    private static final List<String> SPECIAL_STRINGS =
            Arrays.asList(".", "^", "$", "*", "+", "?", "{", "}", "[", "]", "(", ")", "|");
    Validation validation = new Validation();


    public List<Long> filter(String inputString, String separator) {
        if (validation.isCustomFrom(inputString)) {
            return customFilter(inputString, separator);
        }

        return basicFilter(inputString, separator);
    }


    private List<Long> basicFilter(String inputString, String separator) {
        return Arrays.stream(inputString.split(separator))
                .filter(token -> token.matches(NUMBER_FROM))
                .map(Long::parseLong)
                .toList();
    }

    private List<Long> customFilter(String inputString, String separator) {
        String confirmedSeparator = confirmSeparator(separator);
        String modifiedInputString = modifyInputString(inputString);

        return basicFilter(modifiedInputString, confirmedSeparator);
    }

    private String modifyInputString(String inputString) {
        return inputString.substring(inputString.indexOf("n") + 1);
    }

    private String confirmSeparator(String separator) {
        if (SPECIAL_STRINGS.contains(separator)) {
            return "\\" + separator;
        }

        return separator;
    }
}
