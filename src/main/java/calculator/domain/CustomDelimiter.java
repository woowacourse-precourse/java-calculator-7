package calculator.domain;

public class CustomDelimiter {
    private final String value;

    public CustomDelimiter(String value) {
        validateCustomDelimiterLength(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private void validateCustomDelimiterLength(String value) {
        if (value.length() != 1) { //커스텀 구분자의 길이가 1인지 확인
            throw new IllegalArgumentException("구분자는 길이 1의 문자여야합니다");
        }
    }
}
