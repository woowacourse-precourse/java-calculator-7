package calculator.dto.request;

public record CalculateRequest(
        String input
) {
    public static CalculateRequest from(String input) {
        return new CalculateRequest(input);
    }
}
