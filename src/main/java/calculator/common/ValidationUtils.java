package calculator.common;

public class ValidationUtils {

    public static boolean isNotValid(String exp) {
        if (exp == null || exp.isEmpty()) { // 빈 문자열
            return true;
        }
        if (exp.startsWith("//") && !exp.contains("\\n")) { // "//"로 시작하지만 "\n"이 없으면 예외
            return true;
        }
        return false;
    }
}
