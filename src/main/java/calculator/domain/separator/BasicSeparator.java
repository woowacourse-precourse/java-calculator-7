package calculator.domain.separator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BasicSeparator implements Separator {

    private static final String COMMA = ",";
    private static final String COLON = ":";

    @Override
    public List<String> separate(String value) {
        return convert(validate(value));
    }

    private List<String> convert(String value) {
        if (hasSeparatorIn(value)) {
            return Arrays.stream(value.split(COMMA + "|" + COLON))
                    .collect(Collectors.toList());
        }

        return List.of(value);
    }

    private boolean hasSeparatorIn(String value) {
        return value.contains(COMMA) || value.contains(COLON);
    }

    private String validate(String value) {
        validateEdgeSeparator(value);
        validateContinuousSeparator(value);
        return value;
    }

    private void validateEdgeSeparator(String value) {
        if (hasEdgeSeparator(value, COMMA) || hasEdgeSeparator(value, COLON)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasEdgeSeparator(String value, String separator) {
        return value.startsWith(separator) || value.endsWith(separator);
    }

    private void validateContinuousSeparator(String value) {
        if (isContinuousSeparator(value, COMMA) || isContinuousSeparator(value, COLON)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isContinuousSeparator(String value, String separator) {
        return value.contains(separator.repeat(2));
    }
}
