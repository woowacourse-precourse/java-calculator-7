package calculator;

import calculator.controller.StringCalculatorController;
import calculator.factory.ControllerFactory;

public class Application {

    public static void main(String[] args) {
        try {
            StringCalculatorController calculatorController = ControllerFactory.createController();  // ControllerFactory를 사용하여 Controller 생성
            calculatorController.run();  // 프로그램 실행
        } catch (IllegalArgumentException e) {
            // 예외 발생 시 메시지 출력 후 프로그램 종료
            System.out.println("오류 발생: " + e.getMessage());
            throw e;  // 예외를 다시 던져 프로그램을 종료
        }
    }

}