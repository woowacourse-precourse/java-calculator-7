package calculator.controller;

import calculator.model.InputString;
import java.util.List;

public class ScenarioRunner {

    private final InputString inputString;

    public ScenarioRunner(InputString inputString) {
        this.inputString = inputString;
    }

    public int runScenario() {
        ParsingInputString parsingInputString = new ParsingInputString();
        CalculateIntegerList calculateIntegerList = new CalculateIntegerList();
        FindCustomChar findCustomChar = new FindCustomChar();
        findCustomChar.setCustomChar(inputString);

        if (inputString.getInput().isEmpty()) {
            inputString.setNumberList(List.of(0));
        } else {
            List<String> numberStringList = parsingInputString.parsingInput(inputString);
            parsingInputString.getNumberList(inputString, numberStringList);
        }

        return calculateIntegerList.calculateResult(inputString);
    }
}
