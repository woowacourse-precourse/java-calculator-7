package calculator.domain;

import calculator.constants.Constants;

public class InputTypeSorter {
    private static final String DOUBLE_SLASH = "//";
    private static final String ESCAPE = "\\n";

    public static Input sort(String text) {
        if (containsBasicDelimiter(text)) {
            return new BasicDelimiterInput(text);
        }
        if (containsCustomDelimiter(text)) {
            return new CustomDelimiterInput(text);
        }
        return new DefaultInput(text);
    }

    public static boolean containsBasicDelimiter(String text) {
        return text.contains(Constants.COMMA) || text.contains(Constants.COLON);
    }

    public static boolean containsCustomDelimiter(String text) {
        return text.contains(DOUBLE_SLASH) && text.contains(ESCAPE);
    }
}
