package calculator.validators;

public class InvalidOperandFormatException {
    // 빈 값 및 정수 체크를 위한 함수
    public static int validateToken(String token) {
        checkEmpty(token);
        checkInteger(token);
        return checkNegativeInteger(token);
    }
    private static void checkEmpty(String str){
        if (str.isEmpty()) {
            throw new IllegalArgumentException("빈 값이 있습니다.");  // 빈 값 예외 처리
        }
    }

    private static void checkInteger(String str){
        for (char ch : str.toCharArray()) {
            if(!Character.isDigit(ch))
                throw new IllegalArgumentException("정수가 아닌 값이 있습니다");
        }
    }

    private static int checkNegativeInteger(String str){
        int integerToken = Integer.parseInt(str);
        if(integerToken < 0)
            throw new IllegalArgumentException("음수 값이 입력되었습니다");
        return integerToken;
    }
}
