package calculator.dto.request;

public record CalculatorRequest(
        String input
) {
    public static CalculatorRequest from(String input) {
        return new CalculatorRequest(input);
    }
}