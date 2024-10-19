package calculator;

public class CalculatorService {

    final NumberParser numberParser = new NumberParser();
    final PatternParser patternParser = new PatternParser();


    public int calculate(String input) {
        String[] splitInput = patternParser.splitPattern(input);
        String[] splitInputReplaceNumber = numberParser.replaceNumber(splitInput);
        int result = numberParser.sumNumber(splitInputReplaceNumber);

        return result;
    }
}
