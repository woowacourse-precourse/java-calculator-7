package calculator.dto.response;

public record CalculateResultResponse(
        int result
) {
    public static CalculateResultResponse from(int result) {
        return new CalculateResultResponse(result);
    }
}
