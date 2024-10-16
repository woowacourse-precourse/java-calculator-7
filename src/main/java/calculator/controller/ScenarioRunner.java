package calculator.controller;

import calculator.model.InputString;
import java.util.List;

public class ScenarioRunner {

    public static int runScenario(InputString inputString) {
        FindCustomChar.setCustomChar(inputString);

        if (inputString.getInput().isEmpty()) {
            inputString.setNumberList(List.of(0));
        } else {
            List<String> numberStringList = ParsingInputString.parsingInput(inputString);
            ParsingInputString.getNumberList(inputString, numberStringList);
        }

        return CalculateIntegerList.calculateResult(inputString);
    }
}
