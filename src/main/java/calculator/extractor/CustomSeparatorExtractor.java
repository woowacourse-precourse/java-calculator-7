package calculator.extractor;

import calculator.domain.Separator;
import calculator.domain.Separators;
import calculator.dto.SeparatorsResult;

public final class CustomSeparatorExtractor {
    private static final String CUSTOM_SEPARATOR_FORMAT = "^//.\\\\n.*";

    public SeparatorsResult getSeparatorsResult(String input) {
        return new SeparatorsResult(new Separators(), input);
    }

    public boolean hasCustomSeparator(String str) {
        return str.matches(CUSTOM_SEPARATOR_FORMAT);
    }

    public Separator getCustomSeparator(String str) {
        return Separator.createCustomSeparator(str.charAt(2));
    }
}
