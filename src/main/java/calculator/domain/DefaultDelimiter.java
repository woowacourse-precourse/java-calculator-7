package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class DefaultDelimiter implements Delimiter {

    private static final Pattern DEFAULT = Pattern.compile("[\\d*(,|:)?]*");
    private static final String DEFAULT_DELIMITER = "[,|:]";

    private final String input;

    public DefaultDelimiter(final String input) {
        this.input = input;
    }

    @Override
    public boolean matches() {
        return DEFAULT.matcher(input)
                .matches();
    }

    @Override
    public List<String> split() {
        return Arrays.stream(input.split(DEFAULT_DELIMITER))
                .toList();
    }

}
