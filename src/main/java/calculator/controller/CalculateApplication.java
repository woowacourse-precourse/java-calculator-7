package calculator.controller;

import calculator.model.InputString;

public class CalculateApplication {

    public static int run(InputString inputString) {
        InputString afterCustom = CustomCharStrategy.findCustomChar(inputString);
        InputString afterParsing = ParsingInputString.parsingInput(afterCustom);
        return CalculateIntegerList.calculateResult(afterParsing);
    }
}
