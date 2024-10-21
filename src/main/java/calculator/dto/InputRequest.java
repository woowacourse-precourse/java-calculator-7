package calculator.dto;

public record InputRequest(
        String[] factors
) {
    public static InputRequest of(String[] factors) {
        return new InputRequest(factors);
    }
}
