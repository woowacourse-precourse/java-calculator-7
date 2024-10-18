package calculator.controller;

import calculator.model.Input;

public class CalculateApplication {

    public static int doCalculate(Input input) {
        Input afterCustom = CustomSeparator.findCustomSeparator(input);
        Input afterSplit = SplitInputString.SplitString(afterCustom);
        return CalculateInteger.calculateResult(afterSplit);
    }
}
