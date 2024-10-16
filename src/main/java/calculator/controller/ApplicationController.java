package calculator.controller;

import calculator.model.InputString;
import java.util.List;

public class ApplicationController {

    private final InputString inputString;

    public ApplicationController(InputString inputString) {
        this.inputString = inputString;
    }

    public int ApplicationStart() {
        ParsingInputString parsingInputString = new ParsingInputString();
        CalculateIntegerList calculateIntegerList = new CalculateIntegerList();

        parsingInputString.findCustomChar(inputString);
        if (inputString.getInput().isEmpty()) {
            inputString.setNumberList(List.of(0));
        } else {
            List<String> numberStringList = parsingInputString.parsingInput(inputString);
            parsingInputString.getNumberList(inputString, numberStringList);
        }

        return calculateIntegerList.calculate(inputString);
    }
}
