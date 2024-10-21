package calculator.model;

public class CalculationRequestDTO {
    private final String input;

    public CalculationRequestDTO(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }
}