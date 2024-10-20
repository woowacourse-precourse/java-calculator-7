package calculator;

import calculator.controller.StringCalculatorController;
import calculator.factory.ControllerFactory;

public class Application {

    public static void main(String[] args) {
        try {
            StringCalculatorController calculatorController = ControllerFactory.createController();
            calculatorController.run();  // 프로그램 실행
        } catch (IllegalArgumentException e) {
            System.out.println("오류 발생: " + e.getMessage());
            throw e;
        }
    }

}