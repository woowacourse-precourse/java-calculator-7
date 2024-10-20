package calculator.view;

public class Validator {

    public static String[] validateInput(String input) {
        String delimiter = "[,:]";

        if (input.startsWith("//")) {
            int customDelimiterEndIndex = input.indexOf("\\n");
            if (customDelimiterEndIndex == -1) {
                throw new IllegalArgumentException("유효하지 않는 입력 형식입니다.");
            }
            delimiter = input.substring(2, customDelimiterEndIndex);
            input = input.substring(customDelimiterEndIndex + 2);
        }

        return input.split(delimiter);
    }

    public static int parseNumber(String number) {
        try {
            int parsedNumber = Integer.parseInt(number);
            if (parsedNumber < 0) {
                throw new IllegalArgumentException("음수는 유효하지 않는 입력 형식입니다.");
            }
            return parsedNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않는 입력 형식입니다.");
        }
    }
}
