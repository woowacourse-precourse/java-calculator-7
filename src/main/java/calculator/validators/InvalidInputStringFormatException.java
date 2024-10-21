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

    //스페이스만 입력되었는지 확인
    public static void checkIfStringWhiteSpace(String operandStr){
        if(!operandStr.isEmpty() && operandStr.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    // 문자열의 처음이 숫자이거나 //인지 확인
    public static void checkStartingPoint(String operandStr){
        if(!(operandStr.startsWith(CUSTOM_DELIMITER_START_WRAPPER) || Character.isDigit(operandStr.charAt(0))))
            throw new IllegalArgumentException();
    }

    //문자열의 마지막이 숫자로 끝나는지 확인
    public static void checkEndPoint(String operandStr){
        char endOfString = operandStr.charAt(operandStr.length() - 1);
        if(!Character.isDigit(endOfString))
            throw new IllegalArgumentException();
    }

    // 커스텀 문자를 구분하는 //뒤에 \\n이 오는지 확인 + 구분자 사이에 문자가 입력되었는지 확인
    public static void checkFrontAndBackOfCustomDelimiter(String operandStr){
        if(operandStr.startsWith(CUSTOM_DELIMITER_START_WRAPPER) && !operandStr.startsWith(CUSTOM_DELIMITER_END_WRAPPER, 3)){
            throw new IllegalArgumentException();
        }
    }
}
