package calculator.presentation.response;

public final class CalculatorResponse {

    private final int result;

    private CalculatorResponse(int result) {
        this.result = result;
    }

    public static CalculatorResponse of(int result) {
        return new CalculatorResponse(result);
    }

    public int getResult() {
        return result;
    }
}
