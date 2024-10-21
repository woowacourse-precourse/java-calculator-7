package calculator.io;

public record UserInput(
    String value
) {
    public UserInput {
        if (value == null) {
            throw new IllegalArgumentException("사용자의 입력값이 null 일 수 없습니다.");
        }
    }
}
