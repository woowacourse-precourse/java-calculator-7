package calculator.parsing;

public class StringNumberParser {

    public long parseNumber(String number) {
        if (number.isEmpty()) {
            return 0L;
        }
        return parseValidNumber(number);
    }

    private long parseValidNumber(String number) {
        try {
            return Long.parseLong(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식: " + "'" + number + "'");
        }
    }

}
