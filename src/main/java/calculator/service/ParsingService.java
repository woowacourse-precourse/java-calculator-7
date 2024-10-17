package calculator.service;

import calculator.dto.OperandDTO;
import java.util.ArrayList;

public class ParsingService {
    private static final int CUSTOM_DELIMITER_INDEX = 2;
    private static final int EXCEPT_CUSTOM_DELIMITER_INDEX = 5;
    private static final char DEFAULT_DELIMITER1 = ',';
    private static final char DEFAULT_DELIMITER2 = ':';

    private ArrayList<Character> delimiters = new ArrayList<>();
    private ArrayList<Integer> operandList = new ArrayList<>();

    public ParsingService() {
        delimiters.add(DEFAULT_DELIMITER1);
        delimiters.add(DEFAULT_DELIMITER2);
    }

    public OperandDTO parseOperandStr(String operandStr) {
        if(checkIFStringEmpty(operandStr)){
            operandList.add(0);
            return new OperandDTO(operandList);
        }

        errorCheck(operandStr);

        return new OperandDTO(operandList);
    }

    //입력받은 문자열이 없을 때 true return
    private static Boolean checkIFStringEmpty(String operandStr){
        if(operandStr.isEmpty()) return true;
        return false;
    }

    private static void errorCheck(String operandStr){
        checkStartingPoint(operandStr);
        checkEndPoint(operandStr);
        checkFrontAndBackOfCustomDelimiter(operandStr);
    }

    // 문자열의 처음이 숫자이거나 // 가 아니라면 에러 발생
    private static void checkStartingPoint(String OperandStr){
        if(OperandStr.startsWith("//") || Character.isDigit(OperandStr.charAt(0)))
            throw new IllegalArgumentException();
    }

    //문자열의 마지막이 숫자로 끝나지 않으면 에러 발생
    private static void checkEndPoint(String operandStr){
        char endOfString = operandStr.charAt(operandStr.length() - 1);
        if(!Character.isDigit(endOfString))
            throw new IllegalArgumentException();
    }

    private static void checkFrontAndBackOfCustomDelimiter(String operandStr){
        if(operandStr.startsWith("//") && !operandStr.substring(3, 5).equals("\\n")){
            throw new IllegalArgumentException();
        }
    }

    private void parse(String operandStr){
        if(operandStr.startsWith("//")){
            delimiters.add(operandStr.charAt(CUSTOM_DELIMITER_INDEX));
        }

        operandStr = operandStr.substring(EXCEPT_CUSTOM_DELIMITER_INDEX);


    }
    
    private static void checkInteger(char ch){
        if(!Character.isDigit(ch))
            throw new IllegalArgumentException();
    }
}
