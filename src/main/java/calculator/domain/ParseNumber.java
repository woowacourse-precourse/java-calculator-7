package calculator.domain;

public class ParseNumber {
    public static int parseNumber(String number) {
        if (number.trim().isEmpty()) {
            return 0;
        }

        return Integer.parseInt(number);
    }
}
