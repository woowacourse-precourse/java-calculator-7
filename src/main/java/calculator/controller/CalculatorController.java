package calculator.controller;

import calculator.logic.CalculatorComputeResult;
import calculator.logic.CalculatorInputParser;
import calculator.util.InputUtil;
import calculator.util.MessageUtil;
import calculator.util.ValidationUtil;
import java.util.Arrays;
import java.util.List;

public class CalculatorController {

    private final InputUtil inputUtil = new InputUtil();
    private final MessageUtil messageUtil = new MessageUtil();
    private final ValidationUtil validationUtil = new ValidationUtil();
    private final CalculatorComputeResult calculatorComputeResult = new CalculatorComputeResult();
    private final CalculatorInputParser calculatorInputParser = new CalculatorInputParser();


    public void run() {
        messageUtil.printStringForSum();

        List<Integer> integerList = getIntegerListInfo();
        Integer result = calculatorComputeResult.computeResult(integerList);

        messageUtil.printResult(result);
    }

    private List<Integer> getIntegerListInfo() {
        String initialInput = inputUtil.userInput();

        if (initialInput == null || initialInput.isEmpty()) {
            return Arrays.asList(0);
        }

        validationUtil.isValidInput(initialInput);

        return calculatorInputParser.splitInitialString(initialInput);
    }


}