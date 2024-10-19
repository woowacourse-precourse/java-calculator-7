package calculator;

import calculator.controller.CalculatorController;
import calculator.controller.converter.ExpressionToPositiveIntegerOperandConverter;
import calculator.view.input.ConsoleInputView;
import calculator.view.output.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        final ConsoleInputView inputView = new ConsoleInputView();
        final ConsoleOutputView outputView = new ConsoleOutputView();
        final ExpressionToPositiveIntegerOperandConverter converter = new ExpressionToPositiveIntegerOperandConverter();
        final CalculatorController controller = new CalculatorController(inputView, outputView, converter);

        controller.calculate();
    }
}
