package calculator.domain.dto;

public record InputRequest(
        String delimiters,
        String targetInput
) {
    public static InputRequest of(String delimiters, String targetInput) {
        return new InputRequest(delimiters, targetInput);
    }
}