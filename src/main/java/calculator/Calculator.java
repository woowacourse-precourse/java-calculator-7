package calculator;

public class Calculator {

    public int calculateSum(String[] splitResults) {
        var delimiterParser = new DelimiterParser();
        int result = 0;
        for(int i = 0; i < splitResults.length; i++) {
            if(splitResults[i].isEmpty()) {
                result += 0;
            } else {
                result += delimiterParser.convertToNumber(splitResults[i]);
            }
        }
        return result;
    }
}
