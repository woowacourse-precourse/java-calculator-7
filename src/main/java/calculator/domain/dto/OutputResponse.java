package calculator.domain.dto;

public record OutputResponse(
        int result
) {
    public static OutputResponse of(int result) {
        return new OutputResponse(result);
    }
}
