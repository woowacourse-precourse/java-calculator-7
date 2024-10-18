package calculator;

import calculator.controller.CalculatorController;
import calculator.controller.service.CalculatorControllerFactory;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //TODO 예외 사항 테스트 돌려보고, 리팩토링해보자 그리고 해당 메서드가 해당 클래스에 적합한지 고민해보자
        CalculatorController calculatorController = CalculatorControllerFactory.create();
        calculatorController.run();
    }
}

