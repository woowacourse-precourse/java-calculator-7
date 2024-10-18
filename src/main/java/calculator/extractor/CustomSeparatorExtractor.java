package calculator.extractor;

import calculator.domain.Separator;

public final class CustomSeparatorExtractor {
    private static final String CUSTOM_SEPARATOR_FORMAT = "^//.\\\\n.*";

    public boolean hasCustomSeparator(String str) {
        return str.matches(CUSTOM_SEPARATOR_FORMAT);
    }

    public Separator getCustomSeparator(String str) {
        return Separator.createCustomSeparator(str.charAt(2));
    }
}
