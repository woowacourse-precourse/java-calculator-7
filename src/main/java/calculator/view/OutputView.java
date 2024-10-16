package calculator.view;

import calculator.model.Calculator;

public class OutputView {
    static Calculator calculator;

    public static void printResult() {
        System.out.println("결과 : " + calculator.getResult());
    }
}
