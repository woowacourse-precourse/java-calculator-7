package calculator.dto.request;

public class CalculatorRequest {
    private final String input;

    public CalculatorRequest(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }
}
