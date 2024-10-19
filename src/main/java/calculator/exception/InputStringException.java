package calculator.exception;

import calculator.domain.Delimiters;
import calculator.domain.Numbers;

public class InputStringException {
    public Numbers validateInputPattern(String inputString, Numbers numbers, Delimiters delimiters){
        if(inputString.contains("//") || inputString.contains("\\n")) {
            isCustomDelimiterDeclaredInStandardFormat(inputString);
        }

        return new Numbers();
    }

    public static void isCustomDelimiterDeclaredInStandardFormat(String inputString){
        int startIdx = inputString.indexOf("//");
        int endIdx = inputString.lastIndexOf("\\n");
        if(startIdx == -1 || endIdx == -1){
            throw new IllegalArgumentException();
        }
        String checkInputString = inputString.substring(startIdx+2, endIdx);
        if(!(startIdx ==0 && endIdx == 3 && checkInputString.length()==1 && !Character.isDigit(checkInputString.charAt(0)))){
            throw new IllegalArgumentException();
        }
    }
}
