package calculator.validator;

public class DelimiterValidator implements Validator {

    @Override
    public void validate(String customDelimiter) {
        if (customDelimiter == null || customDelimiter.trim().isEmpty()) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자: 구분자는 빈 값일 수 없습니다.");
        }

        if (containsNumbers(customDelimiter) || containsWhitespace(customDelimiter)) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자: 구분자는 숫자나 공백을 포함할 수 없습니다.");
        }
    }

    private boolean containsNumbers(String customDelimiter) {
        return customDelimiter.matches(".*\\d.*");
    }

    private boolean containsWhitespace(String customDelimiter) {
        return customDelimiter.matches(".*\\s.*");
    }
}
