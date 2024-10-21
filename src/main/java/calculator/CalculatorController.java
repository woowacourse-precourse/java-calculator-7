package calculator;

import calculator.io.InputConsoleHandler;
import calculator.io.OutputConsoleHandler;

public class CalculatorController {

    private final InputConsoleHandler inputConsoleHandler;
    private final OutputConsoleHandler outputConsoleHandler;
    private final Calculator calculator;


    public CalculatorController(InputConsoleHandler inputConsoleHandler, OutputConsoleHandler outputConsoleHandler,
                                Calculator calculator) {
        this.inputConsoleHandler = inputConsoleHandler;
        this.outputConsoleHandler = outputConsoleHandler;
        this.calculator = calculator;
    }


    public void run() {
        inputConsoleHandler.showInputGuideMessage();

        String[] operands = inputConsoleHandler.getUserInput();
        double result = calculator.sum(operands);

        outputConsoleHandler.showCalculatedResult(result);
//            outputConsoleHandler.showContinueMessage();
//
//            if (inputConsoleHandler.askIfAppEnd()) {
//                calculator.changeStatusToEnd();
//                outputConsoleHandler.showAppExitMessage();
//            }
    }
}
