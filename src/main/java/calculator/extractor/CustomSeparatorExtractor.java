package calculator.extractor;

import calculator.domain.Separator;
import calculator.domain.Separators;
import calculator.dto.SeparatorsResult;

public final class CustomSeparatorExtractor {
    private static final String CUSTOM_SEPARATOR_FORMAT = "^//.\\\\n.*";
    private static final int CUSTOM_SEPARATOR_DEFINITION_LENGTH = 5;

    public SeparatorsResult getSeparatorsResult(String input) {
        if (hasCustomSeparator(input)) {
            Separator customSeparator = getCustomSeparator(input);
            return new SeparatorsResult(
                    new Separators(customSeparator), input.substring(CUSTOM_SEPARATOR_DEFINITION_LENGTH)
            );
        }
        return new SeparatorsResult(new Separators(), input);
    }

    public boolean hasCustomSeparator(String str) {
        return str.matches(CUSTOM_SEPARATOR_FORMAT);
    }

    public Separator getCustomSeparator(String str) {
        return Separator.createCustomSeparator(str.charAt(2));
    }
}
