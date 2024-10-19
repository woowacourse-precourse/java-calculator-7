package calculator.global.util;

import java.util.Arrays;

abstract class DelimiterExtractor {

    protected static final String VALID_NUMERIC_REGEX = "^(0|[1-9][0-9]*)(\\.[0-9]+)?$";

    abstract String extractDelimiter(String input);

    public Integer[] extractNumber(String input) {
        String delimiter = extractDelimiter(input);
        return Arrays.stream(input.split(delimiter))
                .map(String::trim)
                .map(numStr ->{
                    if(isNotValid(numStr)) throw  new IllegalArgumentException(numStr);
                    return Integer.parseInt(numStr);
                })
                .toArray(Integer[]::new); // Integer 배열로 변환;
    }

    abstract boolean isApplicable(String input);

    private boolean isNotValid(String input) {
        return !input.matches(VALID_NUMERIC_REGEX);
    }
}
