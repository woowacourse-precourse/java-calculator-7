package calculator.domain;

import static calculator.constant.Constants.ErrorMessage.*;
import static calculator.constant.Constants.Separator.*;

public class RegexSeparators implements Separators {

    //regex
    private final String data;


    private RegexSeparators(String data) {
        this.data = data;
    }

    public static RegexSeparators createWithDefault() {
        return new RegexSeparators(DEFAULT_SEPARATOR_COMMA + OR + DEFAULT_SEPARATOR_COLON);
    }

    @Override
    public RegexSeparators add(String customSeparator) {
        validateCustomSeparator(customSeparator);
        return new RegexSeparators(this.data + OR + customSeparator);
    }

    @Override
    public String data() {
        return data;
    }

    private void validateCustomSeparator(String customSeparator) {
        checkEmptySeparator(customSeparator);
        checkSeparatorLength(customSeparator);
        checkDuplicateSeparator(customSeparator);
    }

    private void checkEmptySeparator(String customSeparator) {
        if (customSeparator.isBlank()) {
            throw new IllegalArgumentException(EMPTY_SEPARATOR_ERROR);
        }
    }

    private void checkSeparatorLength(String customSeparator) {
        if (customSeparator.length() != CUSTOM_SEPARATOR_LENGTH) {
            throw new IllegalArgumentException(INVALID_SEPARATOR_LENGTH_ERROR);
        }
    }

    private void checkDuplicateSeparator(String customSeparator) {
        if (data.contains(customSeparator)) {
            throw new IllegalArgumentException(DUPLICATE_SEPARATOR_ERROR);
        }
    }

}
