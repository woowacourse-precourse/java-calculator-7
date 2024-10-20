package calculator.validator;

public class InputValidator {
    private final ValueValidator valueValidator = new ValueValidator();
    private final DelimiterValidator delimiterValidator = new DelimiterValidator();
    private final NumberValidator numberValidator = new NumberValidator();

    // 전체 입력 유효성 검증
    public boolean isValidInput(String input) {
        if (!valueValidator.isLastDigit(input)) {
            return false; // 마지막 문자가 숫자가 아닌 경우
        }

        if (delimiterValidator.containsInvalidDelimiters(input)) {
            return false; // 잘못된 구분자가 있는 경우
        }

        return !numberValidator.containsInvalidCharacters(input); // 숫자 검증
    }
}