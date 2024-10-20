package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorInputView {

    private final CalculatorOutputView calculatorOutputView = new CalculatorOutputView();

    public String inputExpression() {

        calculatorOutputView.printInstruction();
        String input = Console.readLine();

        return input;
    }
}
