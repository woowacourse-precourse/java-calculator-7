package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorInputView {

    private final CalculatorOutputView calculatorOutputView = new CalculatorOutputView();

    public String inputExpression() {

        calculatorOutputView.printInstruction();
        String input = Console.readLine();

        if (input == null) {
            throw new IllegalArgumentException(Message.NO_INPUT.getMessage());
        }

        return input.stripLeading().stripTrailing();
    }
}
