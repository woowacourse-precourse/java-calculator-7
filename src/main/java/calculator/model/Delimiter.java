package calculator.model;

public class Delimiter {

    private final String value;

    public Delimiter(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (isNumber(value)) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자일 수 없습니다.");
        }
    }

    private boolean isNumber(String value) {
        try {
            int ignored = Integer.parseInt(value);
            return true;
        } catch (NumberFormatException ignored) {
            return false;
        }
    }
}