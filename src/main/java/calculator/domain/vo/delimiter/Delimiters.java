package calculator.domain.vo.delimiter;

import static calculator.domain.vo.delimiter.constants.DelimiterPattern.*;
import static calculator.infrastructure.exception.ErrorCode.*;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {

    private final List<Delimiter> delimiters;

    private Delimiters(final List<Delimiter> delimiters) {
        validate(delimiters);
        this.delimiters = delimiters;
    }

    protected void validate(final List<Delimiter> delimiters) {
        if (delimiters == null || delimiters.isEmpty()) {
            throw new IllegalArgumentException(INVALID_COLLECTION.getMessage());
        }
    }

    public static Delimiters from(final String input) {
        List<Delimiter> values = new ArrayList<>();
        addDefaultDelimiters(values);
        addCustomDelimiter(values, input);

        return new Delimiters(values);
    }

    private static void addDefaultDelimiters(final List<Delimiter> values) {
        values.add(Delimiter.from(COMMA.getValue()));
        values.add(Delimiter.from(COLON.getValue()));
    }

    private static void addCustomDelimiter(final List<Delimiter> values, final String input) {
        String customDelimiter = parseCustomDelimiter(input);
        if (!customDelimiter.isEmpty()) {
            values.add(Delimiter.from(customDelimiter));
        }
    }

    private static String parseCustomDelimiter(final String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX.getValue()) && input.contains(
            CUSTOM_DELIMITER_SUFFIX.getValue())) {
            return input.substring(2, input.indexOf(CUSTOM_DELIMITER_SUFFIX.getValue()));
        }
        return EMPTY.getValue();
    }

    public String getDelimiterRegex() {
        StringBuilder regex = new StringBuilder();
        for (Delimiter delimiter : delimiters) {
            regex.append(delimiter.getValue());
            regex.append(PIPE.getValue());
        }
        regex.deleteCharAt(regex.length() - 1);
        return regex.toString();
    }

}
