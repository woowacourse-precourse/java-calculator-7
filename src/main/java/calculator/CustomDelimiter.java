package calculator;

public class CustomDelimiter {
    public static final String ONLY_DIGITS = "\\d+";

    private final String customDelimiter;

    public CustomDelimiter(String customDelimiter) {
        validate(customDelimiter);
        this.customDelimiter = customDelimiter;
    }

    private void validate(String customDelimiter) {
        if (customDelimiter.isBlank()) {
            throw new IllegalArgumentException("커스텀 구분자에 입력값에는 빈칸이 들어갈 수 없습니다.");
        }

        if (customDelimiter.matches(ONLY_DIGITS)) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자를 사용할 수 없습니다.");
        }

        if (customDelimiter.equals(",") || customDelimiter.equals(":")) {
            throw new IllegalArgumentException("커스텀 구분자에 기본 구분자를 입력할수 없습니다");
        }

    }

    public String getCustomDelimiter() {
        return customDelimiter;
    }
}
