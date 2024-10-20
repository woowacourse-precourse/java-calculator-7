package calculator;

public class Validator {

    public static void validateNumbers(String[] numbers) {
        for (String number : numbers) {
            if (!isNumeric(number)) {
                throw new IllegalArgumentException("잘못된 입력 값입니다.");
            }

            int parsedNumber = Integer.parseInt(number);
            if (parsedNumber < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
        }
    }

    public static void validateCustomDelimiterFormat(String word) {
        if (!word.contains("//") || !word.contains("\\n")) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
        }

        String regex = word.substring(2, 3);
        // 구분자가 숫자인 경우 예외 처리
        if (Character.isDigit(regex.charAt(0))) {
            throw new IllegalArgumentException("구분자는 숫자가 될 수 없습니다.");
        }
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
