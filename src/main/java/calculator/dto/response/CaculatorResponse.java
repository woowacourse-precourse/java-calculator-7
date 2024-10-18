package calculator.dto.response;

public record CaculatorResponse(
        int result
) {
    public static CaculatorResponse from(int result) {
        return new CaculatorResponse(result);
    }
}
