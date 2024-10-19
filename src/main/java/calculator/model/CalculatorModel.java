package calculator.model;

public final class CalculatorModel {
    public boolean isCustom(String input) {
        return input.startsWith("//") && input.contains("\\n");
    }
}
