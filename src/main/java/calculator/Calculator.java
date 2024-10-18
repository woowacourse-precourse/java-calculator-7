package calculator;

import java.util.List;

public class Calculator {
    public static int calculateSum(String inputString) {
        List<String> splitValues;

        if(Validator.checkDefaultDelimterFormat(inputString)){
            splitValues = StringSplitter.SplitbyDefaultDelimiter(inputString);
            return sumSplitValues(splitValues);
        }

        if (Validator.checkCustomDelimiterFormat(inputString)){
            splitValues = StringSplitter.SplitbyCustomDelimiter(inputString);
            return sumSplitValues(splitValues);
        }
        return 0;
    }
    private static int sumSplitValues(List<String> splitValues) {
        int sumResult = 0;
        for (String part : splitValues) {
            Validator.checkNagativeInt(Integer.parseInt(part));
            sumResult += Integer.parseInt(part);
        }
        return sumResult;
    }
}
