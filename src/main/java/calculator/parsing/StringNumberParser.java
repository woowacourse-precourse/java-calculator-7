package calculator.parsing;

public class StringNumberParser {

    public long parseNumber(String number) {
        if (number == null || number.isEmpty()) {
            return 0L;
        }

        return parseValidNumber(number);
    }

    private long parseValidNumber(String number) {
        try {
            long num = Long.parseLong(number);
            validatePositiveNumber(num, number);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식: " + number);
        }
    }

    private void validatePositiveNumber(long num, String number) {
        if (num < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }
    }

}
