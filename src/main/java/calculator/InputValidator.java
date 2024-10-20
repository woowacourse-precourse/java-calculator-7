package calculator;

public class InputValidator {
    private final CustomDelimiter customDelimiter;

    // 생성자를 통해 의존성 주입
    public InputValidator(CustomDelimiter customDelimiter) {
        this.customDelimiter = customDelimiter;
    }

    public String validate(String input) {
        String result = "";

        if (validateStartsWithDelimiter(input)) {
            result = customDelimiter.extractCustomDelimiter(input);
            return Parser.startsWithCustomDelimiter(customDelimiter.getCustomDelimiter(), result);
        }

        if (validateEmpty(input)) {
            return result = "0";
        }

        validateNotStartsWithChar(input);
        validateNotStartsWithNegativeNumber(input);

        return Parser.startsWithPositiveNumber(input);
    }

    private void validateNotStartsWithNegativeNumber(String input) {
        if (input.startsWith("-")) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
    }

    private void validateNotStartsWithChar(String input) {
        if (!isStartsWithDigit(input)) {
            throw new IllegalArgumentException("커스텀 문자 지정 외에는 문자로 시작할 수 없습니다.");
        }
    }

    private boolean isStartsWithDigit(String input) {
        return Character.isDigit(input.charAt(0));
    }

    protected boolean validateStartsWithDelimiter(String input) {
        return input.startsWith("//");
    }

    private boolean validateEmpty(String input) {
        return input.isEmpty();
    }
}
