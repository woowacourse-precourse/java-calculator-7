package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Delimiters {

    private static final int BEGIN_INDEX = 2;
    private static final String CUSTOM_DELIMITER_END_SEPARATOR = "\n";
    private static final String DEFAULT_DELIMITER_COMMA = ",";
    private static final String DEFAULT_DELIMITER_COLON = ":";
    private static final String CUSTOM_DELIMITER_START_SEPARATOR = "//";

    private final List<String> delimiters;

    public Delimiters() {
        this.delimiters = new ArrayList<>();
        addDefaultDelimiters();
    }

    private void addDefaultDelimiters() {
        delimiters.add(DEFAULT_DELIMITER_COMMA);
        delimiters.add(DEFAULT_DELIMITER_COLON);
    }

    public List<String> getAllDelimiters(final String input) {
        findCustomDelimiter(input).ifPresent(delimiters::add);

        return delimiters;
    }

    private Optional<String> findCustomDelimiter(final String input) {
        if (hasCustomDelimiter(input)) {
            return Optional.of(input.substring(BEGIN_INDEX, input.indexOf(CUSTOM_DELIMITER_END_SEPARATOR)));
        }

        return Optional.empty();
    }

    public boolean hasCustomDelimiter(final String input) {
        return input.startsWith(CUSTOM_DELIMITER_START_SEPARATOR);
    }
}
