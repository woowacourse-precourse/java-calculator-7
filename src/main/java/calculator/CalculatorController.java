package calculator;

import java.util.List;

public class CalculatorController {
    private final CalculatorView calculatorView;
    private final CalculatorModel calculatorModel;

    public CalculatorController(CalculatorView calculatorView, CalculatorModel calculatorModel) {
        this.calculatorView = calculatorView;
        this.calculatorModel = calculatorModel;
    }

    public void run() {
        // 입력 받기
        calculatorView.printInputMessage();
        String input = calculatorView.readInput();

        // 문자열 구분하기
        List<Integer> values = calculatorModel.splitString(input);

        // 문자열 계산하기
        int result = calculatorModel.calculateSum(values);

        // 결과 출력하기
        calculatorView.printOutputMessage(result);
    }
}
