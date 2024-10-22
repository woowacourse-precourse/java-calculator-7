package calculator;

import calculator.controller.CalculationController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculationController calculationController = new CalculationController();

        calculationController.startCalculate();
    }

}
