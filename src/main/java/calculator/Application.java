package calculator;

import calculator.controller.CalculatorController;

/**
 * [문제] 계산기 구현하기
 * @author gladhee
 * @version 1.0
 */
public class Application {
    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController();

        calculatorController.run();
    }
}
