package calculator;

public class CustomDelimiter {
    private final String customDelimiter;

    public CustomDelimiter(String customDelimiter) {
        if (customDelimiter.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("커스텀 구분자는 문자만 입력가능합니다");
        }
        this.customDelimiter = customDelimiter;
    }


    public String getCustomDelimiter() {
        return customDelimiter;
    }
}
