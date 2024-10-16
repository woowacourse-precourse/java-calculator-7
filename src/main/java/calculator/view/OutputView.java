package calculator.view;

import calculator.domain.Calculator;

public class OutputView {

    public void printResult(Calculator calculator) {
        System.out.printf("결과 : %d\n", calculator.addAll());
    }
}
