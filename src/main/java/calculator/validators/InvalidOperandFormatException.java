package calculator.validators;

public class InvalidOperandFormatException {
    // 빈 값 및 정수 체크를 위한 함수
    public static int validateToken(String token) {
        checkEmpty(token);
        checkInteger(token);
        checkOverFlow(token);
        return checkNegativeInteger(token);
    }

    //구분자가 연달아 들어올 떄
    public static void checkEmpty(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("빈 값이 있습니다.");
        }
    }

    public static void checkInteger(String str) {
        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("정수가 아닌 값이 있습니다");
            }
        }
    }

    public static void checkOverFlow(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력하신 정수에서 오버플로우가 발생했습니다.");
        }

    }

    private static int checkNegativeInteger(String str) {
        int integerToken = Integer.parseInt(str);
        if (integerToken < 0) {
            throw new IllegalArgumentException("음수 값이 입력되었습니다");
        }
        return integerToken;
    }
}
