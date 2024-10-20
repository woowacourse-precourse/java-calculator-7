package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorUseCase {

    private final CalculatorViewer calculatorViewer = new CalculatorViewer();
    private final NumberParser numberParser = new NumberParser();
    private final PatternParser patternParser = new PatternParser();

    public void startCalculate() {
        calculatorViewer.showInputPrompt();
        String input = Console.readLine();

        patternParser.validatePattern(input);
        String[] splitInput = patternParser.splitPattern(input);

        numberParser.checkNegative(splitInput);
        String[] removeNonDigitsInput = numberParser.removeNonDigits(splitInput);

        int result = numberParser.sumNumber(removeNonDigitsInput);
        calculatorViewer.displayResult(result);
    }
}
