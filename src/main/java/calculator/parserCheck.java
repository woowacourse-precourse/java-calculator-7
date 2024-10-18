package calculator;

public class parserCheck {
    public static int parserOrThrow(String num) {
        if (num.isEmpty()) {
            return 0; // 빈 문자열일 경우 0 반환
        }

        try {
            int number = Integer.parseInt(num); // 문자열을 정수로 변환
            if (number < 0) { // 음수인 경우 예외 발생
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
            }
            return number; // 음수가 아닌 경우 해당 숫자 반환
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다: " + num); // 형변환이 불가능하면 예외 발생
        }
    }
}
