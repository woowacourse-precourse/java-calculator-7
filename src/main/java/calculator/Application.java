package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.facade.CalculatorFacadeImpl;
import calculator.util.convertor.InputStringConvertor;
import calculator.util.convertor.StringConvertor;
import calculator.util.parser.InputStringParser;
import calculator.util.parser.StringParser;
import calculator.util.validator.InputStringValidator;
import calculator.util.validator.StringValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final StringConvertor<Integer> inputStringConvertor = new InputStringConvertor();
        final StringParser inputStringParser = new InputStringParser();
        final StringValidator inputStringValidator = new InputStringValidator(inputStringParser);
        final Calculator calculator = new Calculator();
        final CalculatorFacadeImpl calculatorFacade = new CalculatorFacadeImpl(inputStringConvertor, inputStringParser,
                inputStringValidator, calculator);
        final CalculatorController calculatorController = new CalculatorController(inputView, outputView,
                calculatorFacade);
        calculatorController.run();
    }
}
