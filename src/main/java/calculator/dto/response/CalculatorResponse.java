package calculator.dto.response;

public class CalculatorResponse {
    private final int calculated;

    public CalculatorResponse(int calculated) {
        this.calculated = calculated;
    }

    public int getCalculated() {
        return calculated;
    }
}
