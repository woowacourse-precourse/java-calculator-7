package calculator;

public class CalculatorService {

    NumberParser numberParser = new NumberParser();
    PatternParser patternParser = new PatternParser();

    public String[] splitInput(String input) {
        return patternParser.splitPattern(input);
    }

    public String[] replaceNumber(String[] splitInput) {
        return numberParser.replaceNumber(splitInput);
    }

    public int sumNumber(String[] splitNumberInput) {
        return numberParser.sumNumber(splitNumberInput);
    }
}
