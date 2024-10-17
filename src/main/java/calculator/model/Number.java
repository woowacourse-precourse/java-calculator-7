package calculator.model;

public record Number(
    Integer number
) {
    public static Number from(String number) {
        try {
            Integer parsedNumber = Integer.parseInt(number);
            return new Number(parsedNumber);
        } catch(NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("값은 숫자로 입력해주세요.");
        }
    }
}
