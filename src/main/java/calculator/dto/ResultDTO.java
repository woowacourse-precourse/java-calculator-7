package calculator.dto;

public class ResultDTO {
    private int calculationResult;

    public ResultDTO(int calculationResult) {
        this.calculationResult = calculationResult;
    }

    public int getCalculationResult() {
        return calculationResult;
    }

    public void setCalculationResult(int calculationResult) {
        this.calculationResult = calculationResult;
    }
}
