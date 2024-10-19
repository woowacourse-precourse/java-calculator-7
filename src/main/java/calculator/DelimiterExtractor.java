package calculator;

public class DelimiterExtractor {

    private String text;

    public DelimiterExtractor(String text) {
        this.text = text;
    }

    public static boolean hasDelimiter(String regex, String text) {
        String result = text.replaceAll(regex, " ");
        return !result.isBlank();
    }

    public DelimiterType type() {
        final String LINE_BREAK = "\\n";

        if (this.text.split(LINE_BREAK).length > 1) {
            return DelimiterType.CUSTOM;
        }

        return DelimiterType.BASIC;
    }

    public String remove(String regex) {
        final String LINE_BREAK = "\\n";
        final int OPERATION_FORMULA_LOCATION = 1;

        if (DelimiterType.BASIC.equals(this.type())) {
            return remove(regex, this.text);
        }

        return remove(regex, this.text.split(LINE_BREAK)[OPERATION_FORMULA_LOCATION]);
    }

    private String remove(String regex, String target) {
        return target.replaceAll(regex, " ");
    }

    public String extractCustomDelimiter() {
        final String PREFIX = "//";
        final String LINE_BREAK = "\\n";
        final int DELIMITER_LOCATION = 0;

        if (DelimiterType.CUSTOM.equals(this.type())) {
            return this.text
                    .split(LINE_BREAK)[DELIMITER_LOCATION]
                    .replaceAll(PREFIX, "")
                    .trim();
        }

        return "";
    }

    public void validate(String positiveNumberPattern) {
        String delimiterLeft = remove(positiveNumberPattern);
        String maybeNothing = remove(createRegularExpression(), delimiterLeft).trim();

        if (!maybeNothing.isBlank()) {
            throw new IllegalArgumentException("[" + type() + "] " + maybeNothing + " 은 잘못된 구분자예요!");
        }
    }

    private String createRegularExpression() {
        String BASIC_DELIMITER_REGEX = ",|:";

        if (DelimiterType.BASIC.equals(this.type())) {
            return BASIC_DELIMITER_REGEX;
        }

        return extractCustomDelimiter();
    }

}
