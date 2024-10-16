package calculator.domain.vo.delimiter;

import static calculator.domain.vo.delimiter.constants.DelimiterPattern.*;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {

    private final List<Delimiter> values;

    private Delimiters(List<Delimiter> values) {
        validate(values);
        this.values = values;
    }

    protected void validate(List<Delimiter> values) {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static Delimiters from(final String input) {
        List<Delimiter> values = new ArrayList<>();
        addDefaultDelimiters(values);
        addCustomDelimiter(values, input);

        return new Delimiters(values);
    }

    private static void addDefaultDelimiters(List<Delimiter> values) {
        values.add(Delimiter.from(COMMA.getValue()));
        values.add(Delimiter.from(COLON.getValue()));
    }

    private static void addCustomDelimiter(List<Delimiter> values, String input) {
        String customDelimiter = parseCustomDelimiter(input);
        if (!customDelimiter.isEmpty()) {
            values.add(Delimiter.from(customDelimiter));
        }
    }

    private static String parseCustomDelimiter(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX.getValue()) && input.contains(
            CUSTOM_DELIMITER_SUFFIX.getValue())) {
            return input.substring(2, input.indexOf(CUSTOM_DELIMITER_SUFFIX.getValue()));
        }
        return EMPTY.getValue();
    }
}
