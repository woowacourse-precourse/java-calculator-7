package calculator;

public class StringCalculator {
    NumberParser numberParser;
    Delimiter delimiter;
    public StringCalculator(String input) {
        delimiter = new Delimiter(input);
        numberParser = new NumberParser(delimiter);
        numberParser.parseNumber(input);
    }

    public Integer add() {
        Integer totalSum = 0;
        for(int i = 0; i < numberParser.getSize(); i ++) {
            totalSum += numberParser.getNumberAt(i);
        }
        return totalSum;
    }
}
