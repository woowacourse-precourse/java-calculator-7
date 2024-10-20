package calculator.dto.response;

public record CalculateResponse(
        int result
) {
    public static CalculateResponse from(int result) {
        return new CalculateResponse(result);
    }
}