package calculator.parser;

import java.util.regex.Pattern;

public class DefaultStringParser implements StringParser {
    private static final Pattern DEFAULT_DELIMITER = Pattern.compile("[,:]");

    @Override
    public Long[] parseToLong(String input) {
        return DEFAULT_DELIMITER.splitAsStream(input)
                .mapToLong(Long::parseLong)
                .boxed()
                .toArray(Long[]::new);
    }
}
