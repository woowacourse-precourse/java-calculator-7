package calculator.utils;

public class InvalidInputStringFormatException {
    public static void errorCheck(String operandStr){
        checkStartingPoint(operandStr);
        checkEndPoint(operandStr);
        checkFrontAndBackOfCustomDelimiter(operandStr);
    }

    // 문자열의 처음이 숫자이거나 // 가 아니라면 에러 발생
    public static void checkStartingPoint(String OperandStr){
        if(!(OperandStr.startsWith("//") || Character.isDigit(OperandStr.charAt(0))))
            throw new IllegalArgumentException();
    }

    //문자열의 마지막이 숫자로 끝나지 않으면 에러 발생
    public static void checkEndPoint(String operandStr){
        char endOfString = operandStr.charAt(operandStr.length() - 1);
        if(!Character.isDigit(endOfString))
            throw new IllegalArgumentException();
    }

    public static void checkFrontAndBackOfCustomDelimiter(String operandStr){
        if(operandStr.startsWith("//") && !operandStr.substring(3, 5).equals("\\n")){
            throw new IllegalArgumentException();
        }
    }
}
