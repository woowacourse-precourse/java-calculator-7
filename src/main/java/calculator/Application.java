package calculator;

import calculator.controller.CalculatorController;
import calculator.controller.MainController;
import calculator.domain.Separator;
import calculator.view.InputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Separator separator = new Separator();
        InputView inputView = new InputView();
        CalculatorController calculatorController = new CalculatorController(separator);

        String input = inputView.getInput();
        int result = calculatorController.run(input);
        System.out.println("결과 : " + result);
    }
}
