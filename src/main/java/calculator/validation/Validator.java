package calculator.validation;

public class Validator {

    public static void validateCustomSeparator(String input) {
        if (input.startsWith("//")) {
            if (!input.contains("\\n")) {
                throw new IllegalArgumentException("커스텀 구분자가 잘못 입력되었습니다.");
            }
        }
    }

    public static void validateChar(String[] strings) {
        for(String s : strings) {
            if (!s.isEmpty() && !s.equals("//")) {
                try {
                    int number = Integer.parseInt(s);
                    validateNegative(number);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자가 아닌 형식이 있습니다" + s);
                }
            }
        }
    }

    public static void validateNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수가 있습니다");
        }
    }
}
