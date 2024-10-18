package calculator.domain.separator;

import calculator.domain.number.Number;
import java.util.Arrays;
import java.util.List;

public class BasicSeparator implements Separator {

    private static final String COMMA = ",";
    private static final String COLON = ":";

    @Override
    public List<Number> separate(String value) {
        if (hasSeparatorIn(value)) {
            return convert(validateOfSeparator(value));
        }

        return List.of(new Number(value));
    }

    private boolean hasSeparatorIn(String value) {
        return value.contains(COMMA) || value.contains(COLON);
    }

    private List<Number> convert(List<String> values) {
        return values.stream()
                .map(Number::new)
                .toList();
    }

    private List<String> divideBySeparator(String value) {
        return Arrays.stream(value.split(COMMA + "|" + COLON))
                .toList();
    }

    private List<String> validateOfSeparator(String value) {
        validateEdgeSeparator(value);
        validateContinuousSeparator(value);
        return divideBySeparator(value);
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
