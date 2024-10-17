package calculator.dto.response;

public record CalculatorResponse(
        int result
) {
    public static CalculatorResponse from(int result) {
        return new CalculatorResponse(result);
    }
}