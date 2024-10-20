package calculator;

public class CalculatorController {
    private final CalculatorView calculatorView;
    private final CalculatorModel calculatorModel;

    public CalculatorController(CalculatorView calculatorView, CalculatorModel calculatorModel) {
        this.calculatorView = calculatorView;
        this.calculatorModel = calculatorModel;
    }

    public void runProgram() {
        String userInput = calculatorView.getUserInput();
        long[] operandArray = calculatorModel.changeStringtoLongOperandArray(userInput);

        // test용
        for (int i = 0; i < operandArray.length; i++) {
            System.out.println(operandArray[i]);
        }

    }
}
