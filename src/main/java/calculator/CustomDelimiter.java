package calculator;

public class CustomDelimiter {
    private final String customDelimiter;

    public CustomDelimiter(String customDelimiter) {
        if (customDelimiter.isBlank()) {
            throw new IllegalArgumentException("커스텀 구분자에 입력값에는 빈칸이 들어갈 수 없습니다.");
        }

        if (customDelimiter.matches("\\d+")) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자를 사용할 수 없습니다.");
        }

        this.customDelimiter = customDelimiter;
    }


    public String getCustomDelimiter() {
        return customDelimiter;
    }
}
