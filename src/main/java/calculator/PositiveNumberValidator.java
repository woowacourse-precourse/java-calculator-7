package calculator;

public class PositiveNumberValidator {
    public long validateAndParse(String number) {
        try {
            long parsedNumber = Long.parseLong(number.trim());
            if (parsedNumber < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + parsedNumber);
            }
            if (parsedNumber > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("입력된 숫자가 허용 범위를 초과했습니다: " + parsedNumber);
            }
            return parsedNumber;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("잘못된 숫자 형식: " + number);
        }
    }
}
