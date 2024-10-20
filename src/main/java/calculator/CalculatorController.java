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

        // 문자열 구분해서 정수 리스트로 변환
        List<Integer> values = calculatorModel.splitString(input);

        // 결과 계산
        int result = calculatorModel.calculateSum(values);

        // 결과 출력
        calculatorView.printOutputMessage(result);
    }
}
