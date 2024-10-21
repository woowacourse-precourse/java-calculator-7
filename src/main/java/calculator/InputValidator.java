package calculator;

public class InputValidator {
    private static final String ERROR_NEGATIVE_NUMBER = "음수는 허용되지 않습니다.";
    private static final String ERROR_STARTS_WITH_CHAR = "커스텀 문자 지정 외에는 문자로 시작할 수 없습니다.";

    private final Delimiter delimiter;
    private final Parser parser;

    public InputValidator(Delimiter delimiter) {
        this.delimiter = delimiter;
        this.parser = new Parser();
    }

    public String validate(String input) {
        if (input.startsWith("//")) {
            input = delimiter.parseDelimiter(input);
        }

        if (input.isEmpty()) {
            return "0";
        }

        validateNotStartsWithChar(input);
        validateNotStartsWithNegativeNumber(input);

        return this.parser.parse(input, delimiter);
    }

    private void validateNotStartsWithNegativeNumber(String input) {
        if (input.startsWith("-")) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_NUMBER);
        }
    }

    private void validateNotStartsWithChar(String input) {
        if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException(ERROR_STARTS_WITH_CHAR);
        }
    }

}
