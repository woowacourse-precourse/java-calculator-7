package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.CalculatorView;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class CalculatorController {

    private final CalculatorView calcView;
    private final CalculatorService calcService;

    public CalculatorController(CalculatorView calcView, CalculatorService calcService) {
        this.calcView = calcView;
        this.calcService = calcService;
    }

    public void start() {

        calcView.printStartMsg();
        String userInput = calcView.getUserInput();

        String processedInput = calcService.detectSeparators(userInput);

        ArrayList<String> splitResult = calcService.processingInput(processedInput);
        BigInteger result = calcService.calcSplitResult(splitResult);

        calcView.printResultMsg(result);
    }
}
