package calculator.Util;

public class NumberParser {
    //문자열을 정수로 변환 + 예외처리
    public static int parseAndValidateNumber(String number) {
        number = number.trim();
        if (number.isEmpty()) {
            throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
        }
        try {
            int intNumber = Integer.parseInt(number);
            if (intNumber < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다." + intNumber);
            }
            return intNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다." + number);
        }
    }
}
