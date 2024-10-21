package calculator;

public class Validator {
    public static void isAllNumbers(String[] splitInput) {
        for (String token : splitInput) {
            if (!isNumeric(token)) {
                throw new IllegalArgumentException("구분자 이외의 문자열이 포함되어 있습니다.");
            }
        }
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }
}