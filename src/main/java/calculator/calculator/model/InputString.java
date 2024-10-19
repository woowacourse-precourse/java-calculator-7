package calculator.calculator.model;

public record InputString(String value) {
    public InputString {
        if (value == null) {
            throw new IllegalArgumentException("입력 값은 null일 수 없습니다.");
        }
        if (!value.equals(value.trim())) {
            throw new IllegalArgumentException("입력 값의 앞뒤에 공백이 있을 수 없습니다.");
        }
    }
}
