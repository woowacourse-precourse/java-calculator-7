package calculator.infra.view;

import calculator.model.CalculateSystem;

public class ResultView {
    private int result;

    private ResultView(int result) {
        this.result = result;
    }

    public static ResultView from(CalculateSystem calculateSystem) {
        Integer addedResult = calculateSystem.sum();
        return new ResultView(addedResult);
    }

    @Override
    public String toString() {
        return String.valueOf(result);
    }
}
