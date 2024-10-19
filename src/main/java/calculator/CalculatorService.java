package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorService {

    private final NumberParser numberParser = new NumberParser();
    private final PatternParser patternParser = new PatternParser();

    public int calculate(String input) {

        String[] splitInput = patternParser.splitPattern(input);
        String[] splitInputReplaceNumber = numberParser.replaceNumber(splitInput);
        int result = numberParser.sumNumber(splitInputReplaceNumber);

        return result;
    }

    public String getInput() {
        return Console.readLine();
    }
}
