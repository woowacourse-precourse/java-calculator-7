package calculator.model;

import java.util.Arrays;
import java.util.List;

public class NumberFilter {
    private static final String NUMBER_FROM = "^[0-9]+$";
    private static final List<String> SPECIAL_STRINGS =
            Arrays.asList(".", "^", "$", "*", "+", "?", "{", "}", "[", "]", "(", ")", "|");
    Validation validation = new Validation();


    public List<Long> filter(final String inputString, final String separator) {
        if (validation.isZeroFrom(inputString)) {
            return zeroFilter();
        }

        if (validation.isCustomFrom(inputString)) {
            return customFilter(inputString, separator);
        }

        return basicFilter(inputString, separator);
    }

    private List<Long> zeroFilter() {
        return List.of(0L);
    }

    private List<Long> basicFilter(final String inputString, final String separator) {
        return Arrays.stream(inputString.split(separator))
                .filter(token -> token.matches(NUMBER_FROM))
                .map(Long::parseLong)
                .toList();
    }

    private List<Long> customFilter(final String inputString, final String separator) {
        String confirmedSeparator = confirmSeparator(separator);
        String modifiedInputString = modifyInputString(inputString);

        return basicFilter(modifiedInputString, confirmedSeparator);
    }

    private String modifyInputString(final String inputString) {
        return inputString.substring(inputString.indexOf("n") + 1);
    }

    private String confirmSeparator(final String separator) {
        if (SPECIAL_STRINGS.contains(separator)) {
            return "\\" + separator;
        }

        return separator;
    }
}
