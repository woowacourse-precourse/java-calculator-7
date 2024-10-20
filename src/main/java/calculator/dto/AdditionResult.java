package calculator.dto;

public record AdditionResult(
        int result
) {
    public static AdditionResult from(int result) {
        return new AdditionResult(result);
    }
}