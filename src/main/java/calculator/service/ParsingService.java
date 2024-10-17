package calculator.service;

public class ParsingService {
    private static final int CUSTOM_START_INDEX = 2;
    private static final int CUSTOM_END_INDEX = 5;

    public static void parseOperandStr(String operandStr) {

    }

    private static void errorCheck(String str){

    }

    // 문자열의 처음이 숫자이거나 // 가 아니라면 에러 발생
    private static void checkStartingPoint(String str){
        if(str.startsWith("//") || Character.isDigit(str.charAt(0)))
            throw new IllegalArgumentException();
    }

}
