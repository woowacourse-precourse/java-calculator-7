package calculator.dto;

public record AdditionResult(String result) {
    public static AdditionResult from(double result) {
        if (result % 1 == 0) {
            return new AdditionResult(String.valueOf((long) result));
        }
        return new AdditionResult(String.valueOf(result));
    }
}