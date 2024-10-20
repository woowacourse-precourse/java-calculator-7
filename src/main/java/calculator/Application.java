package calculator;

import calculator.controller.CalculatorController;
import calculator.model.CustomDelimiterParser;
import calculator.model.CustomDelimiterParserImpl;
import calculator.model.DelimiterManagerImpl;
import calculator.model.NumberStringConverter;
import calculator.model.NumberStringConverterImpl;
import calculator.model.NumberStringSplitter;
import calculator.model.NumberStringSplitterImpl;
import calculator.model.SumCalculator;
import calculator.model.SumCalculatorImpl;
import calculator.view.CalculatorInputView;
import calculator.view.CalculatorOutputView;

public class Application {

    public static void main(String[] args) {
        DelimiterManagerImpl delimiterManagerImpl = new DelimiterManagerImpl();
        delimiterManagerImpl.init();

        CustomDelimiterParser customDelimiterParser = new CustomDelimiterParserImpl(delimiterManagerImpl);
        CalculatorController calculatorController = getCalculatorController(delimiterManagerImpl,
                customDelimiterParser);
        CalculatorInputView calculatorInputView = new CalculatorInputView();

        String inputStr = calculatorInputView.inputExpression();
        calculatorController.processInput(inputStr);
    }

    private static CalculatorController getCalculatorController(DelimiterManagerImpl delimiterManagerImpl,
                                                                CustomDelimiterParser customDelimiterParser) {
        NumberStringSplitter numberStringSplitter = new NumberStringSplitterImpl(delimiterManagerImpl);
        NumberStringConverter numberStringConverter = new NumberStringConverterImpl();
        SumCalculator sumCalculator = new SumCalculatorImpl();
        CalculatorOutputView calculatorOutputView = new CalculatorOutputView();

        return new CalculatorController(
                customDelimiterParser, numberStringSplitter, numberStringConverter, sumCalculator, calculatorOutputView
        );
    }
}
