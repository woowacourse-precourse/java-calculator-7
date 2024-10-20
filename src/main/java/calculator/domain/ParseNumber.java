package calculator.domain;

public class ParseNumber {
    public static int parseNumber(String number) {
        if (number.trim().isEmpty()) {
            return 0;
        }

        try {
            int parsedNumber = Integer.parseInt(number);

            if (parsedNumber < 0) {
                throw new IllegalArgumentException("문자열에 음수값이 있습니다.");
            }

            return parsedNumber;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
