package calculator.util;

public class NumberValidator {

    /**
     * StringCalculator 에서 숫자 검증 부분 책임 분리
     *
     * @param number
     */
    public void validate(String number) {
        System.out.println("NumberValidator - 검증 대상 숫자: " + number);
        try {
            int value = Integer.parseInt(number.trim());
            if (value <= 0) {
                // 들어온 값이 음수라면 사용자 입력 오류 발생
                throw new IllegalArgumentException("숫자는 양수여야 합니다: " + number);
            }
        } catch (NumberFormatException e) {
            //변환하는 값이 숫자가 아니라면? 오류 발생
            throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다: " + number);
        }
    }
}