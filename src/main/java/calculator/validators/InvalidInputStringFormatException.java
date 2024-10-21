package calculator.validators;

import static calculator.utils.Constants.CUSTOM_DELIMITER_END_WRAPPER;
import static calculator.utils.Constants.CUSTOM_DELIMITER_START_WRAPPER;

public class InvalidInputStringFormatException {
    public static void errorCheck(String operandStr){
        checkIfStringWhiteSpace(operandStr);
        checkStartingPoint(operandStr);
        checkEndPoint(operandStr);
        checkFrontAndBackOfCustomDelimiter(operandStr);
    }

    public static void checkIfStringWhiteSpace(String operandStr){
        if(!operandStr.isEmpty() && operandStr.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    // 문자열의 처음이 숫자이거나 // 가 아니라면 에러 발생
    public static void checkStartingPoint(String operandStr){
        if(!(operandStr.startsWith(CUSTOM_DELIMITER_START_WRAPPER) || Character.isDigit(operandStr.charAt(0))))
            throw new IllegalArgumentException();
    }

    //문자열의 마지막이 숫자로 끝나지 않으면 에러 발생
    public static void checkEndPoint(String operandStr){
        char endOfString = operandStr.charAt(operandStr.length() - 1);
        if(!Character.isDigit(endOfString))
            throw new IllegalArgumentException();
    }

    public static void checkFrontAndBackOfCustomDelimiter(String operandStr){
        if(operandStr.startsWith(CUSTOM_DELIMITER_START_WRAPPER) && !operandStr.startsWith(CUSTOM_DELIMITER_END_WRAPPER, 3)){
            throw new IllegalArgumentException();
        }
    }
}
