package calculator;

import calculator.controller.calculatorController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        calculatorController calculatorController = new calculatorController();
        while(true){
            calculatorController.calculator();
        }
    }
}
