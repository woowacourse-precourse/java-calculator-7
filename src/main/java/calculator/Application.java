package calculator;

import calculator.controller.CalculatorController;
import calculator.model.CustomStringParser;
import calculator.model.CustomStringParserImpl;
import calculator.model.DelimiterManagerImpl;
import calculator.model.NumberStringSplitterImpl;
import calculator.view.CalculatorInputView;
import calculator.view.CalculatorOutputView;

public class Application {

    public static void main(String[] args) {
        DelimiterManagerImpl delimiterManagerImpl = new DelimiterManagerImpl();
        delimiterManagerImpl.init();

        CustomStringParser customStringParser = new CustomStringParserImpl(delimiterManagerImpl);
        CalculatorController calculatorController = new CalculatorController(customStringParser,
                new NumberStringSplitterImpl(delimiterManagerImpl), new CalculatorOutputView());
        CalculatorInputView calculatorInputView = new CalculatorInputView();

        String inputStr = calculatorInputView.inputExpression();
        calculatorController.processInput(inputStr);
    }
}
