package calculator.dto;

public record CalculatorRequest(String delimiters, String calculation) {
    public static CalculatorRequest of(String delimiters, String calculation) {
        return new CalculatorRequest(delimiters, calculation);
    }
}
