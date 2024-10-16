package calculator.view;

import calculator.model.Calculator;

public class OutputView {
    Calculator calculator;

    public void printResult() {
        System.out.println("결과 : " + calculator.getResult());
    }
}
