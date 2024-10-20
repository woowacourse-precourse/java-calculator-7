package calculator;

import calculator.controller.CalculatorController;
import calculator.model.DelimiterManagerImpl;
import calculator.view.CalculatorInputView;
import calculator.view.CalculatorOutputView;

public class Application {
    public static void main(String[] args) {

        DelimiterManagerImpl delimiterManagerImpl = new DelimiterManagerImpl();
        delimiterManagerImpl.init();

        CalculatorController calculatorController = new CalculatorController(new CalculatorOutputView());
        CalculatorInputView calculatorInputView = new CalculatorInputView();

        String inputStr = calculatorInputView.inputExpression();
        calculatorController.processInput(inputStr);
    }
}
