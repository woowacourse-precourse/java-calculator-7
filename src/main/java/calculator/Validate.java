package calculator;

public class Validate {

    public static void check(String str) {

        // 커스텀 구분자의 경우 구분자 체크
        if (str.startsWith("//")) {
            String customDelimiter = str.substring(2, 3); // 커스텀 구분자
            String numbers = str.substring(5); // 구분자로 나눠야 하는 숫자들
            if (!numbers.matches("^[0-9" + customDelimiter + "]+$")) {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
        } else { // 기본 구분자 체크
            if (!str.matches("^[0-9:,]+$")) {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
        }
    }
}
