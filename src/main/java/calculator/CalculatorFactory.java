package calculator;



public class CalculatorFactory {
    private CalculatorFactory() {}

    public static Calculator createCalculator(String input) {

        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어 있습니다.");
        }

        if (input.startsWith("//") && input.contains("\\n")) {
            return new CustomDelimiterCalculator(input);
        } else {
            return new DefaultCalculator(input);
        }
    }
}
