package calculator;

public class InputValidator {
    private Delimiter delimiter;
    private Parser parser;

    public InputValidator(Delimiter delimiter) {
        this.delimiter = delimiter;
        this.parser = new Parser();
    }

    public String validate(String input) {
        if (input.startsWith("//")) {
            this.delimiter = new CustomDelimiter(); // 커스텀 구분자가 있으면 CustomDelimiter로 변경
            input = delimiter.parseDelimiter(input);
        }

        if (validateEmpty(input)) {
            return "0";
        }

        validateNotStartsWithChar(input);
        validateNotStartsWithNegativeNumber(input);

        return this.parser.parse(input, delimiter);
    }

    private void validateNotStartsWithNegativeNumber(String input) {
        if (input.startsWith("-")) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
    }

    private void validateNotStartsWithChar(String input) {
        if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("커스텀 문자 지정 외에는 문자로 시작할 수 없습니다.");
        }
    }

    private boolean validateEmpty(String input) {
        return input.isEmpty();
    }
}
