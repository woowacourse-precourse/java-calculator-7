package calculator;

import calculator.controller.CalculatorController;
import calculator.model.CustomStringParser;
import calculator.model.CustomStringParserImpl;
import calculator.model.DelimiterManagerImpl;
import calculator.model.NumberStringConverter;
import calculator.model.NumberStringConverterImpl;
import calculator.model.NumberStringSplitter;
import calculator.model.NumberStringSplitterImpl;
import calculator.view.CalculatorInputView;
import calculator.view.CalculatorOutputView;

public class Application {

    public static void main(String[] args) {
        DelimiterManagerImpl delimiterManagerImpl = new DelimiterManagerImpl();
        delimiterManagerImpl.init();

        CustomStringParser customStringParser = new CustomStringParserImpl(delimiterManagerImpl);
        CalculatorController calculatorController = getCalculatorController(delimiterManagerImpl, customStringParser);
        CalculatorInputView calculatorInputView = new CalculatorInputView();

        String inputStr = calculatorInputView.inputExpression();
        calculatorController.processInput(inputStr);
    }

    private static CalculatorController getCalculatorController(DelimiterManagerImpl delimiterManagerImpl,
                                                                CustomStringParser customStringParser) {
        NumberStringSplitter numberStringSplitter = new NumberStringSplitterImpl(delimiterManagerImpl);
        NumberStringConverter numberStringConverter = new NumberStringConverterImpl();
        CalculatorOutputView calculatorOutputView = new CalculatorOutputView();

        return new CalculatorController(customStringParser, numberStringSplitter, numberStringConverter,
                calculatorOutputView);
    }
}
