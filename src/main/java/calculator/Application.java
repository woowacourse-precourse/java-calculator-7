package calculator;

import calculator.model.DelimiterManagerImpl;
import calculator.view.CalculatorInputView;

public class Application {
    public static void main(String[] args) {

        DelimiterManagerImpl delimiterManagerImpl = new DelimiterManagerImpl();
        delimiterManagerImpl.init();

        CalculatorInputView calculatorInputView = new CalculatorInputView();
        String inputStr = calculatorInputView.inputExpression();
    }
}
