package calculator;


import calculator.controller.CalculateController;
import calculator.domain.Calculator;
import calculator.domain.service.DelimiterParser;
import calculator.domain.service.OperandParser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CalculateController controller =
                new CalculateController(new InputView(),
                        new OutputView(),
                        new OperandParser(),
                        new DelimiterParser(),
                        new Calculator());
        controller.calculate();
    }
}
