package calculator.view;

public class CalculatorOutput implements OutputView {
    @Override
    public void printResult(Integer result) {
        System.out.printf("결과 : %d", result);
    }
}
