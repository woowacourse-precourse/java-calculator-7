package calculator;

public class Calculator {

    public int calculateSum(String[] splitResults) {
        var delimiterParser = new DelimiterParser();
        int result = 0;

        for(String splitResult : splitResults) {
            if(splitResult.isEmpty()) {
                result += 0;
            } else {
                result += delimiterParser.convertToNumber(splitResult);
            }
        }

        return result;
    }
}
