package calculator.dto.request;

public record CalculatorRequest(
        String delimiters,
        String targetInput
) {
    public static CalculatorRequest of(String delimiters, String targetInput) {
        return new CalculatorRequest(delimiters, targetInput);
    }
}
