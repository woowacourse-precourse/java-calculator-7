package calculator.delimiterSplit;

import calculator.checkMethod.CheckRegex;

public class CustomDelimiterSplit{

    public static String[] customDelimiterSplit(String input, int inputLen, String basicDelimiter){
        int idx = input.indexOf("\\n", 2);
        String customDelimiter = basicDelimiter + "|";

        if (inputLen == idx+2){
            return null;
        }

        if (idx == -1) {
            throw new IllegalArgumentException("잘못된 커스텀 입력값 형식입니다.");
        } else{
            customDelimiter += input.substring(2, idx).replace("\\", "\\\\").replace("|", "\\|");
            customDelimiter = CheckRegex.checkRegex(customDelimiter);
        }

        String operandStr = input.substring(idx+2, inputLen);
        return operandStr.split(customDelimiter);
    }
}
