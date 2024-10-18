package calculator.delimiterSplit;

public class BasicDelimiterSplit{

    public static String[] basicDelimiterSplit(String input, String basicDelimiter){
        String[] operandArr = input.split(basicDelimiter);
        return operandArr;
    }


}
