package calculator.global.util;

import java.util.Arrays;

public class DefaultDelimiterExtractor extends DelimiterExtractor {

    private final String delimiter;

    public DefaultDelimiterExtractor(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public Integer[] extractNumber(String input) {
        return Arrays.stream(input.split(delimiter))
                .map(String::trim)
                .map(numStr ->{
                    if(numStr.isEmpty()) return 0;
                    if(isNotValid(numStr)) throw  new IllegalArgumentException(numStr);
                    return Integer.parseInt(numStr);
                })
                .toArray(Integer[]::new);
    }


    @Override
    public boolean isApplicable(String input) {
        return !input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }
}
