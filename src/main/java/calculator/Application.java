package calculator;

import calculator.controller.StringCalculatorController;
import calculator.model.InputData;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StringCalculatorController stringCalculatorController = new StringCalculatorController();
        InputData inputData = stringCalculatorController.handoverInput();

    }
}
