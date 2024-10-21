package calculator;

import calculator.controller.CalculatorController;

public class Application {
    public static void main(String[] args) {
        try {
            CalculatorController calculatorController = new CalculatorController();
            calculatorController.run();
        } catch(Exception e) {
            System.out.println("에러가 발생했습니다. 작동을 종료합니다.");
        }
    }
}
