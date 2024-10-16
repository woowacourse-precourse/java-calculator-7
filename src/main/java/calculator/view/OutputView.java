package calculator.view;

import calculator.model.Calculator;

public class OutputView {

    public static void printResult(Calculator calculator) {
        System.out.println("결과 : " + calculator.getResult());
    }
}
