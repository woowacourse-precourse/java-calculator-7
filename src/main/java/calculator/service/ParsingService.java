package calculator.service;

import java.util.ArrayList;

public class ParsingService {
    private static final int CUSTOM_START_INDEX = 2;
    private static final int CUSTOM_END_INDEX = 5;

    private ArrayList<Integer> operandList = new ArrayList<>();

    public void parseOperandStr(String operandStr) {
        if(checkIFStringEmpty(operandStr)){
            operandList.add(0);
        }


    }

    //입력받은 문자열이 없을 때 true return
    private static Boolean checkIFStringEmpty(String operandStr){
        if(operandStr.isEmpty()) return true;
        return false;
    }

    private static void errorCheck(String operandStr){
        checkStartingPoint(operandStr);
    }

    // 문자열의 처음이 숫자이거나 // 가 아니라면 에러 발생
    private static void checkStartingPoint(String OperandStr){
        if(OperandStr.startsWith("//") || Character.isDigit(OperandStr.charAt(0)))
            throw new IllegalArgumentException();
    }

}
