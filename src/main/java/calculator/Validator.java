package calculator;

public class Validator {
    public static void isAllPositiveNumbers(int[] numbers) {
        for (int number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("양수만 입력하실 수 있습니다.");
            }
        }
    }

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