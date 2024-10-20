package calculator.controller;

import calculator.input.Input;
import calculator.staticValue.StaticValue;


public class Calculator {

    private static final Input input = new Input();
    private static final CalculatorService calculatorController = new CalculatorService();


    public int Calculate(String inputString) {

        if (input.hasEmptyInput(inputString)) {
            return 0;
        }

        if (input.hasParticularValue(inputString, StaticValue.CUSTOM_SEPARATOR_REGEX.getValue())) {
            String[] splitInput = calculatorController.SplitStringUsingSeparators(
                    inputString);
            return calculateAvailableInput(splitInput);
        } else {
            String[] splitInputByBasicSeparators = inputString.split(StaticValue.BASIC_SEPARATORS_REGEX.getValue());
            return calculateAvailableInput(splitInputByBasicSeparators);
        }
    }

    private int calculateAvailableInput(String[] inputString) {
        input.checkInputAvailable(inputString);
        return calculatorController.calculateSum(inputString);
    }

}
