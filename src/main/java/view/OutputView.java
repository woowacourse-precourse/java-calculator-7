package view;

import domain.Calculator;

public class OutputView {
    public static void printResult(Calculator calculator) {
        System.out.printf("결과 : %d", calculator.getCalculator());
    }
}
