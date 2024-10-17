package calculator;

public class CheckInputType {

    public static String[] checkType(String input, int inputLen, String basicDelimiter){
        if (input.equals("")){
            return null;
        }

        if (input.startsWith("//")){
            String[] operandArr = CustomDelimiterSplit.splitInput(input, inputLen, basicDelimiter);
            if (operandArr == null){
                return null;
            } else{
                return operandArr;
            }
        } else{
            String[] operandArr = BasicDelimiterSplit.splitInput(input, basicDelimiter);
            return operandArr;
        }
    }
}
