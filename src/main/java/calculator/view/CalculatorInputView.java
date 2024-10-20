package calculator.view;

public class CalculatorInputView {

    private final CalculatorOutputView calculatorOutputView = new CalculatorOutputView();

    public void inputExpression() {

        calculatorOutputView.printInstruction();
    }
}
