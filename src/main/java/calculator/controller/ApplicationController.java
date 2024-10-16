package calculator.controller;

import calculator.model.InputString;

public class ApplicationController {

    private final InputString inputString;

    public ApplicationController(InputString inputString) {
        this.inputString = inputString;
    }

    public int ApplicationStart() {
        ParsingInputString parsingInputString = new ParsingInputString();
        CalculateIntegerList calculateIntegerList = new CalculateIntegerList();

        parsingInputString.findCustomChar(inputString);
        parsingInputString.parsingInput(inputString);

        return calculateIntegerList.calculate(inputString);
    }
}
